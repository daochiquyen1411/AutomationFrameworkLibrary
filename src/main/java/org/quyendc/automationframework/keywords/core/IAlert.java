package org.quyendc.automationframework.keywords.core;

public interface IAlert {

    boolean isAlertPresent();

    void waitUntilAlertPresent();

    String getAlertText();

    void acceptAlert();
}
