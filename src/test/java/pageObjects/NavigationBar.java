package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testBase.BasePage;

public class NavigationBar extends BasePage
{
    public NavigationBar(WebDriver driver) {
        super(driver);
    }


    @FindBy(css=".demo-icon.icon-buses")
    WebElement busesIcon;

    public void clickBusesIcon(){
        busesIcon.click();
    }
}
