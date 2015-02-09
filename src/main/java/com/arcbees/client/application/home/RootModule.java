package com.arcbees.client.application.home;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class RootModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        bindPresenter(RootPresenter.class, RootPresenter.MyView.class, RootView.class,
                RootPresenter.MyProxy.class);
    }
}
