package com.arcbees.client.widgets.hacker;

import javax.inject.Inject;

import com.arcbees.client.events.ComputerHackedEvent;
import com.google.inject.assistedinject.Assisted;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.View;

import static com.arcbees.client.widgets.hacker.HackerPresenter.MyView;

public class HackerPresenter extends PresenterWidget<MyView>
        implements HackerUiHandlers {
    public interface MyView extends View, HasUiHandlers<HackerUiHandlers> {
    }

    private final String hackerName;

    @Inject
    HackerPresenter(
            EventBus eventBus,
            MyView view,
            @Assisted String hackerName) {
        super(eventBus, view);

        this.hackerName = hackerName;

        getView().setUiHandlers(this);
    }

    @Override
    public void onInitiateHacking() {
        ComputerHackedEvent.fire(hackerName, this);
    }
}
