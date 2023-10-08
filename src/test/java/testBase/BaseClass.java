package testBase;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

public class BaseClass {

    public static WebDriver driver;
    public Logger logger;
    public ResourceBundle resourceBundle;

    @BeforeClass(groups = {"Regression", "Sanity", "Smoketest"})
    @Parameters("browser")
    public void setup(String br){
        resourceBundle = ResourceBundle.getBundle("config");
        logger = LogManager.getLogger(this.getClass());

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches",new String[] {"enable-automation"});
        options.addArguments("--remote-allow-origins=*");

        switch (br) {
            case "chrome" -> driver = new ChromeDriver(options);
            case "firefox" -> driver = new FirefoxDriver();
            case "edge" -> driver = new EdgeDriver();
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get(resourceBundle.getString("appURL"));
    }

    @AfterClass(groups = {"Regression", "Sanity", "Smoketest"})
    public void tearDown(){
        driver.quit();
    }

    public String randomString(){
        return RandomStringUtils.randomAlphabetic(5);
    }

    public String randomNumber(){
        return RandomStringUtils.randomNumeric(10);
    }

    public String randomAlphanumeric(){
        return randomString()+randomNumber();
    }

    public String captureScreen(String tName) throws IOException {

        String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String destination = System.getProperty("user.dir") + "\\screenshots\\" + tName + "_" + timeStamp + ".png";

        try {
            FileUtils.copyFile(source, new File(destination));
        } catch (Exception e) {
            e.getMessage();
        }
        return destination;
    }

    public String getPageTitle(){
        return driver.getTitle();
    }

    public String getCurrentURL(){
        return driver.getCurrentUrl();
    }

    public void acceptAlertPopUp(){
        driver.switchTo().alert().accept();
    }

    public void dismissAlertPopUp(){
        driver.switchTo().alert().dismiss();
    }
}
