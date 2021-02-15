package utils.driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;

import java.util.concurrent.TimeUnit;

public class IOSDriverManager extends DriverManager {
    @Override
    public AppiumDriver createDriver(AppiumDriverLocalService service) {
        driver = new IOSDriver(service, cap);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        return driver;
    }
}
