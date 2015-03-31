package com.arcbees.client.application.home;

import com.arcbees.client.widgets.computer.ComputerPresenter;
import com.arcbees.client.widgets.computer.ComputerView;
import com.arcbees.client.widgets.computer.WidgetsFactory;
import com.arcbees.client.widgets.hacker.HackerPresenter;
import com.arcbees.client.widgets.hacker.HackerView;
import com.google.gwt.inject.client.assistedinject.GinFactoryModuleBuilder;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class RootModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        bindPresenter(RootPresenter.class, RootPresenter.MyView.class, RootView.class,
                RootPresenter.MyProxy.class);

        bind(ComputerPresenter.MyView.class).to(ComputerView.class);
        bind(HackerPresenter.MyView.class).to(HackerView.class);

        install(new GinFactoryModuleBuilder().build(WidgetsFactory.class));
    }
}
