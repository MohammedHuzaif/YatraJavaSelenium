package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testBase.BasePage;

public class BusScheduleSearchResultsPage extends BasePage {
    public BusScheduleSearchResultsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//h1")
    WebElement numberOfResultsTextBlock;

    @FindBy(xpath = "//input[@name='From']")
    WebElement busFromTextInputBox;

    @FindBy(xpath = "//input[@name='To']")
    WebElement busToTextInputBox;

    public String getNumberOfResultsText(){
        System.out.println("numberOfResultsTextBlock: "+ numberOfResultsTextBlock.getText());
        return numberOfResultsTextBlock.getText();
    }

    public void typeIntoBusFromTextInputBox(String value){
        busFromTextInputBox.sendKeys(value);
    }

    public void typeIntoBusToTextInputBox(String value){
        busToTextInputBox.sendKeys(value);
    }
}
