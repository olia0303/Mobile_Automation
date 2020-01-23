package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.appium.AppiumServerJava;

public class BaseTest {

    AppiumDriverLocalService appiumService;
    AppiumDriver driver;
    
    @BeforeClass
    void startAppiumServer() {
        appiumService = AppiumServerJava.startServer();
    }           

//    @AfterClass
//    void stopAppiumServer(){
//        driver.quit();
//        appiumService.stop();
//    }
}

