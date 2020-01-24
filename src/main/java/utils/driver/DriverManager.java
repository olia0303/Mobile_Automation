package utils.driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.remote.DesiredCapabilities;


public abstract class DriverManager {

    AppiumDriver driver;
    DesiredCapabilities cap = new DesiredCapabilities();
    
    protected abstract AppiumDriver createDriver(AppiumDriverLocalService service);
   
    public AppiumDriver getDriver(AppiumDriverLocalService service) {
        if (null == driver) {
            cap.setCapability("platformName", "Android");
            cap.setCapability("deviceName", "Nexus5X");
            cap.setCapability("appActivity", "com.android.calculator2.Calculator");
            cap.setCapability("appPackage", "com.android.calculator2");
            cap.setCapability("avd", "Nexus5X");
            driver = createDriver(service);
        }
        return driver;
    }
}

    
   
