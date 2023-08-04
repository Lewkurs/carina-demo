package com.zebrunner.carina.demo.weather.mobile.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class WeatherSearchPageBase extends AbstractPage {
    public WeatherSearchPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void typeLocation(String location);
    public abstract void clickSearch();
    public abstract String getSearchResult();
    public abstract boolean isDetailedWeatherDisplayed();
    public abstract boolean isWeatherMapDisplayed();
    public abstract boolean isFiveDayForecastDisplayed();
}
