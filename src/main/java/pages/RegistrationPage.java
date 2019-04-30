package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage extends BasePage {

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    private static final By USER_EMAIL_BY = By.xpath(".//*[@name='email']");
    private static final By USER_PASSWORD_BY = By.xpath(".//*[@name='password']");
    private static final By SIGN_IN_BUTTON_BY = By.xpath("//*[@id='signup-form']/button");
    private static final By ERROR_MESSAGE_BY = By.xpath("//span[@data-notify='message']");
    private static final By MESSAGE_USER_BY = By.xpath("//span[@data-notify='message']");

    public RegistrationPage addNewUser(String login, String password) {
        writeText(USER_EMAIL_BY, login);
        writeText(USER_PASSWORD_BY, password);
        click(SIGN_IN_BUTTON_BY);
        return this;
    }

    public RegistrationPage verifyMessageWithInstruction(String expectedText) {
        assertEquals(MESSAGE_USER_BY, expectedText);
        return this;
    }

    public RegistrationPage verifyMessage(String expectedText) {
        assertEquals(ERROR_MESSAGE_BY, expectedText);
        return this;
    }






}
