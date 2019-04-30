package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    private static final By USER_EMAIL_BY = By.xpath(".//*[@name='email']");
    private static final By USER_PASSWORD_BY = By.xpath(".//*[@name='password']");
    private static final By LOGIN_BUTTON_BY = By.className("btn");
    private static final By LOGOUT_BUTTON_BY = By.xpath(".//a[@href='logout']");
    private static final By FORGOT_PASSWORD_LINK_BY =  By.className("forgot");
    private static final By RECOVERY_BUTTON_BY = By.xpath("//*[@class='btn btn-primary']");
    private static final By MESSAGE_WITH_INSTRUCTION_BY = By.xpath("//span[@data-notify='message']");

    public LoginPage logInAsRegisteredUser(String username, String password) {
        writeText(USER_EMAIL_BY, username);
        writeText(USER_PASSWORD_BY, password);
        click(LOGIN_BUTTON_BY);
        click(LOGOUT_BUTTON_BY);
        return this;
    }

    public LoginPage forgotPassword(String username) {
         writeText(USER_EMAIL_BY, username);
         click(FORGOT_PASSWORD_LINK_BY);
         writeText(USER_EMAIL_BY, username);
         click(RECOVERY_BUTTON_BY);
         return this;
     }

     public LoginPage verifyMessage(String expectedText) {
        assertEquals(MESSAGE_WITH_INSTRUCTION_BY, expectedText);
        return this;
    }
}
