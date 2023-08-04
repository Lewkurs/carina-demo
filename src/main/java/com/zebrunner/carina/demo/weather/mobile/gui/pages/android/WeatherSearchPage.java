package com.zebrunner.carina.demo.weather.mobile.gui.pages.android;

import com.zebrunner.carina.demo.weather.mobile.gui.pages.common.WeatherSearchPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = WeatherSearchPageBase.class)
public class WeatherSearchPage extends WeatherSearchPageBase {

    @FindBy(id = "search_text")
    private ExtendedWebElement searchBar;

    @FindBy(id = "search_modules_list")
    private ExtendedWebElement searchButton;

    @FindBy(id = "today_card_container")
    private ExtendedWebElement detailedWeatherElement;

    @FindBy(id = "card_daily_forecast_view")
    private ExtendedWebElement fiveDayForecastElement;

    @FindBy(id = "radar_map_image")
    private ExtendedWebElement weatherMapElement;

    public WeatherSearchPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isDetailedWeatherDisplayed() {
        return detailedWeatherElement.isElementPresent(); // checks if the detailed weather element is present
    }

    @Override
    public boolean isFiveDayForecastDisplayed() {
        return fiveDayForecastElement.isElementPresent(); // checks if the five-day forecast element is present
    }

    @Override
    public String getSearchResult() {
        return searchButton.getText(); // retrieves the text of the search result
    }
    @Override
    public boolean isWeatherMapDisplayed() {
        return weatherMapElement.isElementPresent(); // checks if the weather map element is present
    }

    @Override
    public void typeLocation(String location) {
        searchBar.type(location);
    }

    @Override
    public void clickSearch() {
        searchButton.click();
    }
}

