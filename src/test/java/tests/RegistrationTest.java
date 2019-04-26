package tests;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegistrationPage;
public class RegistrationTest extends BaseTest {
    @Test(priority = 0)
    public void checkUserRegistrationValidEmailAndPasswordTest(){
        HomePage homePage = new HomePage(driver);
       RegistrationPage registrationPage = new RegistrationPage(driver);
        homePage.goToHomePage()
                .goToRegistrationPage()
                .loginToUser("olka@mail.ru", "olka030389")
                .verifyUser("Message with instructions was sent");

    }
    @Test(priority = 1)
    public void checkUserRegistrationWithExistingEmailTest(){
        HomePage homePage = new HomePage(driver);
        homePage.goToHomePage()
                .goToRegistrationPage()
                .loginToUser("olka030389@yandex.ru", "oli6630389")
                .verifyUser("Error: User already exists");
    }
}
