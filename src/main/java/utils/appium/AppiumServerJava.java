package utils.appium;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import utils.PropertyManager;

import java.io.File;

public final class AppiumServerJava {
    
    public static AppiumDriverLocalService startServer() {
        final String url = PropertyManager.getInstance().get("appium.server.url");
        final String appiumJsRunner = PropertyManager.getInstance().get("appium.server.js.path");
        final int appiumServerPort = 4723;
        
        AppiumDriverLocalService service = AppiumDriverLocalService.buildService(
                new AppiumServiceBuilder()
                        .withIPAddress(url)
                        .usingPort(appiumServerPort)
                        .withAppiumJS(new File(appiumJsRunner))
                        .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
                        .withArgument(GeneralServerFlag.LOG_LEVEL, "error"));
        service.start();
        return service;
    }
}


