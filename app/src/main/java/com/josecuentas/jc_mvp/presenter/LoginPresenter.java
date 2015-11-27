package com.josecuentas.jc_mvp.presenter;

import com.josecuentas.jc_mvp.model.LoginCallback;
import com.josecuentas.jc_mvp.model.LoginInteractor;
import com.josecuentas.jc_mvp.view.LoginMvpView;

/**
 * Created by Jose Cuentas Turpo on 27/11/2015 - 12:02 PM.
 * E-mail: jcuentast@gmail.com
 */
public class LoginPresenter implements Presenter<LoginMvpView>, LoginCallback {

    private LoginMvpView mLoginMvpView;
    private LoginInteractor mLoginInteractor;

    @Override public void attachedView(LoginMvpView view) {
        if (view==null)
            throw  new IllegalArgumentException("You can't set a null view");

        mLoginMvpView = view;
        mLoginInteractor = new LoginInteractor();
    }

    public void onValidateUser(String[] values){
        mLoginMvpView.showLoading();
        mLoginInteractor.validateLogin(values, this);
    }

    @Override public void detachView() {
        mLoginMvpView =null;
    }

    @Override public void onError() {
        mLoginMvpView.showServerError();
    }

    @Override public void onSuccesss() {
        mLoginMvpView.goToSuccess();
    }

    @Override public void onUserNotFound() {
    mLoginMvpView.showUserNotFound();
    }

    @Override public void onUserIncorrect() {
    mLoginMvpView.showUserIncorrect();
    }

    @Override public void onServerError() {
        mLoginMvpView.showServerError();
    }
}
