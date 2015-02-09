package com.arcbees.client.widgets.hacker;

import javax.inject.Inject;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

public class HackerView extends ViewWithUiHandlers<HackerUiHandlers> implements HackerWidget.MyView {
    interface Binder extends UiBinder<Widget, HackerView> {
    }

    @UiField
    Button hackThePlanet;

    @Inject
    public HackerView(Binder binder) {
        initWidget(binder.createAndBindUi(this));
    }

    @UiHandler("hackThePlanet")
    public void initiateHacking(ClickEvent event) {
        getUiHandlers().onInitiateHacking();
    }
}
