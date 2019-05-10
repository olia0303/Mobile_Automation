package tests;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import static com.module.DataUser.*;


public class LoginPageTest extends BaseTest {
    @Test
    @Description("Login into the app")
    public void loginByUserTest() {
      loginSteps.openPage()
                .logIn()
                .isPageOpened();
    }

    @Test
    @Description("Check link [Forgot?]")
    public void userForgotPasswordTest() {
        loginSteps.openPage()
                .forgotPassword();
    }

    @Test
    @Description("Login into the app as a non-existent user")
    public void loginByNonExistentUserTest() {
        loginSteps.openPage()
                  .logInNonActivatedUser(EMAIL, PASSWORD)
                  .verifyMessageNonActivatedUser();
    }
}
