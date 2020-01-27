package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import steps.ComponentSteps;
import utils.appium.AppiumServerJava;
import utils.driver.AndroidDriverManager;
import utils.driver.DriverManager;

public class BaseTest {

    AppiumDriverLocalService appiumService;
    AppiumDriver driver;
    ComponentSteps steps;

    @BeforeClass
    void startAppiumServer() {
        appiumService = AppiumServerJava.startServer();
        DriverManager manager =  new AndroidDriverManager();
        driver = manager.getDriver(appiumService);
        steps = new ComponentSteps(driver);
    }

    @AfterClass
    void stopAppiumServer() {
        driver.quit();
        appiumService.stop();
    }
}


