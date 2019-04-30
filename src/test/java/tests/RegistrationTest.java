package tests;

import org.testng.annotations.Test;
import static module.DataUser.*;

public class RegistrationTest extends BaseTest {

    @Test
    public void checkUserRegistrationValidEmailAndPasswordTest() {
        homePage.goToHomePage()
                .goToRegistrationPage()
                .addNewUser(LOGIN,PASSWORD)
                .verifyMessageWithInstruction(MESSAGE_WITH_INSTRUCTION);

    }

    @Test
    public void checkUserRegistrationWithExistingEmailTest() {
        homePage.goToHomePage()
                .goToRegistrationPage()
                .addNewUser(LOGIN,PASSWORD)
                .verifyMessage(MESSAGE_ERROR);
    }
}
