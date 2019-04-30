package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ChatPage extends BasePage {

    public ChatPage(WebDriver driver) {
        super(driver);
    }

    private static final By SETTINGS_BUTTON_BY = By.xpath("//span[@class='integri-chat-settings integri-pointer']");
    private static final By USER_NAME_BY = By.xpath(".//*[@name='userName']");
    private static final By USER_EMAIL_BY = By.xpath(".//*[@name='userEmail']");
    private static final By SAVE_BUTTON_BY = By.xpath("//button[@class='integri-user-settings-save integri-button-blue']");
    private static final By FIELD_INPUT_TEXT_BY = By.xpath("//textarea[@placeholder='Start typing here']");
    private static final By SEND_BUTTON_BY = By.xpath(".//*[@title='Send message']");
    private static final By USER_CHAT_BY = By.xpath("//div[@class='integri-modal integri-modal-shown']");
    private static final By USER_MESSAGE_LIST_BY = By.xpath("//div[@class='integri-chat-messages-container']");
    private static final By USER_ICON_NAME = By.className("integri-session-user-name");

    public ChatPage addNewUserInChat(String name,String email) {
        click(SETTINGS_BUTTON_BY);
        clear(USER_NAME_BY);
        writeText(USER_NAME_BY, name);
        writeText(USER_EMAIL_BY, email);
        click(SAVE_BUTTON_BY);
        waitInVisibility(USER_CHAT_BY);
        return this;
    }

    public ChatPage waitForUserChat() throws InterruptedException {
        for(int i=0;i<3;i++) {
            if (driver.findElements(USER_CHAT_BY).size() == 0)
                break;
            Thread.sleep(500);
        }
        return this;
    }

    public ChatPage verifyUserIcon(String expectedUserName) {
        String nameUser = readText(USER_ICON_NAME);
        assertThat(nameUser, equalTo(expectedUserName));
        return this;
    }

    public ChatPage verifySettings(String expectedName,String expectedMail) {
        click(SETTINGS_BUTTON_BY);
        String nameRegisteredUser = driver.findElement(USER_NAME_BY).getAttribute("value");
        String emailRegisteredUser = driver.findElement(USER_EMAIL_BY).getAttribute("value");
        assertThat(nameRegisteredUser, equalTo(expectedName));
        assertThat(emailRegisteredUser, equalTo(expectedMail));
        return this;
    }

    public ChatPage sendingMessageByUser(String text) {
        click(FIELD_INPUT_TEXT_BY);
        writeText(FIELD_INPUT_TEXT_BY, text);
        click(SEND_BUTTON_BY);
        return this;
    }

    private List<WebElement> getMessageList() {
        return driver.findElements(USER_MESSAGE_LIST_BY);
    }

    public String getLastMessage() {
        List<WebElement> messages = getMessageList();
        String lastMessage = messages.get(messages.size() - 1).getText();
        return lastMessage;
    }

    public ChatPage verifySendMessage () {
        assertEquals(FIELD_INPUT_TEXT_BY,getLastMessage());
        return this;
    }
}
