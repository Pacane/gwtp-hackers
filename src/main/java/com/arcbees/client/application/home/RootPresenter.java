package com.arcbees.client.application.home;

import javax.inject.Inject;

import com.arcbees.client.application.ApplicationPresenter;
import com.arcbees.client.events.ComputerHackedEvent;
import com.arcbees.client.place.NameTokens;
import com.arcbees.client.widgets.computer.ComputerWidget;
import com.arcbees.client.widgets.computer.ComputerWidgetFactory;
import com.arcbees.client.widgets.hacker.HackerWidget;
import com.arcbees.client.widgets.hacker.HackerWidgetFactory;
import com.google.gwt.event.shared.GwtEvent;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ContentSlot;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealContentHandler;

public class RootPresenter extends Presenter<RootPresenter.MyView, RootPresenter.MyProxy> {
    interface MyView extends View {
    }

    @ProxyStandard
    @NameToken(NameTokens.home)
    interface MyProxy extends ProxyPlace<RootPresenter> {
    }

    @ContentSlot
    public static final GwtEvent.Type<RevealContentHandler<?>> SLOT_COMPUTERS = new GwtEvent.Type<>();

    @ContentSlot
    public static final GwtEvent.Type<RevealContentHandler<?>> SLOT_HACKERS = new GwtEvent.Type<>();

    private final ComputerWidgetFactory computerWidgetFactory;
    private final HackerWidgetFactory hackerWidgetFactory;

    @Inject
    RootPresenter(
            EventBus eventBus,
            MyView view,
            MyProxy proxy,
            ComputerWidgetFactory computerWidgetFactory,
            HackerWidgetFactory hackerWidgetFactory) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_SetMainContent);

        this.computerWidgetFactory = computerWidgetFactory;
        this.hackerWidgetFactory = hackerWidgetFactory;
    }

    @Override
    protected void onBind() {
        super.onBind();

        HackerWidget zeroCool = hackerWidgetFactory.create("Zer0C00L");
        HackerWidget acidBurn = hackerWidgetFactory.create("AcidBurn");


        addToSlot(SLOT_HACKERS, zeroCool);
        addToSlot(SLOT_HACKERS, acidBurn);

        ComputerWidget computerA = computerWidgetFactory.create("A");
        ComputerWidget computerB = computerWidgetFactory.create("B");

        getEventBus().addHandlerToSource(ComputerHackedEvent.TYPE, zeroCool, computerA);
        getEventBus().addHandlerToSource(ComputerHackedEvent.TYPE, acidBurn, computerB);

        addToSlot(SLOT_COMPUTERS, computerA);
        addToSlot(SLOT_COMPUTERS, computerB);
    }
}
