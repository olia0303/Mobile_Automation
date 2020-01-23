package utils.appium;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

public final class AppiumServerJava {
    
    public static AppiumDriverLocalService startServer() {
        //Set Capabilities
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("platformName", "Android");
        cap.setCapability("deviceName", "Nexus5X");
        cap.setCapability("appActivity", "com.android.calculator2.Calculator");
        cap.setCapability("appPackage", "com.android.calculator2");
        cap.setCapability("avd", "Nexus5X");
        
        AppiumDriverLocalService service = AppiumDriverLocalService.buildService(
                new AppiumServiceBuilder()
                        .withIPAddress("127.0.0.1")
                        .usingPort(4723)
                        .withCapabilities(cap)
                        .withAppiumJS(new File("C:\\Users\\Volha.Saldatsenkava\\AppData\\Local\\Programs\\Appium\\resources\\app\\node_modules\\appium\\build\\lib\\main.js"))
                        .usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"))
                        .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
                        .withArgument(GeneralServerFlag.LOG_LEVEL, "error"));
        service.start();
        return service;
    }
}


