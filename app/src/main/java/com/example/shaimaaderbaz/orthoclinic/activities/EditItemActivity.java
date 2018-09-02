package com.example.shaimaaderbaz.orthoclinic.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shaimaaderbaz.orthoclinic.R;
import com.example.shaimaaderbaz.orthoclinic.models.ComplainItem;
import com.example.shaimaaderbaz.orthoclinic.models.LabItem;
import com.example.shaimaaderbaz.orthoclinic.models.MedicalHistoryItem;
import com.example.shaimaaderbaz.orthoclinic.models.RadiationItem;
import com.example.shaimaaderbaz.orthoclinic.models.RetrofitModels;
import com.example.shaimaaderbaz.orthoclinic.presenter.EditItemPresenterImp;
import com.example.shaimaaderbaz.orthoclinic.views.EditItemsView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EditItemActivity extends AppCompatActivity implements EditItemsView {
    private static RadiationItem radiationItem ;
    private int mRadiationtId;
    private static LabItem labItem ;
    private static ComplainItem complainItem ;
    private static MedicalHistoryItem medicalHistoryItem ;
    private int mLabId;
    private int mHistoryId;
    private int mCompId;
    private static final String RADIATION_ID_KEY = "radiation_id";
    private static final String PATIENT_KEY = "patient_key";
    private static final String LAB_ID_KEY = "lab_id";
    private static final String COMPLAIN_ID_KEY = "complain_id";
    private static final String HISTORY_ID_KEY = "history_id";
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

    public static void start(Context context, int radiationId, RadiationItem radiationItemO) {
        Intent starter = new Intent(context, EditItemActivity.class);
        starter.putExtra(RADIATION_ID_KEY, radiationId);
      //  starter.putExtra(operationsItem, operationsItemO);
        radiationItem=radiationItemO;
        context.startActivity(starter);
    }

    public static void start(Context context, int labId, LabItem labItemO) {
        Intent starter = new Intent(context, EditItemActivity.class);
        starter.putExtra(LAB_ID_KEY, labId);
        labItem=labItemO;
        context.startActivity(starter);
    }

    public static void start(Context context, int comoId, ComplainItem complainItemO) {
        Intent starter = new Intent(context, EditItemActivity.class);
        starter.putExtra(COMPLAIN_ID_KEY, comoId);
        complainItem=complainItemO;
        context.startActivity(starter);
    }

    public static void start(Context context, int historyId, MedicalHistoryItem medicalHistoryItemO) {
        Intent starter = new Intent(context, EditItemActivity.class);
        starter.putExtra(HISTORY_ID_KEY, historyId);
        medicalHistoryItem=medicalHistoryItemO;
        context.startActivity(starter);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        Bundle extras = getIntent().getExtras();
        presenter =new EditItemPresenterImp(this);
        if(getIntent().getIntExtra(RADIATION_ID_KEY,0) !=0 )
        {
            mRadiationtId = getIntent().getIntExtra(RADIATION_ID_KEY,0);
        }
        else
        {
            //throw new RuntimeException("INVALID RADIATION ID");
        }

        if(getIntent().getIntExtra(LAB_ID_KEY,0) !=0 )
        {
            mLabId = getIntent().getIntExtra(LAB_ID_KEY,0);
        }
        else
        {
            //throw new RuntimeException("INVALID LAB ID");
        }
        if(getIntent().getIntExtra(COMPLAIN_ID_KEY,0) !=0 )
        {
            mCompId = getIntent().getIntExtra(COMPLAIN_ID_KEY,0);
        }
        else
        {
            //throw new RuntimeException("INVALID LAB ID");
        }

        if(getIntent().getIntExtra(HISTORY_ID_KEY,0) !=0 )
        {
            mHistoryId = getIntent().getIntExtra(HISTORY_ID_KEY,0);
        }
        else
        {
            //throw new RuntimeException("INVALID LAB ID");
        }
        ButterKnife.bind(this);
        if(radiationItem !=null)
        {
            edit_field_name_text.setText(radiationItem.getName());
            edit_info_edit_text.setText(radiationItem.getInfo());


        }

        if(labItem !=null)
        {
            edit_field_name_text.setText(labItem.getName());
            edit_info_edit_text.setText(labItem.getInfo());


        }

        if(complainItem !=null)
        {
            edit_field_name_text.setText(complainItem.getName());
            edit_info_edit_text.setText(complainItem.getInfo());


        }

        if(medicalHistoryItem !=null)
        {
            edit_field_name_text.setText(medicalHistoryItem.getState_name());
            edit_info_edit_text.setText(medicalHistoryItem.getInfo());
            btnUploadImages.setVisibility(View.INVISIBLE);
            btnUploadVedios.setVisibility(View.INVISIBLE);


        }
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(radiationItem !=null)
                {
                    String info = edit_info_edit_text.getText().toString();
                    radiationItem.setInfo(info);
                    presenter.EditItemRadiationToServer(mRadiationtId,radiationItem);
                    radiationItem=null;

                }
                if(labItem !=null)
                {
                    String info = edit_info_edit_text.getText().toString();
                    labItem.setInfo(info);
                    presenter.EditItemLabToServer(mLabId,labItem);
                    labItem=null;

                }
                if(complainItem !=null)
                {
                    String info = edit_info_edit_text.getText().toString();
                    complainItem.setInfo(info);
                    presenter.EditItemComplainToServer(mCompId,complainItem);
                    complainItem=null;

                }
                if(medicalHistoryItem !=null)
                {
                    String info = edit_info_edit_text.getText().toString();
                    medicalHistoryItem.setInfo(info);
                    presenter.EditItemMedicalHistoryToServer(mHistoryId,medicalHistoryItem);
                    medicalHistoryItem=null;

                }
            }}
        );
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(radiationItem !=null)
                {
                    presenter.deleteItemRadiation(mRadiationtId);
                }
                if(labItem !=null)
                {
                    presenter.deleteItemLab(mLabId);
                }
                if(complainItem !=null)
                {
                    presenter.deleteItemComplain(mCompId);
                }
                if(medicalHistoryItem !=null)
                {
                    presenter.deleteItemHistory(mHistoryId);
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
    }

    @Override
    public void setItemsUpdateSucessfull()
    {
        Toast.makeText(this, "Updated Sucessfully", Toast.LENGTH_SHORT).show();
    }
    @Override
    public void setItemsUpdateFailure()
    {
        Toast.makeText(this, "Can't Update  ", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setItemDeleteSuccessful() {
        Toast.makeText(this,"Item deleted successfully",Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void setItemDeleteFailure() {
        Toast.makeText(this,"Can't delete item",Toast.LENGTH_SHORT).show();
    }
}
