package tests;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import static module.DataUser.*;

public class LoginTest extends BaseTest {


    @Test(priority = 0)
    public void checkValidUserAndPassword() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        homePage.goToHomePage()
                .goToLoginPage()
                .loginToUser(LOGIN,PASSWORD);

    }

    @Test(priority = 1)
    public void checkUserForgotPasswordTest(){
    HomePage homePage = new HomePage(driver);
    LoginPage loginPage = new LoginPage(driver);
        homePage.goToHomePage()
                .goToLoginPage()
                .forgotPassword(LOGIN )
                .verifyPassword(MESSAGE_WITH_INSTRUCTION);

}
}
