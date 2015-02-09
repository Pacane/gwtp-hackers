package com.arcbees.client.application;

import com.arcbees.client.application.home.RootModule;
import com.arcbees.client.widgets.computer.ComputerWidgetFactory;
import com.arcbees.client.widgets.computer.ComputerView;
import com.arcbees.client.widgets.computer.ComputerWidget;
import com.arcbees.client.widgets.hacker.HackerView;
import com.arcbees.client.widgets.hacker.HackerWidget;
import com.arcbees.client.widgets.hacker.HackerWidgetFactory;
import com.google.gwt.inject.client.assistedinject.GinFactoryModuleBuilder;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class ApplicationModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        install(new RootModule());

        bindPresenter(ApplicationPresenter.class, ApplicationPresenter.MyView.class, ApplicationView.class,
                ApplicationPresenter.MyProxy.class);
        bind(ComputerWidget.MyView.class).to(ComputerView.class);
        bind(HackerWidget.MyView.class).to(HackerView.class);

        install(new GinFactoryModuleBuilder().build(ComputerWidgetFactory.class));
        install(new GinFactoryModuleBuilder().build(HackerWidgetFactory.class));
    }
}
