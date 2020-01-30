package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.*;
import utils.appium.AppiumServerJava;
import utils.driver.AndroidDriverManager;
import utils.driver.DriverManager;

public class BaseTest {

    AppiumDriverLocalService appiumService;
    AppiumDriver driver;
    LoginPage loginPage;
    NativeViewPage nativeViewPage;
    SliderPage sliderPage;
    VerticalSwipingPage verticalSwipingPage;
    DoubleTapPage doubleTapPage;
    
    @BeforeClass
    void startAppiumServer() {
        appiumService = AppiumServerJava.startServer();
        DriverManager manager = new AndroidDriverManager();
        driver = manager.getDriver(appiumService);
        loginPage = new LoginPage(driver);
        nativeViewPage = new NativeViewPage(driver);
        sliderPage = new SliderPage(driver);
        verticalSwipingPage = new VerticalSwipingPage(driver);
        doubleTapPage = new DoubleTapPage(driver);
    }

    @AfterClass
    void stopAppiumServer() {
        driver.quit();
        appiumService.stop();
    }
}


