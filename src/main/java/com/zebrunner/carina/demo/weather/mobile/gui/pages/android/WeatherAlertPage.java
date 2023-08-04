package com.zebrunner.carina.demo.weather.mobile.gui.pages.android;

import com.zebrunner.carina.demo.weather.mobile.gui.pages.common.WeatherAlertPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

public class WeatherAlertPage extends WeatherAlertPageBase {

    @FindBy(id = "alert_details") // Update with the correct locator
    private ExtendedWebElement alertDetails;

    public WeatherAlertPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isAlertDetailsDisplayed() {
        return alertDetails.isElementPresent();
    }
}
