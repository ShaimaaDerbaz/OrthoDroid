package com.example.shaimaaderbaz.orthoclinic.presenter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

import com.example.shaimaaderbaz.orthoclinic.data.UserLoginContract;
import com.example.shaimaaderbaz.orthoclinic.network.BaseResponseCall;
import com.example.shaimaaderbaz.orthoclinic.network.DataCalls;
import com.example.shaimaaderbaz.orthoclinic.views.LoginView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shaimaa Derbaz on 10/21/2018.
 */

public class LoginPresenterImp implements LoginPresenter , BaseResponseCall{

    private LoginView loginView;
    public LoginPresenterImp(LoginView loginView)
    {
        this.loginView=loginView;
    }
    // implement from Presenter
    @Override
    public void addUserAndPassToLog(String username,String password)
    {
        if(!username.isEmpty()&&!password.isEmpty())
        {
            if(username.equals("Shabrawy")&&password.equals("shabrawy123321"))
            {
                loginView.setLoginCreateSucessfull();
            }
            else {
                loginView.setLoginCreateFailure();
            }
        }
        else
        {
            loginView.setLoginCreateFailure();
        }

    }

    @Override
    public void addUserAndPassToDatabase(String username, String password ,Context mContext)
    {
        ContentValues values = new ContentValues();
        values.put(UserLoginContract.UserLoginEntry.COLUMN_Username,username);
        values.put(UserLoginContract.UserLoginEntry.COLUMN_Password,password);
        Uri newUri = mContext.getContentResolver().insert(UserLoginContract.UserLoginEntry.CONTENT_URI, values);

    }

    @Override
    public Cursor retrieveLoginDataFromDatabase(Context mContext) {
        String[] projection = new String[]{
                UserLoginContract.UserLoginEntry._ID,
                UserLoginContract.UserLoginEntry.COLUMN_Username,
                UserLoginContract.UserLoginEntry.COLUMN_Password

        };
       // List<Article> articles = new ArrayList<>();
        Cursor cursor = mContext.getContentResolver().query(UserLoginContract.UserLoginEntry.CONTENT_URI, projection, null, null, null);
       return cursor;
        /* if (cursor.moveToFirst()) {
            do {
                Article article = new Article();
                cursor.getString(0);
                article.setTitle(cursor.getString(1));
                article.setPublishedAt(cursor.getString(2));
                article.setUrl(cursor.getString(3));
                article.setUrlToImage(cursor.getString(4));

                // Adding contact to list
                articles.add(article);
            } while (cursor.moveToNext());
            allNewsView.showNewsInfo(articles);
        }*/


    }

    @Override
    public void success() {
        loginView.setLoginCreateSucessfull();

    }

    @Override
    public void error(String message) {
        loginView.setLoginCreateFailure();
    }
}
