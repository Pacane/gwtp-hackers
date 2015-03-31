package com.arcbees.client.application.home;

import javax.inject.Inject;

import com.arcbees.client.place.NameTokens;
import com.arcbees.client.widgets.computer.ComputerPresenter;
import com.arcbees.client.widgets.computer.WidgetsFactory;
import com.arcbees.client.widgets.hacker.HackerPresenter;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;

public class RootPresenter extends Presenter<RootPresenter.MyView, RootPresenter.MyProxy> {
    interface MyView extends View {
    }

    @ProxyStandard
    @NameToken(NameTokens.home)
    interface MyProxy extends ProxyPlace<RootPresenter> {
    }

    public static final Object SLOT_COMPUTERS = new Object();
    public static final Object SLOT_HACKERS = new Object();

    private final WidgetsFactory widgetsFactory;

    @Inject
    RootPresenter(
            EventBus eventBus,
            MyView view,
            MyProxy proxy,
            WidgetsFactory widgetsFactory) {
        super(eventBus, view, proxy, RevealType.Root);

        this.widgetsFactory = widgetsFactory;
    }

    @Override
    protected void onBind() {
        super.onBind();

        HackerPresenter zeroCool = widgetsFactory.createHacker("Zer0C00L");
        HackerPresenter acidBurn = widgetsFactory.createHacker("AcidBurn");

        addToSlot(SLOT_HACKERS, zeroCool);
        addToSlot(SLOT_HACKERS, acidBurn);

        ComputerPresenter computerA = widgetsFactory.createComputer("A");
        ComputerPresenter computerB = widgetsFactory.createComputer("B");

        computerA.addComputerHackedHandler(computerA, zeroCool);
        computerB.addComputerHackedHandler(computerB, acidBurn);

        addToSlot(SLOT_COMPUTERS, computerA);
        addToSlot(SLOT_COMPUTERS, computerB);
    }
}
