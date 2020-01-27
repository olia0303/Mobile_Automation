package utils.appium;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import java.io.File;

public final class AppiumServerJava {
    
    public static AppiumDriverLocalService startServer() {

        AppiumDriverLocalService service = AppiumDriverLocalService.buildService(
                new AppiumServiceBuilder()
                        .withIPAddress("127.0.0.1")
                        .usingPort(4723)
                        //for home
                       //.withAppiumJS(new File("C:\\Program Files\\Appium\\resources\\app\\node_modules\\appium\\build\\lib\\main.js"))
                        .withAppiumJS(new File("C:\\Users\\Volha.Saldatsenkava\\AppData\\Local\\Programs\\Appium\\resources\\app\\node_modules\\appium\\build\\lib\\main.js"))
                        .usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"))
                        .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
                        .withArgument(GeneralServerFlag.LOG_LEVEL, "error"));
        service.start();
        return service;
    }
}


