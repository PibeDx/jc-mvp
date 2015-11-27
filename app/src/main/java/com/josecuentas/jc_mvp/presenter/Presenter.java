package com.josecuentas.jc_mvp.presenter;

/**
 * Created by Jhordan on 20/11/15.
 */
public interface Presenter<V>{

    void attachedView(V view);

    void detachView();
}
