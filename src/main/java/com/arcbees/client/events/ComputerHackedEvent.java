package com.arcbees.client.events;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

import com.google.gwt.event.shared.HasHandlers;

public class ComputerHackedEvent extends GwtEvent<ComputerHackedEvent.ComputerHackedHandler> {
    public interface ComputerHackedHandler extends EventHandler, HasHandlers {
        void onSystemHacked(ComputerHackedEvent event);
    }

    public static final Type<ComputerHackedHandler> TYPE = new Type<>();

    private final String hackerName;

    public ComputerHackedEvent(String hackerName) {
        this.hackerName = hackerName;
    }

    public static void fire(String hackerName, HasHandlers source) {
        source.fireEvent(new ComputerHackedEvent(hackerName));
    }

    public String getHackerName() {
        return hackerName;
    }

    @Override
    public Type<ComputerHackedHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(ComputerHackedHandler handler) {
        handler.onSystemHacked(this);
    }
}
