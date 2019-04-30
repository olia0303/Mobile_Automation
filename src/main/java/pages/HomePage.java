package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static module.DataUser.URL;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    private static final By SIGN_IN_BUTTON_BY = By.linkText("Sign up");
    private static final By LOG_IN_BUTTON_BY = By.linkText("Log in");
    private static final By CHAT_IN_BUTTON_BY = By.xpath(".//a[@href='/demo/chat/new\']");

    public HomePage goToHomePage() {
        driver.get(URL);
        return this;
    }

    public RegistrationPage goToRegistrationPage() {
        click(SIGN_IN_BUTTON_BY);
        return new RegistrationPage(driver);
    }

    public LoginPage goToLoginPage() {
        click(LOG_IN_BUTTON_BY);
        return new LoginPage(driver);
    }

    public ChatPage goToChatPage() {
        click(CHAT_IN_BUTTON_BY);
        return new ChatPage(driver);
    }
}




