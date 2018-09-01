package com.example.shaimaaderbaz.orthoclinic.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.shaimaaderbaz.orthoclinic.R;
import com.example.shaimaaderbaz.orthoclinic.models.OperationsItem;
import com.example.shaimaaderbaz.orthoclinic.presenter.EditOperationPresenterImp;
import com.example.shaimaaderbaz.orthoclinic.views.EditOperationsView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EditOperationActivity extends AppCompatActivity implements EditOperationsView {
    private static final String PATIENT_ID_KEY = "patient_id";
    private static final String operationsItem = "operationsItem";
    static OperationsItem operationItem;
    Integer op_id;

    private int mPatientId;
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
    @BindView(R.id.btnUploadImagesOp)
    Button btnUploadImagesOp;
    @BindView(R.id.btnUploadVediosOp)
    Button btnUploadVediosOp;

    public static void start(Context context, int patientId, OperationsItem operationsItemO) {
        Intent starter = new Intent(context, EditOperationActivity.class);
        starter.putExtra(PATIENT_ID_KEY, patientId);
        starter.putExtra(operationsItem, operationsItemO);
        operationItem=operationsItemO;
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_operation);
        presenter = new EditOperationPresenterImp(this);
        ButterKnife.bind(this);
        Bundle extras = getIntent().getExtras();
        if(getIntent().getIntExtra(PATIENT_ID_KEY,0) !=0 )
        {
            mPatientId = getIntent().getIntExtra(PATIENT_ID_KEY,0);
        }
        else
        {
            throw new RuntimeException("INVALID PATIENT ID");
        }
        if (extras != null) {
           // OperationsItem operationItem = extras.getParcelable("operationsItem");
            //operationItem = extras.getParcelable(operationsItem);
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
                operationsItem.setId(op_id);
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
                    presenter.EditItemToServer(mPatientId,operationsItem);
                    //mProgress.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    public void setOperationsUpdateSucessfull()
    {

    }
    public void setOperationsUpdateFailure()
    {

    }
}
