package com.josecuentas.jc_mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.josecuentas.jc_mvp.R;
import com.josecuentas.jc_mvp.presenter.LoginPresenter;
import com.josecuentas.jc_mvp.view.LoginMvpView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements LoginMvpView {

    @Bind(R.id.button) Button mButton;
    @Bind(R.id.edt_user) EditText mEdtUser;
    @Bind(R.id.edt_pw) EditText mEdtPw;
    LoginPresenter mLoginPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initVariables();
        initEvents();
    }

    private void initVariables() {
        mLoginPresenter = new LoginPresenter();
        mLoginPresenter.attachedView(this);
    }

    private void initEvents() {
        mButton.setOnClickListener(v -> {
            String user=mEdtUser.getText().toString();
            String pass=mEdtPw.getText().toString();
            mLoginPresenter.onValidateUser(new String[]{user, pass});
        });
    }


    @Override
    public void goToSuccess() {
        startActivity(new Intent(this, MenuActivity.class));
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showConnectionErrorMessage() {
        Toast.makeText(this, getString(R.string.error_internet_connection), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showServerError() {
        Toast.makeText(this, getString(R.string.error_server_internal), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showUserIncorrect() {
        Toast.makeText(this, getString(R.string.error_login_us_pw_incorrect), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showUserNotFound() {
        Toast.makeText(this, getString(R.string.error_login_us_pw_incorrect), Toast.LENGTH_SHORT).show();
    }
}
