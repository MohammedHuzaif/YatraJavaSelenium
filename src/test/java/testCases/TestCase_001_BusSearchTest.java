package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.BookBusTicketsPage;
import pageObjects.BusScheduleSearchResultsPage;
import pageObjects.HomePage;
import pageObjects.NavigationBar;
import testBase.BaseClass;

public class TestCase_001_BusSearchTest extends BaseClass {
    @Test(groups = {"Regression"})
    void test_BusBook(){
        logger.info("**** TC_001_BusBookScenario ****");

        NavigationBar navigationBar = new NavigationBar(driver);
        HomePage homePage = new HomePage(driver);
        BookBusTicketsPage bookBusTicketsPage = new BookBusTicketsPage(driver);
        BusScheduleSearchResultsPage busScheduleSearchResultsPage = new BusScheduleSearchResultsPage(driver);

        String sourceShortText = "Mumbai";
        String sourceFullText = "Mumbai, Maharashtra";
        String destinationShortText = "Hyderabad";
        String destinationFullText = "Hyderabad, Telangana";
        String getNumberOfResultsText = "We have got";

//        homePage.clickCookiesAgreeButton();
//        logger.info("Clicked on 'Cookies' Agree button");
        navigationBar.clickBusesIcon();
        logger.info("Clicked on Buses icon from the Top");

        bookBusTicketsPage.typeIntoBusFromTextInputBox(sourceShortText);
        logger.info("Typed "+sourceShortText+" in Depart From text input box");
        bookBusTicketsPage = new BookBusTicketsPage(driver);
        bookBusTicketsPage.selectByValueFromBusFromDropDown(sourceFullText);
        logger.info("Selected "+sourceFullText+" from drop down.");

        bookBusTicketsPage.typeIntoBusToTextInputBox(destinationShortText);
        logger.info("Typed "+destinationShortText+" in Destination text input box");
        bookBusTicketsPage = new BookBusTicketsPage(driver);
        bookBusTicketsPage.selectByValueFromBusToDropDown(destinationFullText);
        logger.info("Selected "+destinationFullText+" from drop down.");

        bookBusTicketsPage.clickSearchBussesButton();
        logger.info("Clicked on Search Buses button");

        logger.info("Verify selected depart from value");
        Assert.assertEquals(busScheduleSearchResultsPage.getNumberOfResultsText(),getNumberOfResultsText);

        logger.info("Verify Source and destination in the page title: Yatra.com | Mumbai to Hyderabad Bus");
        Assert.assertEquals(getPageTitle(),"Yatra.com | "+sourceShortText+" to "+destinationShortText+" Bus");
    }
}
