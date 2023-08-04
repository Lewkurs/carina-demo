package com.zebrunner.carina.demo.weather.mobile.gui.pages.common;

import org.openqa.selenium.WebDriver;
import com.zebrunner.carina.webdriver.gui.AbstractPage;

public abstract class NotificationsPageBase extends AbstractPage {

    public NotificationsPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract NotificationSettingsPageBase navigateToSettings();
    public abstract boolean isNotificationsDisplayed();
    public abstract boolean isDailyForecastNotificationDisplayed();

}


