package com.example.shaimaaderbaz.orthoclinic.activities;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.content.CursorLoader;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.example.shaimaaderbaz.orthoclinic.R;
import com.example.shaimaaderbaz.orthoclinic.adapters.ImageItemAdapter;
import com.example.shaimaaderbaz.orthoclinic.adapters.VedioItemAdapter;
import com.example.shaimaaderbaz.orthoclinic.models.ComplainItem;
import com.example.shaimaaderbaz.orthoclinic.models.LabItem;
import com.example.shaimaaderbaz.orthoclinic.models.MediaItem;
import com.example.shaimaaderbaz.orthoclinic.models.MedicalHistoryItem;
import com.example.shaimaaderbaz.orthoclinic.models.RadiationItem;
import com.example.shaimaaderbaz.orthoclinic.models.RetrofitModels;
import com.example.shaimaaderbaz.orthoclinic.presenter.EditItemPresenterImp;
import com.example.shaimaaderbaz.orthoclinic.utils.Utils;
import com.example.shaimaaderbaz.orthoclinic.views.EditItemsView;
import com.vansuita.pickimage.bean.PickResult;
import com.vansuita.pickimage.bundle.PickSetup;
import com.vansuita.pickimage.dialog.PickImageDialog;
import com.vansuita.pickimage.enums.EPickType;
import com.vansuita.pickimage.listeners.IPickClick;
import com.vansuita.pickimage.listeners.IPickResult;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EditItemActivity extends AppCompatActivity implements EditItemsView, IPickResult,
        ImageItemAdapter.ImageItemAdapterListener,
        VedioItemAdapter.VedioItemAdapterListener,
        ViewPagerEx.OnPageChangeListener
{
    private static RadiationItem radiationItem;
    private int mRadiationtId;
    private static LabItem labItem;
    private static ComplainItem complainItem;
    private static MedicalHistoryItem medicalHistoryItem;
    private int mLabId;
    private int mHistoryId;
    private int mCompId;
    private int obj_id;
    private int owner;
    private static final String RADIATION_ID_KEY = "radiation_id";
    private static final String PATIENT_KEY = "patient_key";
    private static final String LAB_ID_KEY = "lab_id";
    private static final String COMPLAIN_ID_KEY = "complain_id";
    private static final String HISTORY_ID_KEY = "history_id";

    Context mContext;

    ImageItemAdapter imageItemAdapter;
    VedioItemAdapter vedioItemAdapter;
    EditItemPresenterImp presenter;
    @BindView(R.id.edit_field_name_text)
    TextView edit_field_name_text;
    @BindView(R.id.edit_info_edit_text)
    EditText edit_info_edit_text;
    @BindView(R.id.btnEdit)
    Button btnEdit;
    @BindView(R.id.btnUploadVedios)
    Button btnUploadVedios;
    @BindView(R.id.btnUploadImages)
    Button btnUploadImages;
    @BindView(R.id.btnDelete)
    Button btnDelete;

    @BindView(R.id.recyclerViewItemUploadImages)
    RecyclerView recyclerViewItemUploadImages;
    @BindView(R.id.recyclerViewItemUploadVedios)
    RecyclerView recyclerViewItemUploadVedios;
    // @BindView(R.id.progress)
    // ProgressBar mProgress;

    public static void start(Context context, int radiationId, RadiationItem radiationItemO) {
        Intent starter = new Intent(context, EditItemActivity.class);
        starter.putExtra(RADIATION_ID_KEY, radiationId);
        //  starter.putExtra(operationsItem, operationsItemO);
        radiationItem = radiationItemO;
        context.startActivity(starter);
    }

    public static void start(Context context, int labId, LabItem labItemO) {
        Intent starter = new Intent(context, EditItemActivity.class);
        starter.putExtra(LAB_ID_KEY, labId);
        labItem = labItemO;
        context.startActivity(starter);
    }

    public static void start(Context context, int comoId, ComplainItem complainItemO) {
        Intent starter = new Intent(context, EditItemActivity.class);
        starter.putExtra(COMPLAIN_ID_KEY, comoId);
        complainItem = complainItemO;
        context.startActivity(starter);
    }

    public static void start(Context context, int historyId, MedicalHistoryItem medicalHistoryItemO) {
        Intent starter = new Intent(context, EditItemActivity.class);
        starter.putExtra(HISTORY_ID_KEY, historyId);
        medicalHistoryItem = medicalHistoryItemO;
        context.startActivity(starter);
    }

    List<MediaItem> mediaItems = null;

    List<MediaItem> mediaItemsImages = new ArrayList<MediaItem>();
    List<MediaItem> mediaItemsVedios = new ArrayList<MediaItem>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        mContext = this;
        Bundle extras = getIntent().getExtras();
        presenter = new EditItemPresenterImp(this);

        if (getIntent().getIntExtra(RADIATION_ID_KEY, 0) != 0) {
            mRadiationtId = getIntent().getIntExtra(RADIATION_ID_KEY, 0);
        } else {
            //throw new RuntimeException("INVALID RADIATION ID");
        }

        if (getIntent().getIntExtra(LAB_ID_KEY, 0) != 0) {
            mLabId = getIntent().getIntExtra(LAB_ID_KEY, 0);
        } else {
            //throw new RuntimeException("INVALID LAB ID");
        }
        if (getIntent().getIntExtra(COMPLAIN_ID_KEY, 0) != 0) {
            mCompId = getIntent().getIntExtra(COMPLAIN_ID_KEY, 0);
        } else {
            //throw new RuntimeException("INVALID LAB ID");
        }

        if (getIntent().getIntExtra(HISTORY_ID_KEY, 0) != 0) {
            mHistoryId = getIntent().getIntExtra(HISTORY_ID_KEY, 0);
        } else {
            //throw new RuntimeException("INVALID LAB ID");
        }
        ButterKnife.bind(this);
        if (radiationItem != null) {
            edit_field_name_text.setText(radiationItem.getName());
            edit_info_edit_text.setText(radiationItem.getInfo());
            btnUploadImages.setVisibility(View.VISIBLE);
            btnUploadVedios.setVisibility(View.VISIBLE);
            mediaItems = radiationItem.getMediaItems();
        }

        if (labItem != null) {
            edit_field_name_text.setText(labItem.getName());
            edit_info_edit_text.setText(labItem.getInfo());
            btnUploadImages.setVisibility(View.VISIBLE);
            btnUploadVedios.setVisibility(View.VISIBLE);
            mediaItems = labItem.getMediaItems();
        }

        if (complainItem != null) {
            edit_field_name_text.setText(complainItem.getName());
            edit_info_edit_text.setText(complainItem.getInfo());
            btnUploadImages.setVisibility(View.VISIBLE);
            btnUploadVedios.setVisibility(View.VISIBLE);
            mediaItems = complainItem.getMediaItems();
        }

        if (medicalHistoryItem != null) {
            edit_field_name_text.setText(medicalHistoryItem.getState_name());
            edit_info_edit_text.setText(medicalHistoryItem.getInfo());
            btnUploadImages.setVisibility(View.INVISIBLE);
            btnUploadVedios.setVisibility(View.INVISIBLE);
        }
        for (int i = 0; i < mediaItems.size(); i++) {
            if (mediaItems.get(i).getType() == 1) {
                mediaItemsImages.add(mediaItems.get(i));
            } else if (mediaItems.get(i).getType() == 2) {
                mediaItemsVedios.add(mediaItems.get(i));
            }
            showImages(mediaItemsImages);
            showVedios(mediaItemsVedios);
        }
        btnEdit.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View view) {
                                           if (radiationItem != null) {
                                               String info = edit_info_edit_text.getText().toString();
                                               radiationItem.setInfo(info);
                                               presenter.EditItemRadiationToServer(mRadiationtId, radiationItem);
                                               radiationItem = null;
                                               //btnUploadImages.setVisibility(View.VISIBLE);
                                               //btnUploadVedios.setVisibility(View.VISIBLE);

                                           }
                                           if (labItem != null) {
                                               String info = edit_info_edit_text.getText().toString();
                                               labItem.setInfo(info);
                                               presenter.EditItemLabToServer(mLabId, labItem);
                                               labItem = null;

                                           }
                                           if (complainItem != null) {
                                               String info = edit_info_edit_text.getText().toString();
                                               complainItem.setInfo(info);
                                               presenter.EditItemComplainToServer(mCompId, complainItem);
                                               complainItem = null;

                                           }
                                           if (medicalHistoryItem != null) {
                                               String info = edit_info_edit_text.getText().toString();
                                               medicalHistoryItem.setInfo(info);
                                               presenter.EditItemMedicalHistoryToServer(mHistoryId, medicalHistoryItem);
                                               medicalHistoryItem = null;

                                           }
                                       }
                                   }
        );
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (radiationItem != null) {
                    presenter.deleteItemRadiation(mRadiationtId);
                }
                if (labItem != null) {
                    presenter.deleteItemLab(mLabId);
                }
                if (complainItem != null) {
                    presenter.deleteItemComplain(mCompId);
                }
                if (medicalHistoryItem != null) {
                    presenter.deleteItemHistory(mHistoryId);
                }
            }
        });

        btnUploadImages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (radiationItem != null) {
                    obj_id = mRadiationtId;
                    owner = Utils.MediaConstants.RADIATION_MEDIA;
                    showPickDialog(true);

                }
                if (labItem != null) {
                    obj_id = mLabId;
                    owner = Utils.MediaConstants.LAB_MEDIA;
                    showPickDialog(true);

                }
                if (complainItem != null) {
                    obj_id = mCompId;
                    owner = Utils.MediaConstants.COMPLAIN_MEDIA;
                    showPickDialog(true);
                }

            }
        });

        btnUploadVedios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (radiationItem != null) {
                    obj_id = mRadiationtId;
                    showPickDialog(false);

                }
                if (labItem != null) {
                    obj_id = mLabId;
                    showPickDialog(false);

                }
                if (complainItem != null) {
                    obj_id = mCompId;
                    showPickDialog(false);
                }

            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        complainItem = null;
        radiationItem = null;
        labItem = null;
        medicalHistoryItem = null;
    }

    @Override
    public void setItemsUpdateSucessfull() {
        Toast.makeText(this, "Updated Sucessfully", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setItemsUpdateFailure() {
        Toast.makeText(this, "Can't Update  ", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setItemDeleteSuccessful() {
        Toast.makeText(this, "Item deleted successfully", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void setItemDeleteFailure() {
        Toast.makeText(this, "Can't delete item", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setItemMediaSuccessful() {
        Toast.makeText(this, "Images Uploaded successfully", Toast.LENGTH_SHORT).show();
        //mProgress.setVisibility(View.GONE);
        //TODO: Update Images List
    }

    @Override
    public void setItemMediaFailure() {
        Toast.makeText(this, "Can't upload images", Toast.LENGTH_SHORT).show();
        //mProgress.setVisibility(View.GONE);
    }

    @Override
    public void showImages(List<MediaItem> mediaItems) {
        if (mediaItems != null) {
            recyclerViewItemUploadImages.setLayoutManager(new LinearLayoutManager(this,
                    LinearLayoutManager.HORIZONTAL, false));
            imageItemAdapter = new ImageItemAdapter(mContext, mediaItems, this);
            recyclerViewItemUploadImages.setAdapter(imageItemAdapter);
        }
    }

    @Override
    public void showVedios(List<MediaItem> mediaItems) {
        if (mediaItems != null) {
            recyclerViewItemUploadVedios.setLayoutManager(new LinearLayoutManager(this,
                    LinearLayoutManager.HORIZONTAL, false));
            vedioItemAdapter = new VedioItemAdapter(mContext, mediaItems, this);
            recyclerViewItemUploadVedios.setAdapter(vedioItemAdapter);
        }
    }

    @Override
    public void onItemImageClicked(int id) {
        showImagesDialog();
    }

    AlertDialog mImagesDialog;

    SliderLayout mSliderLayout;

    private void showImagesDialog() {
        if (mImagesDialog == null) {
            @SuppressLint("InflateParams")
            View view = LayoutInflater.from(this).inflate(R.layout.media_popup, null);
            mSliderLayout = (SliderLayout) view.findViewById(R.id.slider);
            for (MediaItem item : mediaItemsImages) {
                TextSliderView textSliderView = new TextSliderView(this);
                textSliderView.image(item.getUrl());
                mSliderLayout.addSlider(textSliderView);
            }
            mSliderLayout.setPresetTransformer(SliderLayout.Transformer.Accordion);
            mSliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
            mSliderLayout.setCustomAnimation(new DescriptionAnimation());
            mSliderLayout.addOnPageChangeListener(this);

            mImagesDialog = new AlertDialog.Builder(this)
                    .setView(view)
                    .create();
            mImagesDialog.show();
        } else
            mImagesDialog.show();
    }

    @Override
    public void onItemVedioClicked(int id ,MediaItem clickedItem) {
        String url=clickedItem.getUrl();
        File file = new File(url);
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.fromFile(file), "video/*");
        startActivity(intent);

    }

    private void showPickDialog(boolean isPhoto) {
        if (isPhoto)
            PickImageDialog.build(new PickSetup()).show(this);
        else
            PickImageDialog.build(new PickSetup().setVideo(true)).show(this);
    }

    private String getRealPathFromURI(Uri contentUri) {
        String[] proj = new String[1];
        proj[0] = MediaStore.Images.Media.DATA;
        CursorLoader loader = new CursorLoader(this, contentUri, proj, null, null, null);
        Cursor cursor = loader.loadInBackground();
        int columnIndex = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        String result = cursor.getString(columnIndex);
        cursor.close();
        return result;
    }

    @Override
    public void onPickResult(PickResult pickResult) {
        ArrayList<String> paths = new ArrayList<>();
        Uri file = pickResult.getUri();
        if (pickResult.getPickType() == EPickType.CAMERA)
            paths.add(file.getPath());
        else
            paths.add(getRealPathFromURI(file));
        presenter.uploadMediaToServer(obj_id, paths, owner);
        //mProgress.setVisibility(View.VISIBLE);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
