package com.josecuentas.jc_mvp.model;

/**
 * Created by Jose Cuentas Turpo on 27/11/2015 - 11:45 AM.
 * E-mail: jcuentast@gmail.com
 */
public class LoginInteractor {

    public LoginInteractor() {
    }

    //[1]user-[2]password
    public void validateLogin(String[] values, LoginCallback loginCallback) {
        if (values[0].equals("jcuentas") && values[1].equals("jcuentas")) {
            onSuccess(loginCallback);
        } else {
            onError(1, loginCallback);
        }
    }

    public void onSuccess(LoginCallback loginCallback) {
        loginCallback.onSuccesss();
    }

    public void onError(int type, LoginCallback loginCallback) {
        switch (type) {
            case 1:
                loginCallback.onUserIncorrect();
                break;
            case 2:
                loginCallback.onUserNotFound();
                break;
            case 3:
                loginCallback.onServerError();
                break;
        }
    }
}
