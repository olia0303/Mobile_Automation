package utils.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.PropertyManager;

public class DriverManager {

    private WebDriver driver;

    public WebDriver getDriver() {
        String browserType = new PropertyManager().get("browser");
        if (null == driver) {
            DriverType browser = DriverType.valueOf(browserType.toUpperCase());
            switch (browser) {
                case FIREFOX:
                    driver = new FirefoxDriver(CapabilitiesGenerator.getFireFoxOptions());
                    break;
                case CHROME:
                    driver = new ChromeDriver(CapabilitiesGenerator.getChromeOptions());
                    break;
                default:
                    throw new IllegalStateException(String.format("Unsupported browser type: %s", browserType));
            }
        }
        return driver;
    }
}