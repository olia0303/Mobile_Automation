package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import static com.module.DataUser.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ChatPage extends BasePage {

    public ChatPage(WebDriver driver) {
        super(driver);
    }

    private static final By SETTINGS_BUTTON_BY = By.xpath("//span[@class='integri-chat-settings integri-pointer']");
    private static final By USER_NAME_BY = By.xpath(".//*[@name='userName']");
    private static final By USER_EMAIL_BY = By.xpath(".//*[@name='userEmail']");
    private static final By USER_PHOTO_BY = By.xpath("//input[@placeholder='Photo URL']");
    private static final By SAVE_BUTTON_BY = By.xpath("//button[@class='integri-user-settings-save integri-button-blue']");
    private static final By FIELD_INPUT_TEXT_BY = By.xpath("//textarea[@placeholder='Start typing here']");
    private static final By SEND_BUTTON_BY = By.xpath(".//*[@title='Send message']");
    private static final By USER_CHAT_BY = By.xpath("//div[@class='integri-modal integri-modal-shown']");
    private static final By USER_ICON_NAME_BY = By.className("integri-session-user-name");
    private static final By PAGE_ICON_BY = By.xpath("//a[@class='navbar-brand logo']");
    private static final By TEXT_MESSAGE_BY = By.className("integri-chat-message-text");
    private static final By DATA_MESSAGE_BY = By.className("integri-chat-message-date");

    @Override
    public ChatPage openPage() {
        driver.get(URL_CHAT);
        return this;
    }

    @Override
    public ChatPage isPageOpened() {
        isDisplayedElement(PAGE_ICON_BY);
        return this;
    }

    public ChatPage addNewUserInChat(String name, String email, String url) {
        click(SETTINGS_BUTTON_BY);
        clear(USER_NAME_BY);
        writeText(USER_NAME_BY, name);
        writeText(USER_EMAIL_BY, email);
        writeText(USER_PHOTO_BY, url);
        click(SAVE_BUTTON_BY);
        waitInVisibility(USER_CHAT_BY);
        return this;
    }

    public ChatPage verifyUserIcon(String expectedUserName) {
        String nameUser = readText(USER_ICON_NAME_BY);
        assertThat(nameUser, equalTo(expectedUserName));
        return this;
    }

    public ChatPage verifySettings(String expectedName, String expectedMail, String expectedPhotoUrl) {
        click(SETTINGS_BUTTON_BY);
        String nameRegisteredUser = driver.findElement(USER_NAME_BY).getAttribute("value");
        String emailRegisteredUser = driver.findElement(USER_EMAIL_BY).getAttribute("value");
        String photoUrlRegisteredUser = driver.findElement(USER_PHOTO_BY).getAttribute("value");
        assertThat(nameRegisteredUser, equalTo(expectedName));
        assertThat(emailRegisteredUser, equalTo(expectedMail));
        assertThat(photoUrlRegisteredUser, equalTo(expectedPhotoUrl));
        return this;
    }

    public ChatPage verifyDetailsMessage(String expectedName, String expectedText) {
        String nameUser = readText(USER_ICON_NAME_BY);
        String dateMessage = readText(DATA_MESSAGE_BY);
        String message = readText(TEXT_MESSAGE_BY);
        assertThat(nameUser, equalTo(expectedName));
        assertThat(message, equalTo(expectedText));
        assertThat(dateMessage, equalTo(inputDate()));
        return this;
    }

    public String inputDate() {
    LocalDateTime myDateObj = LocalDateTime.now();
    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("MM/dd/yyyy, HH:mm");
    String formattedDate = myDateObj.format(myFormatObj);
    return formattedDate;
    }

    public ChatPage sendingMessageByUser(String text) {
        click(FIELD_INPUT_TEXT_BY);
        writeText(FIELD_INPUT_TEXT_BY, text);
        click(SEND_BUTTON_BY);
        return this;
    }
}
