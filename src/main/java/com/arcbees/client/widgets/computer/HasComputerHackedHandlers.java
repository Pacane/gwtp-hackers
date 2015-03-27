package com.arcbees.client.widgets.computer;

import com.arcbees.client.events.ComputerHackedEvent;
import com.google.web.bindery.event.shared.HandlerRegistration;

public interface HasComputerHackedHandlers {
    HandlerRegistration addComputerHackedHandler(ComputerHackedEvent.ComputerHackedHandler handler, Object source);
}
