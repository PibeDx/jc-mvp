package com.josecuentas.jc_mvp.view;

/**
 * Created by Jose Cuentas Turpo on 27/11/2015 - 11:18 AM.
 * E-mail: jcuentast@gmail.com
 */
public interface LoginMvpView {

    void showLoading();
    void hideLoading();
    void showConnectionErrorMessage();
    void showServerError();
    void showUserIncorrect();
    void showUserNotFound();
    void goToSuccess();


}
