package automationframework.support.keywords.core;

public interface IAlert {

    boolean isAlertPresent();

    void waitUntilAlertPresent();

    String getAlertText();

    void acceptAlert();
}