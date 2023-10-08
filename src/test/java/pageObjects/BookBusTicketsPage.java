package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testBase.BasePage;

import java.util.List;

public class BookBusTicketsPage extends BasePage {
    public BookBusTicketsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "input#BE_bus_from_station ")
    WebElement busFromTextInputBox;

    @FindBy(css = "input#BE_bus_to_station ")
    WebElement busToTextInputBox;

    @FindBy(css= ".ac_results.origin_ac li")
    List<WebElement> busFromSearchResultsDropDown_WebElementList;

    @FindBy(css= ".ac_results.dest_ac li")
    List<WebElement> busToSearchResultsDropDown_WebElementList;

    @FindBy(id = "BE_bus_search_btn")
    WebElement searchBusesButton;

    public void typeIntoBusFromTextInputBox(String value){
        busFromTextInputBox.click();
        busFromTextInputBox.sendKeys(value);
    }

    public void typeIntoBusToTextInputBox(String value){
        busToTextInputBox.click();
        busToTextInputBox.sendKeys(value);
    }

    public void selectByValueFromBusFromDropDown(String value){
        for(WebElement dropDownElement: busFromSearchResultsDropDown_WebElementList) {
            if(dropDownElement.getText().equals(value)){
                dropDownElement.click();
                break;
            }
        }
    }

    public void selectByValueFromBusToDropDown(String value){
        for(WebElement dropDownElement: busToSearchResultsDropDown_WebElementList) {
            if(dropDownElement.getText().equals(value)){
                dropDownElement.click();
                break;
            }
        }
    }

    public String getSelectedBusFromValue(){
        return busFromTextInputBox.getText();
    }

    public void clickSearchBussesButton() {
        searchBusesButton.click();
    }
}
