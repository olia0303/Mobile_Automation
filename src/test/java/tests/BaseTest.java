package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;
import utils.appium.AppiumServerJava;
import utils.driver.IOSDriverManager;
import utils.driver.DriverManager;

public class BaseTest {
    private String deviceName = "iPhone 12 Pro Max";
    private String platform = "iOS";
    
    AppiumDriverLocalService appiumService;
    AppiumDriver driver;
    TestPage testPage;

    void setCustomCapabilities(String _deviceName, String _platform){
        deviceName = _deviceName;
        platform = _platform;
    }
    
    @BeforeMethod
    void startAppiumServer() {
        appiumService = AppiumServerJava.startServer();
        DriverManager manager = new IOSDriverManager();
        driver = manager.getDriver(appiumService, deviceName, platform);
        testPage = new TestPage(driver);
    }

    @AfterMethod
    void stopAppiumServer() {
        driver.quit();
        appiumService.stop();
    }
}


