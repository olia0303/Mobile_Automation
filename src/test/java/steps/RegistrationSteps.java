package steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import pages.RegistrationPage;
import static com.module.DataUser.*;

@Log4j2
public class RegistrationSteps {
    private RegistrationPage registrationPage;

    public RegistrationSteps (WebDriver driver) {
        registrationPage = new RegistrationPage(driver);
    }

    @Step("Open Registration Page")
    public RegistrationSteps openPage() {
        log.info("Open Registration page");
        registrationPage.openPage();
        return this;
    }

    @Step("Sign up the system")
    public RegistrationSteps signUp() {
        registrationPage.addNewUser(NEW_LOGIN, PASSWORD);
        return this;
    }

    @Step("Check message with instruction")
    public RegistrationSteps checkMessage() {
        registrationPage.verifyMessageWithInstruction(MESSAGE_WITH_INSTRUCTION);
        return this;
    }

    @Step("Sign in using an existing login")
    public RegistrationSteps existingLogin() {
        registrationPage.addNewUser(LOGIN, PASSWORD);
        return this;
    }

    @Step("Check notify message")
    public RegistrationSteps checkErrorMessage() {
        registrationPage.verifyMessage(MESSAGE_ERROR);
        return this;
    }
}

