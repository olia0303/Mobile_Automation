package utils.driver;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.PropertyManager;

public class CapabilitiesGenerator {

    public static DesiredCapabilities getDefaultCapabilities(DriverType driverType) {
        String driverPath = new PropertyManager().get("drivers.path");
        String os = System.getProperty("os.name").toLowerCase();
        switch (driverType) {
            case FIREFOX:
                if (os.contains("win")) {
                    System.setProperty("webdrivers.gecko.driver", driverPath + "/geckodriver.exe");
                } else if (os.contains("mac")) {
                    System.setProperty("webdrivers.gecko.driver", driverPath + "/geckodriver");
                } else {
                }
                if (System.getProperty("webdrivers.gecko.driver") == null) {
                    throw new IllegalStateException("System variable 'webdrivers.gecko.driver' should be set to path for executable driver");
                }
                return DesiredCapabilities.firefox();

            case CHROME:
                if (os.contains("win")) {
                    System.setProperty("webdrivers.chrome.driver", driverPath + "/chromedriver1.exe");
                } else if (os.contains("mac")) {
                    System.setProperty("webdrivers.chrome.driver", driverPath + "/chromedriver");
                } else {
                }
                if (System.getProperty("webdrivers.chrome.driver") == null) {
                    throw new IllegalStateException("System variable 'webdrivers.chrome.driver' should be set to path for executable driver");
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
            System.setProperty("webdrivers.chrome.driver", driverPath + "/chromedriver1.exe");
        } else if (os.contains("mac")) {
            System.setProperty("webdrivers.chrome.driver", driverPath + "/chromedriver");
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
            System.setProperty("webdrivers.gecko.driver", driverPath + "/geckodriver.exe");
        } else if (os.contains("mac")) {
            System.setProperty("webdrivers.gecko.driver", driverPath + "/geckodriver");
        } else {
        }
        if (System.getProperty("webdrivers.gecko.driver") == null) {
            throw new IllegalStateException("System variable 'webdrivers.gecko.driver' should be set to path for executable driver");
        }
        options.setCapability("marionette", true);
        return options;
    }
}

