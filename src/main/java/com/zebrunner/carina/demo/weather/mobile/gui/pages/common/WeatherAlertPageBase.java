package com.zebrunner.carina.demo.weather.mobile.gui.pages.common;

import org.openqa.selenium.WebDriver;
import com.zebrunner.carina.webdriver.gui.AbstractPage;

public abstract class WeatherAlertPageBase extends AbstractPage {

    public WeatherAlertPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isAlertDetailsDisplayed();
}

