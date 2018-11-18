package com.example.shaimaaderbaz.orthoclinic.activities;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.shaimaaderbaz.orthoclinic.R;
import com.example.shaimaaderbaz.orthoclinic.presenter.LoginPresenterImp;
import com.example.shaimaaderbaz.orthoclinic.views.LoginView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements LoginView{

    @BindView(R.id.etUsername)
    EditText etUsername;
    @BindView(R.id.etPassword)
    EditText etPassword;
    @BindView(R.id.btnLogin)
    Button btnLogin;

    private LoginPresenterImp presenter;

    Context context;

    public static void start(Context context) {
        Intent starter = new Intent(context, LoginActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        context=this;
        ButterKnife.bind(this);
        presenter = new LoginPresenterImp(this);
        btnLogin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                String username=etUsername.getText().toString();
                String password=etPassword.getText().toString();
                Cursor cursor =presenter.retrieveLoginDataFromDatabase(context);
                if(!username.isEmpty()&&!password.isEmpty())
                {
                    if(username.equals("Shabrawy")&&password.equals("shabrawy123321"))
                    if(cursor.getCount()==0)
                    {
                        presenter.addUserAndPassToDatabase(username,password,context);
                    }
                    presenter.addUserAndPassToLog(username,password);

                }else{
                    //setPatientCreateFailure();
                }
            }
        });
    }
    @Override
    public void setLoginCreateSucessfull()
    {
        Toast.makeText(this,"Login Succedd", Toast.LENGTH_SHORT).show();
        HomeActivity.start(this);
    }
    public void setLoginCreateFailure()
    {
        Toast.makeText(this,"Failed to login", Toast.LENGTH_SHORT).show();
    }
}
