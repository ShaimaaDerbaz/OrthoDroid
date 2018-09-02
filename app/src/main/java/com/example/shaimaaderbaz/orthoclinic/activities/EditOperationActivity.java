package com.example.shaimaaderbaz.orthoclinic.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.annotation.RequiresApi;
import android.support.v4.content.CursorLoader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.shaimaaderbaz.orthoclinic.R;
import com.example.shaimaaderbaz.orthoclinic.fragments.PersonalFragment;
import com.example.shaimaaderbaz.orthoclinic.models.OperationsItem;
import com.example.shaimaaderbaz.orthoclinic.models.PatientProfile;
import com.example.shaimaaderbaz.orthoclinic.presenter.EditOperationPresenterImp;
import com.example.shaimaaderbaz.orthoclinic.views.EditOperationsView;
import com.vansuita.pickimage.bean.PickResult;
import com.vansuita.pickimage.bundle.PickSetup;
import com.vansuita.pickimage.dialog.PickImageDialog;
import com.vansuita.pickimage.enums.EPickType;
import com.vansuita.pickimage.listeners.IPickClick;
import com.vansuita.pickimage.listeners.IPickResult;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EditOperationActivity extends AppCompatActivity implements EditOperationsView,
        IPickResult{
    private static final String PATIENT_ID_KEY = "patient_id";
    private static final String operationsItem = "operationsItem";
    static OperationsItem operationItem;
    Integer op_id;

    private int mOperationId;
    private static final String PATIENT_KEY = "patient_key";

    EditOperationPresenterImp presenter;
    @BindView(R.id.operation_text)
    EditText operation_name_text;
    @BindView(R.id.date_text)
    EditText date_text;
    @BindView(R.id.steps_text)
    EditText steps_text;
    @BindView(R.id.person_text)
    EditText person_text;
    @BindView(R.id.follow_text)
    EditText follow_text;
    @BindView(R.id.btnEditOperation)
    Button btnEditOperation;
    @BindView(R.id.btnDeleteOperation)
    Button btnDeleteOperation ;
    @BindView(R.id.btnUploadImagesOp)
    Button btnUploadImagesOp;
    @BindView(R.id.btnUploadVediosOp)
    Button btnUploadVediosOp;

    @BindView(R.id.progress)
    ProgressBar mProgress;

    Context mContext;

    public static void start(Context context, int patientId, OperationsItem operationsItemO) {
        Intent starter = new Intent(context, EditOperationActivity.class);
        starter.putExtra(PATIENT_ID_KEY, patientId);
        starter.putExtra(operationsItem, operationsItemO);
        operationItem = operationsItemO;
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_operation);
        mContext =this;
        presenter = new EditOperationPresenterImp(this);
        ButterKnife.bind(this);
        Bundle extras = getIntent().getExtras();
        if (getIntent().getIntExtra(PATIENT_ID_KEY, 0) != 0) {
            mOperationId = getIntent().getIntExtra(PATIENT_ID_KEY, 0);
        } else {
            throw new RuntimeException("INVALID PATIENT ID");
        }
        if (extras != null) {
            op_id = operationItem.getId();
            operation_name_text.setText(operationItem.getName());
            date_text.setText(operationItem.getDate());
            steps_text.setText(operationItem.getSteps());
            person_text.setText(operationItem.getPersons());
            follow_text.setText(operationItem.getFollow_up());
        }

        btnEditOperation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OperationsItem operationsItem = new OperationsItem();
                String name = operation_name_text.getText().toString();
                String date = date_text.getText().toString();
                String steps = steps_text.getText().toString();
                String persons = person_text.getText().toString();
                String followup = follow_text.getText().toString();
                operationsItem.setName(name);
                operationsItem.setDate(date);
                operationsItem.setSteps(steps);
                operationsItem.setPersons(persons);
                operationsItem.setFollow_up(followup);

                if (!name.isEmpty()) {
                    presenter.EditItemToServer(mOperationId, mOperationId, operationsItem);
                    mProgress.setVisibility(View.VISIBLE);
                }
            }
        });

        btnDeleteOperation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                presenter.deleteItemOperation(mOperationId);
                //PatientProfileActivity.start(mContext,operationItem.getPatient_id());
            }
            }
        );
        btnUploadImagesOp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent i = new Intent(Intent.ACTION_PICK,
//                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//                startActivityForResult(i, 100);
                showPickDialog(true);
            }
        });
        btnUploadVediosOp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent i = new Intent(Intent.ACTION_GET_CONTENT,
//                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//                i.setType("video/");
//                startActivityForResult(i, 100);
                showPickDialog(false);

            }
        });
    }
    private void showPickDialog(boolean isPhoto) {
        if (isPhoto)
            PickImageDialog.build(new PickSetup()).show(this);
        else
            PickImageDialog.build(new PickSetup().setVideo(true)).show(this);
    }

    @Override
    public void setOperationsUpdateSucessfull() {
        Toast.makeText(this, "Operations Updated Sucessfully", Toast.LENGTH_SHORT).show();
        mProgress.setVisibility(View.GONE);
    }

    @Override
    public void setOperationsUpdateFailure() {
        Toast.makeText(this, "Can't Update Operations ", Toast.LENGTH_SHORT).show();
        mProgress.setVisibility(View.GONE);
    }

    @Override
    public void setOperationMediaSuccess() {
        Toast.makeText(this,"Images Uploaded successfully",Toast.LENGTH_SHORT).show();
        mProgress.setVisibility(View.GONE);
        //TODO: Update Images List
    }

    @Override
    public void setOperationMediaFailure() {
        Toast.makeText(this,"Can't upload images",Toast.LENGTH_SHORT).show();
        mProgress.setVisibility(View.GONE);
    }

    @Override
    public void setItemDeleteSuccessful()
    {
        Toast.makeText(this,"Operation Deleted sucessfully",Toast.LENGTH_SHORT).show();
        mProgress.setVisibility(View.GONE);
    }
    @Override
    public void setItemDeleteFailure()
    {
        Toast.makeText(this,"Can't Delete Operation ",Toast.LENGTH_SHORT).show();
        mProgress.setVisibility(View.GONE);
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
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == 100 && resultCode == Activity.RESULT_OK && data != null) {
//            ArrayList<String> paths = new ArrayList<>();
//            paths.add(getRealPathFromURI(data.getData()));
//            presenter.uploadMediaToServer(op_id,paths);
//        }
    }

    @Override
    public void onPickResult(PickResult pickResult) {
        ArrayList<String> paths = new ArrayList<>();
        Uri file = pickResult.getUri();
        if (pickResult.getPickType() == EPickType.CAMERA)
            paths.add(file.getPath());
        else
            paths.add(getRealPathFromURI(file));
        presenter.uploadMediaToServer(op_id,paths);
        mProgress.setVisibility(View.VISIBLE);
    }
}
