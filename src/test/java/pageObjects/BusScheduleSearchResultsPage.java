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

    public String getNumberOfResultsText(){
        System.out.println("numberOfResultsTextBlock: "+ numberOfResultsTextBlock.getText());
        return numberOfResultsTextBlock.getText();
    }
}
