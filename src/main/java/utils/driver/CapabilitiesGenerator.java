package utils.driver;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.PropertyManager;

@Log4j2
public class CapabilitiesGenerator {

    public static DesiredCapabilities getDefaultCapabilities(DriverType driverType) {
        String driverPath = new PropertyManager().get("drivers.path");
        String os = System.getProperty("os.name").toLowerCase();
        switch (driverType) {
            case FIREFOX:
                if (os.contains("win")) {
                    String driverPathFull = driverPath + "/geckodriver.exe";
                    System.setProperty("webdriver.gecko.driver", driverPathFull);
                    log.info(String.format("Setting property 'webdriver.gecko.driver' for driverType '%s', os '%s' to '%s'",
                            driverType, os, driverPathFull));
                } else if (os.contains("mac")) {
                    System.setProperty("webdriver.gecko.driver", driverPath + "/geckodriver");
                } else {
                }
                if (System.getProperty("webdriver.gecko.driver") == null) {
                    throw new IllegalStateException("System variable 'webdriver.gecko.driver' should be set to path for executable driver");
                }
                return DesiredCapabilities.firefox();

            case CHROME:
                if (os.contains("win")) {
                    String driverPathAll = driverPath + "/chromedriver.exe";
                    System.setProperty("webdriver.chrome.driver", driverPathAll);
                    log.info(String.format("Setting property 'webdriver.chrome.driver' for driverType '%s', os '%s' to '%s'",
                            driverType, os, driverPathAll));
                } else if (os.contains("mac")) {
                    System.setProperty("webdriver.chrome.driver", driverPath + "/chromedriver");
                } else {
                }
                if (System.getProperty("webdriver.chrome.driver") == null) {
                    throw new IllegalStateException("System variable 'webdriver.chrome.driver' should be set to path for executable driver");
                }
                return DesiredCapabilities.chrome();

            case IE10:
                DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
                caps.setVersion("10");
                return caps;

            case SAFARI:
                return new DesiredCapabilities();

            default:
                throw new IllegalStateException("Browser is not supported");
        }
    }

    public static ChromeOptions getChromeOptions() {
        String driverPath = new PropertyManager().get("drivers.path");
        ChromeOptions options = new ChromeOptions();
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("win")) {
            String driverPathLong = driverPath + "/chromedriver.exe";
            System.setProperty("webdriver.chrome.driver", driverPathLong);
            log.info(String.format("Setting property 'webdriver.chrome.driver' for '%s', os '%s' to '%s'",options,
                     os, driverPathLong));
        } else if (os.contains("mac")) {
            System.setProperty("webdriver.chrome.driver", driverPath + "/chromedriver");
        }
        options.addArguments("--start-maximized");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-popup-blocking");
        return options;
    }

    public static FirefoxOptions getFireFoxOptions() {
        String driverPath = new PropertyManager().get("drivers.path");
        FirefoxOptions options = new FirefoxOptions();
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("win")) {
            String driverPathTotal = driverPath + "/geckodriver.exe";
            System.setProperty("webdriver.gecko.driver",driverPathTotal);
            log.info(String.format("Setting property 'webdriver.gecko.driver' for driverType '%s', os '%s' to '%s'",
                    options, os, driverPathTotal));
        } else if (os.contains("mac")) {
            System.setProperty("webdriver.gecko.driver", driverPath + "/geckodriver");
        } else {
        }
        if (System.getProperty("webdriver.gecko.driver") == null) {
            throw new IllegalStateException("System variable 'webdriver.gecko.driver' should be set to path for executable driver");
        }
        options.setCapability("marionette", true);
        return options;
    }
}

