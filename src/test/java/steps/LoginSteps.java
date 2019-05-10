package steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import static com.module.DataUser.*;

@Log4j2
public class LoginSteps {
    private LoginPage loginPage;

    public LoginSteps(WebDriver driver) {
        loginPage = new LoginPage(driver);
    }

    @Step("Open Login Page")
    public LoginSteps openPage() {
        loginPage.openPage();
        return this;
    }

    @Step("Login into the system")
    public LoginSteps logIn() {
        loginPage.logInAsRegisteredUser(LOGIN, PASSWORD);
        return this;
    }

    @Step("Check message if user forgot password")
    public  LoginSteps forgotPassword() {
        loginPage.forgotPassword(LOGIN)
                .verifyMessage(MESSAGE_WITH_INSTRUCTION);
        return this;
    }

    @Step("Login into the system as a non-existent user")
    public LoginSteps logInNonActivatedUser(String email, String password) {
        log.info("Type user data: " + email + password);
        loginPage.nonActivatedUser(EMAIL, PASSWORD);
        return this;
    }

    @Step("Check notify message")
    public LoginSteps verifyMessageNonActivatedUser() {
        loginPage.verifyMessageNonActivatedUser(MESSAGE_NO_ACTIVATION);
        return this;
    }

    @Step ("Check if the page is open")
    public LoginSteps isPageOpened() {
        loginPage.isPageOpened();
        return this;
    }
}