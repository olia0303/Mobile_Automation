package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import utils.driver.DriverManager;

public class BaseTest {
    public WebDriver driver;


    @BeforeMethod

    public void startBrowser() {
        DriverManager manager = new DriverManager();

        driver = manager.getDriver();
    }



    @AfterClass
    void stopBrowser(){

        driver.quit();

    }

    WebDriver getDriver(){

        return driver;

    }

}

