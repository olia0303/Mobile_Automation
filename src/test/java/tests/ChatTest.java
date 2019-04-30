package tests;

import org.testng.annotations.Test;
import static module.DataUser.*;

public class ChatTest extends BaseTest {

    @Test
    public void checkRegisteredNewUserChatTest() {
        homePage.goToHomePage()
                .goToChatPage()
                .addNewUserInChat(NAME, EMAIL)
                .verifyIsRegisteredUser(EXPECTED_NAME);
    }

    @Test
    public void checkSendingMessageByUserTest() {
        homePage.goToHomePage()
                .goToChatPage()
                .sendingMessageByUser(TEXT)
                .verifySendMessage();
    }
}
