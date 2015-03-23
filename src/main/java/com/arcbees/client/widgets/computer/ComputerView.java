package com.arcbees.client.widgets.computer;

import javax.inject.Inject;

import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.query.client.GQuery;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

public class ComputerView extends ViewImpl implements ComputerWidget.MyView {
    interface Binder extends UiBinder<Widget, ComputerView> {
    }

    @UiField
    SpanElement computerName;

    @Inject
    ComputerView(Binder binder) {
        initWidget(binder.createAndBindUi(this));
    }

    @Override
    public void setComputerName(String computerName) {
        this.computerName.setInnerText(computerName);
    }

    @Override
    public void displayStatus(String computerName, String hackerName) {
        GQuery.console.log("I got hacked. (" + computerName + ") by " + hackerName);
    }
}
