package steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import pages.ChatPage;
import static com.module.DataUser.*;


@Log4j2
public class ChatSteps {
    private ChatPage chatPage;

    public ChatSteps (WebDriver driver) {
        chatPage = new ChatPage(driver);
    }

    @Step("Open Chat Page")
    public ChatSteps openPage() {
        chatPage.openPage();
        return this;
    }

    @Step("Fill profile")
    public ChatSteps fillProfile(String name,String login,String url) {
        log.info("Type data user:" + name + login + url);
        chatPage.addNewUserInChat(NAME, NEW_LOGIN, PHOTO_URL);
        return this;
    }

    @Step ("Check user icon")
    public ChatSteps verifyUserIcon() {
        chatPage.verifyUserIcon(NAME);
        return this;
    }

    @Step ("Check profile")
    public ChatSteps checkProfile() {
        chatPage.verifySettings(NAME, NEW_LOGIN, PHOTO_URL);
        return this;
    }

    @Step ("Send message in chat")
    public ChatSteps sendMessage(String text) {
        log.info("Type message: " + text);
        chatPage.sendingMessageByUser(TEXT);
        return this;
    }

    @Step("Check message details")
    public ChatSteps verifyMessage() {
        chatPage.verifyDetailsMessage(NAME, TEXT);
        return this;
    }
}