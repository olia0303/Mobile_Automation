package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static com.module.DataUser.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@Log4j2
public class RegistrationPage extends BasePage {

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    private static final By USER_EMAIL_BY = By.xpath("//input[@name='email']");
    private static final By USER_PASSWORD_BY = By.xpath(".//*[@name='password']");
    private static final By SIGN_IN_BUTTON_BY = By.xpath("//*[@id='signup-form']/button");
    private static final By ERROR_MESSAGE_BY = By.xpath("//span[@data-notify='message']");
    private static final By MESSAGE_USER_BY = By.xpath("//span[@data-notify='message']");
    private static final By MESSAGE_BY = By.xpath("//div[contains(text(),'Please Sign up to continue')]");

    @Override
    public RegistrationPage openPage() {
        driver.get(URL_SIGN_IN);
        log.info("Loading Registration page");
        return this;
    }

    @Override
    public RegistrationPage isPageOpened() {
        isDisplayedElement(MESSAGE_BY);
        return this;
    }

    public RegistrationPage addNewUser(String login, String password) {
        writeText(USER_EMAIL_BY, login);
        writeText(USER_PASSWORD_BY, password);
        click(SIGN_IN_BUTTON_BY);
        return this;
    }

    public RegistrationPage verifyMessageWithInstruction(String expectedText) {
        String message = readText(MESSAGE_USER_BY);
        assertThat(message, equalTo(expectedText));
        return this;
    }

    public RegistrationPage verifyMessage(String expectedText) {
        String message = readText(ERROR_MESSAGE_BY);
        assertThat(message, equalTo(expectedText));
        return this;
    }
}
