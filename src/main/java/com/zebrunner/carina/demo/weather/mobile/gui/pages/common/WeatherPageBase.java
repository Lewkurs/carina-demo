package com.zebrunner.carina.demo.weather.mobile.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class WeatherPageBase extends AbstractPage {
    public WeatherPageBase(WebDriver driver) {
        super(driver);
    }
    public abstract boolean isPageOpened();
}