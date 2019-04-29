package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static module.DataUser.URL;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }
    By signInButtonBy = By.linkText("Sign up");
    By logInButtonBy = By.linkText("Log in");
    By chatInButtonBy = By.xpath(".//a[@href=\"/demo/chat/new\"]");
    public HomePage goToHomePage (){
        driver.get(URL);
        return this;
    }
    public RegistrationPage goToRegistrationPage (){
        click(signInButtonBy);
        return new RegistrationPage(driver);
    }
    public LoginPage goToLoginPage(){
        click(logInButtonBy);
        return new LoginPage(driver);
    }
    public ChatPage goToChatPage(){
        click(chatInButtonBy);
        return new ChatPage(driver);
    }
}




