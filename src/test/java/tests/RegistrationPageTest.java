/*package tests;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import static com.module.DataUser.*;


public class RegistrationPageTest extends BaseTest {
    @Test
    @Description("Sign up into the app")
    public void signUpTest() {
        registrationSteps.openPage()
                         .signUp(NEW_LOGIN, PASSWORD)
                         .checkMessage();
    }

    @Test
    @Description("Sign up into the app with existing email")
    public void signUpWithExistingEmailTest() {
        registrationSteps.openPage()
                         .existingLogin()
                         .checkErrorMessage();
    }
}
*/