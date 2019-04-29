package tests;
import module.DataUser;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegistrationPage;

import static module.DataUser.*;

public class RegistrationTest extends BaseTest {
    @Test(priority = 0)
    public void checkUserRegistrationValidEmailAndPasswordTest(){
        HomePage homePage = new HomePage(driver);
       RegistrationPage registrationPage = new RegistrationPage(driver);
        homePage.goToHomePage()
                .goToRegistrationPage()
                .loginToUser(LOGIN,PASSWORD)
                .verifyUser(MESSAGE_WITH_INSTRUCTION);

    }
    @Test(priority = 1)
    public void checkUserRegistrationWithExistingEmailTest(){
        HomePage homePage = new HomePage(driver);
        homePage.goToHomePage()
                .goToRegistrationPage()
                .loginToUser(LOGIN,PASSWORD)
                .verifyUser(MESSAGE_ERROR);
    }
}
