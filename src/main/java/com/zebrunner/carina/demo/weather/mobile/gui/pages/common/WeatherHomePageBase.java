package com.zebrunner.carina.demo.weather.mobile.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class WeatherHomePageBase extends AbstractPage {
    public WeatherHomePageBase(WebDriver driver) {
        super(driver);
    }

    public WeatherSearchPageBase clickSearchButton() {
        WebElement searchButton = driver.findElement(By.id("search_icon"));
        searchButton.click();
        return initPage(getDriver(), WeatherSearchPageBase.class);
    }

    public abstract boolean isWeatherAlertDisplayed();
    public abstract boolean isPageOpened();
    public abstract WeatherAlertPageBase clickWeatherAlert();
    public abstract NotificationsPageBase navigateToNotifications();
    public abstract String getLastUpdate();
    public abstract String getWeatherCondition();
    public abstract String getCityName();
    public abstract String getCurrentTemperature();
}
