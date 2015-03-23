package com.arcbees.client.widgets.computer;

import javax.inject.Inject;

import com.arcbees.client.events.ComputerHackedEvent;
import com.arcbees.client.widgets.computer.ComputerWidget.MyView;
import com.google.inject.assistedinject.Assisted;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.View;

public class ComputerWidget extends PresenterWidget<MyView>
        implements ComputerHackedEvent.ComputerHackedHandler {
    public interface MyView extends View {
        void setComputerName(String computerName);

        void displayStatus(String computerName, String hackerName);
    }

    private final String computerName;

    @Inject
    ComputerWidget(
            EventBus eventBus,
            MyView view,
            @Assisted String computerName) {
        super(eventBus, view);

        this.computerName = computerName;

        view.setComputerName(computerName);
    }

    @Override
    public void onSystemHacked(ComputerHackedEvent event) {
        getView().displayStatus(computerName, event.getHackerName());
    }

    @Override
    protected void onBind() {
        super.onBind();

        getEventBus().addHandler(ComputerHackedEvent.TYPE, this);
    }
}
