package com.zebrunner.carina.demo;

import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.demo.weather.mobile.gui.pages.common.*;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.zebrunner.agent.core.webdriver.RemoteWebDriverFactory.getDriver;

public class WeatherMobileTest implements IAbstractTest, IMobileUtils {

    @Test()
    @MethodOwner(owner = "Luke")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void testWeatherHomePage() {
        WeatherHomePageBase weatherHomePage = initPage(getDriver(), WeatherHomePageBase.class);

        // Check 1: Verify that the weather home page is opened
        Assert.assertTrue(weatherHomePage.isPageOpened(), "Weather home page isn't opened");

        // Check 2: Verify the current temperature display
        String expectedTemperature = "25°C";
        Assert.assertEquals(weatherHomePage.getCurrentTemperature(), expectedTemperature, "Current temperature is incorrect");

        // Check 3: Verify the city name
        String expectedCity = "San Francisco";
        Assert.assertEquals(weatherHomePage.getCityName(), expectedCity, "Displayed city name is incorrect");

        // Check 4: Verify weather condition (e.g., Sunny, Cloudy, etc.)
        String expectedCondition = "Sunny";
        Assert.assertEquals(weatherHomePage.getWeatherCondition(), expectedCondition, "Weather condition is incorrect");

        // Check 5: Verify the date and time of the last update
        String expectedLastUpdate = "Updated 10 minutes ago";
        Assert.assertEquals(weatherHomePage.getLastUpdate(), expectedLastUpdate, "Last update time is incorrect");
    }


    @Test()
    @MethodOwner(owner = "Luke")
    @TestLabel(name = "feature", value = {"mobile", "acceptance"})
    public void testSearchLocationWeatherDetails() {
        WeatherHomePageBase weatherHomePage = initPage(getDriver(), WeatherHomePageBase.class);
        WeatherSearchPageBase weatherSearchPage = weatherHomePage.clickSearchButton();

        // Check 1: Verify the search page is opened
        Assert.assertTrue(weatherSearchPage.isPageOpened(), "Weather search page isn't opened");

        // Check 2: Search for a location and verify the search result
        String searchLocation = "New York";
        weatherSearchPage.typeLocation(searchLocation);
        weatherSearchPage.clickSearch();
        Assert.assertEquals(weatherSearchPage.getSearchResult(), searchLocation, "Search result is incorrect");

        // Check 3: Verify detailed weather information for the searched location
        Assert.assertTrue(weatherSearchPage.isDetailedWeatherDisplayed(), "Detailed weather information is not displayed");

        // Check 4: Verify forecast for the next 5 days
        Assert.assertTrue(weatherSearchPage.isFiveDayForecastDisplayed(), "5-day forecast is not displayed");

        // Check 5: Verify the weather map for the location
        Assert.assertTrue(weatherSearchPage.isWeatherMapDisplayed(), "Weather map is not displayed");
    }


    @Test()
    @MethodOwner(owner = "yourUsername")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void testWeatherAlertsAndNotifications() {
        WeatherHomePageBase weatherHomePage = initPage(getDriver(), WeatherHomePageBase.class);

        // Check 1: Verify weather alerts are displayed
        Assert.assertTrue(weatherHomePage.isWeatherAlertDisplayed(), "Weather alerts are not displayed");

        // Check 2: Click on the weather alert and verify details
        WeatherAlertPageBase weatherAlertPage = weatherHomePage.clickWeatherAlert();
        Assert.assertTrue(weatherAlertPage.isPageOpened(), "Weather alert page isn't opened");
        Assert.assertTrue(weatherAlertPage.isAlertDetailsDisplayed(), "Weather alert details are not displayed");

        // Check 3: Navigate to notifications and verify notifications are displayed
        NotificationsPageBase notificationsPage = weatherHomePage.navigateToNotifications();
        Assert.assertTrue(notificationsPage.isNotificationsDisplayed(), "Notifications are not displayed");

        // Check 4: Verify a specific notification (e.g., a daily forecast notification)
        Assert.assertTrue(notificationsPage.isDailyForecastNotificationDisplayed(), "Daily forecast notification is not displayed");

        // Check 5: Verify the settings of the notifications
        NotificationSettingsPageBase settingsPage = notificationsPage.navigateToSettings();
        Assert.assertTrue(settingsPage.isSettingsCorrect(), "Notification settings are incorrect");
    }


}
