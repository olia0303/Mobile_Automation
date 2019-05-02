package tests;

import org.testng.annotations.Test;
import static com.module.DataUser.*;

public class LoginTest extends BaseTest {

    @Test
    public void checkValidUserAndPassword() {
        loginPage.openPage()
                 .logInAsRegisteredUser(LOGIN,PASSWORD)
                 .isPageOpened();
    }

    @Test
    public void checkUserForgotPasswordTest() {
        loginPage.openPage()
                 .forgotPassword(LOGIN )
                 .verifyMessage(MESSAGE_WITH_INSTRUCTION);
    }

    @Test
    public void checkInValidUserAndPassword() {
        loginPage.openPage()
                  .nonActivatedUser(NEW_LOGIN,PASSWORD_USER)
                  .verifyMessageNonActivatedUser(MESSAGE_NO_ACTIVATION);
    }
}
