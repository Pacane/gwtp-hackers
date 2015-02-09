package com.arcbees.client;

import com.google.gwt.junit.client.GWTTestCase;

public class SandboxGwtTest extends GWTTestCase {
    @Override
    public String getModuleName() {
        return "com.arcbees.hackers.AppModule";
    }

    public void testSandbox() {
        assertTrue(true);
    }
}
