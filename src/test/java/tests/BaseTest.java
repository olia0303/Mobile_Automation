package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import utils.driver.DriverManager;

public class BaseTest {

    public WebDriver driver;
    HomePage homePage;

    @BeforeMethod
    public void startBrowser() {
        DriverManager manager = new DriverManager();
        driver = manager.getDriver();
        homePage = new HomePage(driver);
    }

    @AfterClass
    void stopBrowser() {
        driver.quit();
    }

    WebDriver getDriver() {
        return driver;
    }

}

