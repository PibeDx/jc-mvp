package com.josecuentas.jc_mvp.model;

/**
 * Created by Jose Cuentas Turpo on 27/11/2015 - 11:56 AM.
 * E-mail: jcuentast@gmail.com
 */
public interface LoginCallback {

    void onSuccesss();
    void onError();
    void onUserNotFound();
    void onUserIncorrect();
    void onServerError();


}
