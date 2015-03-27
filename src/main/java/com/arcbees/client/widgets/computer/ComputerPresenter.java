package com.arcbees.client.widgets.computer;

import javax.inject.Inject;

import com.arcbees.client.events.ComputerHackedEvent;
import com.arcbees.client.widgets.computer.ComputerPresenter.MyView;
import com.google.inject.assistedinject.Assisted;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.HandlerRegistration;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.View;

public class ComputerPresenter extends PresenterWidget<MyView>
        implements ComputerHackedEvent.ComputerHackedHandler, HasComputerHackedHandlers {
    public interface MyView extends View {
        void setComputerName(String computerName);

        void displayStatus(String computerName, String hackerName);
    }

    private final String computerName;

    @Inject
    ComputerPresenter(
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
    public HandlerRegistration addComputerHackedHandler(ComputerHackedEvent.ComputerHackedHandler handler, Object source) {
        HandlerRegistration hr = getEventBus().addHandlerToSource(ComputerHackedEvent.TYPE, source, handler);
        registerHandler(hr);

        return hr;
    }
}
