package tests;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import static com.module.DataUser.*;

public class ChatPageTest extends BaseTest {

    @Test
    @Description("Fill profile in settings")
    public void fillProfileTest() {
        chatSteps.openPage()
                 .fillProfile(NAME, NEW_LOGIN, PHOTO_URL)
                 .verifyUserIcon()
                 .checkProfile();
    }

    @Test
    @Description("Send message by user")
    public void sendMessageTest() {
        chatSteps.openPage()
                 .fillProfile(NAME, NEW_LOGIN, PHOTO_URL)
                 .sendMessage(TEXT)
                 .verifyMessage();
    }
}
