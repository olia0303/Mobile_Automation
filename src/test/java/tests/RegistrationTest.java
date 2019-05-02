package tests;

import org.testng.annotations.Test;
import static com.module.DataUser.*;

public class RegistrationTest extends BaseTest {

    @Test
    public void checkUserRegistrationValidEmailAndPasswordTest() {
        registrationPage.openPage()
                .addNewUser(NEW_LOGIN,PASSWORD)
                .verifyMessageWithInstruction(MESSAGE_WITH_INSTRUCTION);
    }

    @Test
    public void checkUserRegistrationWithExistingEmailTest() {
        registrationPage.openPage()
                .addNewUser(LOGIN,PASSWORD)
                .verifyMessage(MESSAGE_ERROR);
    }
}
