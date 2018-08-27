package com.example.shaimaaderbaz.orthoclinic.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.shaimaaderbaz.orthoclinic.R;
import com.example.shaimaaderbaz.orthoclinic.presenter.SplashPresenter;
import com.example.shaimaaderbaz.orthoclinic.presenter.SplashPresenterImpl;
import com.example.shaimaaderbaz.orthoclinic.repository.SharedPrefsRepositoryImpl;
import com.example.shaimaaderbaz.orthoclinic.views.SplashView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SplashActivity extends AppCompatActivity implements SplashView{

    @BindView(R.id.retry_button)
    Button mRetryButton;

    @BindView(R.id.background_image)
    ImageView mBackgroundImage;

    @BindView(R.id.progress)
    ProgressBar mProgress;

    SplashPresenter mSplashPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        mSplashPresenter =
                new SplashPresenterImpl(this,new SharedPrefsRepositoryImpl(this));
        mSplashPresenter.bindAllData();
        showLoading();
        mRetryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSplashPresenter.bindAllData();
                showLoading();
            }
        });
    }

    private void showLoading() {
        mBackgroundImage.setAlpha(0.2f);
        mProgress.setVisibility(View.VISIBLE);
        mRetryButton.setVisibility(View.INVISIBLE);
    }

    private void hideLoading() {
        mBackgroundImage.setAlpha(1.0f);
        mProgress.setVisibility(View.INVISIBLE);
    }


    @Override
    public void onDataReturned() {
        HomeActivity.start(this);
    }

    @Override
    public void onError() {
        Toast.makeText(this,getString(R.string.connection_error),Toast.LENGTH_SHORT).show();
        hideLoading();
        mRetryButton.setVisibility(View.VISIBLE);
    }
}
