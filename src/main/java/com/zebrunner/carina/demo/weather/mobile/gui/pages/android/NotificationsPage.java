package com.zebrunner.carina.demo.weather.mobile.gui.pages.android;

import com.zebrunner.carina.demo.weather.mobile.gui.pages.common.NotificationSettingsPageBase;
import com.zebrunner.carina.demo.weather.mobile.gui.pages.common.NotificationsPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

public class NotificationsPage extends NotificationsPageBase {

    @FindBy(id = "notifications_list")
    private ExtendedWebElement notificationsList;

    @FindBy(id = "my_alerts_layout_0")
    private ExtendedWebElement dailyForecastNotification;

    @FindBy(id = "profile_avatar")
    private ExtendedWebElement settingsButton;

    public NotificationsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isDailyForecastNotificationDisplayed() {
        return dailyForecastNotification.isElementPresent();
    }

    @Override
    public boolean isNotificationsDisplayed() {
        return notificationsList.isElementPresent();
    }

    @Override
    public NotificationSettingsPageBase navigateToSettings() {
        settingsButton.click();
        return initPage(getDriver(), NotificationSettingsPage.class);
    }

}


