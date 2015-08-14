package com.arcbees.client.application.home;

import javax.inject.Inject;

import com.arcbees.client.widgets.computer.ComputerPresenter;
import com.arcbees.client.widgets.computer.WidgetsFactory;
import com.arcbees.client.widgets.hacker.HackerPresenter;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.UiHandlers;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.presenter.slots.NestedSlot;
import com.gwtplatform.mvp.client.proxy.Proxy;

public class RootPresenter extends Presenter<RootPresenter.MyView, RootPresenter.MyProxy> {
    interface MyUiHandlers extends UiHandlers {
    }

    interface MyView extends View, MyUiHandlers {
    }

    @ProxyStandard
    interface MyProxy extends Proxy<RootPresenter> {
    }

    public static final NestedSlot SLOT_COMPUTERS = new NestedSlot();
    public static final NestedSlot SLOT_HACKERS = new NestedSlot();

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
        zeroCool.unbind();
        addToSlot(SLOT_HACKERS, zeroCool);
        addToSlot(SLOT_HACKERS, acidBurn);

        ComputerPresenter computerA = widgetsFactory.createComputer("A");
        ComputerPresenter computerB = widgetsFactory.createComputer("B");

        computerA.addComputerHackedHandler(computerA, zeroCool);
        computerB.addComputerHackedHandler(computerB, acidBurn);

        addToSlot(SLOT_COMPUTERS, computerA);
        addToSlot(SLOT_COMPUTERS, computerB);
    }

    @Override
    protected void onReset() {
        super.onReset();
    }

    @Override
    protected void onReveal() {
        super.onReveal();
    }
}
