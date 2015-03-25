package com.arcbees.client.application.home;

import javax.inject.Inject;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

public class RootView extends ViewImpl
        implements RootPresenter.MyView {
    interface Binder extends UiBinder<Widget, RootView> {
    }

    @UiField
    HTMLPanel computers;
    @UiField
    HTMLPanel hackers;

    @Inject
    RootView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    public void addToSlot(Object slot, IsWidget content) {
        super.addToSlot(slot, content);

        if (slot == RootPresenter.SLOT_COMPUTERS) {
            computers.add(content);
        } else if (slot == RootPresenter.SLOT_HACKERS) {
            hackers.add(content);
        }
    }

    @Override
    public void removeFromSlot(Object slot, IsWidget content) {
        super.removeFromSlot(slot, content);

        if (slot == RootPresenter.SLOT_COMPUTERS) {
            computers.remove(content);
        } else if (slot == RootPresenter.SLOT_HACKERS) {
            hackers.remove(content);
        }
    }
}
