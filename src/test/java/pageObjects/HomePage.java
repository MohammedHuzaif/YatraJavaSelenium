package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import testBase.BasePage;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".btngdpr")
    WebElement cookiesAgreeButton;

    @FindBy(css="a .ico-newHeaderLogo")
    WebElement headerLogo;

    public void clickHeaderLogo(){
        headerLogo.click();
    }

    public void clickCookiesAgreeButton(){
        cookiesAgreeButton.click();
    }
}
