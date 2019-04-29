package tests;

import org.testng.annotations.Test;
import pages.ChatPage;
import pages.HomePage;

import static module.DataUser.*;

public class ChatTest extends BaseTest {
    @Test
    public void checkRegisteredNewUserChatTest(){
        HomePage homePage = new HomePage(driver);
        ChatPage chatPage = new ChatPage(driver);
        homePage.goToHomePage()
                .goToChatPage()
                .addNewUserInChat(NAME,EMAIL)
                .verifyIsRegisteredUser();
    }
    @Test
    public void checkSendingMessageByUserTest(){
        HomePage homePage = new HomePage(driver);
        ChatPage chatPage = new ChatPage(driver);
        homePage.goToHomePage()
                .goToChatPage()
                .sendingMessageByUser(TEXT)
                .verifySendMessage(LAST_MESSAGE,TEXT);
    }
}
