package com.zebrunner.carina.demo.weather.mobile.gui.pages.android;

import com.zebrunner.carina.demo.weather.mobile.gui.pages.common.WeatherHomePageBase;
import com.zebrunner.carina.demo.weather.mobile.gui.pages.common.WeatherSearchPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = WeatherHomePageBase.class)
public class WeatherHomePage extends WeatherHomePageBase {

    @FindBy(id = "main_card_view")
    private ExtendedWebElement weatherAlert;

    @FindBy(id = "header_title")
    private ExtendedWebElement headerTitle;

    @FindBy(id = "notifications_icon")
    private ExtendedWebElement notificationsIcon;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc='Go to Alerts and Notifications']")
    private ExtendedWebElement notificationsXpath;

    @FindBy(id = "radar_map_image")
    private ExtendedWebElement weatherMapImage;


    @FindBy(xpath = "//android.widget.ImageView[@content-desc='See Map Details']")
    private ExtendedWebElement mapDetailsXpath;

    @FindBy(id = "daily_forecast_list")
    private ExtendedWebElement fiveDayForecast;

    @FindBy(id = "main_card_view")
    private ExtendedWebElement detailedWeather;

    @FindBy(id = "search_item_container")
    private ExtendedWebElement searchResult;

    @FindBy(id = "navigation_bar_item_icon_view")
    private ExtendedWebElement lastUpdate;

    @FindBy(xpath = "//android.widget.FrameLayout[@content-desc='Hourly Tab']/android.widget.FrameLayout/android.widget.ImageView")
    private ExtendedWebElement hourlyTabXpath;

    @FindBy(id = "details_button")
    private ExtendedWebElement weatherCondition;

    @FindBy(id = "txt_location_name")
    private ExtendedWebElement cityName;

    @FindBy(id = "current_conditions_temperature")
    private ExtendedWebElement currentTemperature;

    public WeatherHomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isWeatherAlertDisplayed() {
        return weatherAlert.isElementPresent();
    }

    @Override
    public boolean isPageOpened() {
        return detailedWeather.isElementPresent();
    }


    public WeatherAlertPage clickWeatherAlert() {
        headerTitle.click();
        return initPage(getDriver(), WeatherAlertPage.class);
    }

    public NotificationsPage navigateToNotifications() {
        notificationsIcon.click();
        return initPage(getDriver(), NotificationsPage.class);
    }

    public String getLastUpdate() {
        return lastUpdate.getAttribute("content-desc");
    }

    public String getWeatherCondition() {
        return weatherCondition.getText();
    }

    public String getCityName() {
        return cityName.getText();
    }

    public String getCurrentTemperature() {
        return currentTemperature.getText();
    }
}

