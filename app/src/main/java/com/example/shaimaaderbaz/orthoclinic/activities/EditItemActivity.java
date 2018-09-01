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
import com.example.shaimaaderbaz.orthoclinic.models.RadiationItem;
import com.example.shaimaaderbaz.orthoclinic.models.RetrofitModels;
import com.example.shaimaaderbaz.orthoclinic.presenter.EditItemPresenterImp;
import com.example.shaimaaderbaz.orthoclinic.views.EditItemsView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EditItemActivity extends AppCompatActivity implements EditItemsView {
    private static RadiationItem radiationItem ;
    private int mRadiationtId;
    private static final String RADIATION_ID_KEY = "radiation_id";
    private static final String PATIENT_KEY = "patient_key";
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
            throw new RuntimeException("INVALID PATIENT ID");
        }
        ButterKnife.bind(this);
        if(radiationItem !=null)
        {
            edit_field_name_text.setText(radiationItem.getName());
            edit_info_edit_text.setText(radiationItem.getInfo());

        }

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(radiationItem !=null)
                {
                    String info = edit_info_edit_text.getText().toString();
                    radiationItem.setInfo(info);
                    presenter.EditItemRadiationToServer(mRadiationtId,radiationItem);

                }
            }}
        );
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
}
