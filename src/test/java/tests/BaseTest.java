package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import steps.ChatSteps;
import steps.LoginSteps;
import steps.RegistrationSteps;
import utils.driver.DriverManager;

public class BaseTest {

    public WebDriver driver;
    LoginSteps loginSteps;
    RegistrationSteps registrationSteps;
    ChatSteps chatSteps;

    @BeforeMethod
    public void startBrowser() {
        DriverManager manager = new DriverManager();
        driver = manager.getDriver();
        loginSteps = new LoginSteps(driver);
        registrationSteps = new RegistrationSteps(driver);
        chatSteps = new ChatSteps(driver);
    }

    @AfterMethod
    void stopBrowser() {
        driver.quit();
    }
}

