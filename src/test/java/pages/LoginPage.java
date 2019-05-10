package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.module.DataUser.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@Log4j2
public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private static final By USER_EMAIL_BY = By.xpath(".//*[@name='email']");
    private static final By USER_PASSWORD_BY = By.xpath(".//*[@name='password']");
    private static final By LOGIN_BUTTON_BY = By.className("btn");
    private static final By FORGOT_PASSWORD_LINK_BY =  By.className("forgot");
    private static final By RECOVERY_BUTTON_BY = By.xpath("//*[@class='btn btn-primary']");
    private static final By MESSAGE_WITH_INSTRUCTION_BY = By.xpath("//span[@data-notify='message']");
    private  static final By ICON_PAGE_BY = By.xpath("//a[@class='navbar-brand logo']//img");
    private static final By MESSAGE_USER_NOT_FOUND = By.xpath("//span[@data-notify='message']");

    @Override
    public LoginPage openPage() {
        driver.get(URL_LOGIN);
        log.info("Loading Login page");
        return this;
    }

    @Override
    public LoginPage isPageOpened() {
        isDisplayedElement(ICON_PAGE_BY);
        return this;
    }

    public LoginPage logInAsRegisteredUser(String username, String password) {
        writeText(USER_EMAIL_BY, username);
        writeText(USER_PASSWORD_BY, password);
        click(LOGIN_BUTTON_BY);
        return this;
    }

    public LoginPage forgotPassword(String username) {
         writeText(USER_EMAIL_BY, username);
         click(FORGOT_PASSWORD_LINK_BY);
         writeText(USER_EMAIL_BY, username);
         click(RECOVERY_BUTTON_BY);
         return this;
    }

    public LoginPage nonActivatedUser(String email, String password) {
        writeText(USER_EMAIL_BY, email);
        writeText(USER_PASSWORD_BY, password);
        click(LOGIN_BUTTON_BY);
        return this;
    }

    public LoginPage verifyMessageNonActivatedUser(String expectedText) {
        String message = readText(MESSAGE_USER_NOT_FOUND);
        assertThat(message, equalTo (expectedText));
        return this;
    }

    public LoginPage verifyMessage(String expectedText) {
        String message = readText(MESSAGE_WITH_INSTRUCTION_BY);
        assertThat(message, equalTo (expectedText));
        return this;
    }
}
