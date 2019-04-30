package tests;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import static module.DataUser.*;

public class LoginTest extends BaseTest {

    @Test
    public void checkValidUserAndPassword() {
        homePage.goToHomePage()
                .goToLoginPage()
                .logInAsRegisteredUser(LOGIN,PASSWORD);
    }

    @Test
    public void checkUserForgotPasswordTest(){
        homePage.goToHomePage()
                .goToLoginPage()
                .forgotPassword(LOGIN )
                .verifyMessage(MESSAGE_WITH_INSTRUCTION);
    }
}
