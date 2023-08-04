package com.zebrunner.carina.demo.weather.mobile.gui.pages.android;

import com.zebrunner.carina.demo.weather.mobile.gui.pages.common.NotificationSettingsPageBase;
import org.openqa.selenium.WebDriver;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.support.FindBy;

public class NotificationSettingsPage extends NotificationSettingsPageBase {

    @FindBy(id = "profile_avatar") // Example ID for the title of the settings page
    private ExtendedWebElement settingsTitle;

    @FindBy(id = "notification_option_checkbox") // Example ID for a specific notification option
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
        // Implement logic to verify that the settings are correct, such as checking that specific checkboxes are selected
        // The following is an example that checks if a specific checkbox is selected
        return notificationOptionCheckbox.isChecked();
    }
}
