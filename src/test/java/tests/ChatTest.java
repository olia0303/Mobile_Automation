package tests;

import org.testng.annotations.Test;
import pages.ChatPage;
import pages.HomePage;

public class ChatTest extends BaseTest {
    @Test
    public void checkRegisteredNewUserChatTest(){
        HomePage homePage = new HomePage(driver);
        ChatPage chatPage = new ChatPage(driver);
        homePage.goToHomePage()
                .goToChatPage()
                .addNewUserInChat("olia","olis@ru")
                .verifyIsRegisteredUser();
    }










}
