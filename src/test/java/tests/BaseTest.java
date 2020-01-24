package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.appium.AppiumServerJava;
import utils.driver.AndroidDriverManager;
import utils.driver.DriverManager;

public class BaseTest {

    AppiumDriverLocalService appiumService;
    AppiumDriver driver;
  

    @BeforeClass
    void startAppiumServer() {
        appiumService = AppiumServerJava.startServer();
        DriverManager manager =  new AndroidDriverManager();
        driver = manager.getDriver(appiumService);
    }

    @AfterClass
    void stopAppiumServer() {
        driver.quit();
        appiumService.stop();
    }
}


