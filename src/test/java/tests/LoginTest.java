package tests;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends BaseTest {


    @Test(priority = 0)
    public void checkValidUserAndPassword() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        homePage.goToHomePage()
                .goToLoginPage()
                .loginToUser("olka030389@yandex.ru", "oli6630389");

    }

    @Test(priority = 1)
    public void checkUserForgotPasswordTest(){
    HomePage homePage = new HomePage(driver);
    LoginPage loginPage = new LoginPage(driver);
        homePage.goToHomePage()
                .goToLoginPage()
                .forgotPassword("olka030389@yandex.ru" )
                .verifyPassword("Message with instructions was sent");

}
}
