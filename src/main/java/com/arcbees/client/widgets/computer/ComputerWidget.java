package com.arcbees.client.widgets.computer;

import javax.inject.Inject;

import com.arcbees.client.events.ComputerHackedEvent;
import com.arcbees.client.widgets.computer.ComputerWidget.MyView;
import com.google.gwt.query.client.GQuery;
import com.google.inject.assistedinject.Assisted;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.View;

public class ComputerWidget extends PresenterWidget<MyView> implements ComputerHackedEvent.ComputerHackedHandler {
    public interface MyView extends View {
        void setComputerName(String computerName);
    }

    private final String computerName;

    @Override
    protected void onBind() {
        super.onBind();

        getEventBus().addHandler(ComputerHackedEvent.TYPE, this);
    }

    @Inject
    public ComputerWidget(
            EventBus eventBus,
            MyView view,
            @Assisted String computerName) {
        super(eventBus, view);

        this.computerName = computerName;

        view.setComputerName(computerName);
    }

    @Override
    public void onSystemHacked(ComputerHackedEvent event) {
        GQuery.console.log("I got hacked. (" + computerName + ") by " + event.getHackerName());
    }
}
