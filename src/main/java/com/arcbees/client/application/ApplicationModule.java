package com.arcbees.client.application;

import com.arcbees.client.application.home.RootModule;
import com.arcbees.client.widgets.computer.ComputerPresenter;
import com.arcbees.client.widgets.computer.ComputerView;
import com.arcbees.client.widgets.computer.WidgetsFactory;
import com.arcbees.client.widgets.hacker.HackerPresenter;
import com.arcbees.client.widgets.hacker.HackerView;
import com.google.gwt.inject.client.assistedinject.GinFactoryModuleBuilder;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class ApplicationModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        install(new RootModule());

        bindPresenter(ApplicationPresenter.class, ApplicationPresenter.MyView.class, ApplicationView.class,
                ApplicationPresenter.MyProxy.class);
        bind(ComputerPresenter.MyView.class).to(ComputerView.class);
        bind(HackerPresenter.MyView.class).to(HackerView.class);

        install(new GinFactoryModuleBuilder().build(WidgetsFactory.class));
    }
}
