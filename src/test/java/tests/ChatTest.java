package tests;

import org.testng.annotations.Test;
import static module.DataUser.*;

public class ChatTest extends BaseTest {

    @Test
    public void checkRegisteredNewUserChatTest() {
        homePage.goToHomePage()
                .goToChatPage()
                .addNewUserInChat(NAME, EMAIL)
                .verifyUserIcon(NAME)
                .verifySettings(NAME, EMAIL);
    }

    @Test
    public void checkSendingMessageByUserTest() {
        homePage.goToHomePage()
                .goToChatPage()
                .sendingMessageByUser(TEXT)
                .verifySendMessage();
    }
}
