package com.arcbees.client.widgets.computer;

import com.arcbees.client.widgets.hacker.HackerPresenter;

public interface WidgetsFactory {
    ComputerPresenter createComputer(String computerName);
    HackerPresenter createHacker(String hackerName);
}
