package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.ChatPage;
import pages.LoginPage;
import pages.RegistrationPage;
import utils.driver.DriverManager;

public class BaseTest {

    public WebDriver driver;
    RegistrationPage registrationPage;
    LoginPage loginPage;
    ChatPage chatPage;

    @BeforeMethod
    public void startBrowser() {
        DriverManager manager = new DriverManager();
        driver = manager.getDriver();
        registrationPage = new RegistrationPage(driver);
        loginPage = new LoginPage(driver);
        chatPage = new ChatPage(driver);
    }

    @AfterMethod
    void stopBrowser() {
        driver.quit();
    }
}

