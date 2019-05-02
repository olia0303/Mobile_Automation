package tests;

import org.testng.annotations.Test;
import static com.module.DataUser.*;

public class ChatTest extends BaseTest {

    @Test
    public void checkRegisteredNewUserChatTest() {
        chatPage.openPage()
                .addNewUserInChat(NAME, NEW_LOGIN,PHOTO_URL)
                .verifyUserIcon(NAME)
                .verifySettings(NAME, NEW_LOGIN,PHOTO_URL);
    }

    @Test
    public void checkSendingMessageByUserTest() {
        chatPage.openPage()
                .addNewUserInChat(NAME, NEW_LOGIN,PHOTO_URL)
                .sendingMessageByUser(TEXT)
                .verifyDetailsMessage(NAME,TEXT);
    }
}