package com.zebrunner.carina.demo.weather.mobile.gui.pages.android;

import com.zebrunner.carina.demo.weather.mobile.gui.pages.common.NotificationSettingsPageBase;
import org.openqa.selenium.WebDriver;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.support.FindBy;

public class NotificationSettingsPage extends NotificationSettingsPageBase {

    @FindBy(id = "profile_avatar")
    private ExtendedWebElement settingsTitle;

    @FindBy(id = "notification_option_checkbox")
    private ExtendedWebElement notificationOptionCheckbox;

    public NotificationSettingsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return settingsTitle.isElementPresent();
    }

    @Override
    public boolean isSettingsCorrect() {
        return notificationOptionCheckbox.isChecked();
    }
}
