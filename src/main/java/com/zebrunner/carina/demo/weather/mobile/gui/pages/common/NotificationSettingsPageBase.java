package com.zebrunner.carina.demo.weather.mobile.gui.pages.common;

import org.openqa.selenium.WebDriver;
import com.zebrunner.carina.webdriver.gui.AbstractPage;

public abstract class NotificationSettingsPageBase extends AbstractPage {

    public NotificationSettingsPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isPageOpened();
    public abstract boolean isSettingsCorrect();
}

