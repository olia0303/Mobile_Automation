package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ChatPage extends BasePage {
    public ChatPage(WebDriver driver) {
        super(driver);
    }
    By settingsButtonBy = By.xpath(".//*[@class=\"integri-chat-settings integri-pointer\"]");
    By userNameBy = By.xpath(".//*[@name=\"userName\"]");
    By userEmailBy = By.xpath(".//*[@name=\"userEmail\"]");
    By saveButtonBy = By.xpath("//button[@class='integri-user-settings-save integri-button-blue']");
    By fieldInputTextBy = By.xpath("//textarea[@placeholder='Start typing here']");
    By sendButtonBy = By.xpath(".//*[@title=\"Send message\"]");
    By userChatBy = By.xpath(".//div[@class=\"integri-session-user-name\"]");
    By messageEnteredBy = By.xpath("//div[@class='integri-chat-message-text']");
    By listMessagesBy = By.xpath("//div[@class='integri-chat-messages-container']");

    public ChatPage addNewUserInChat(String name,String email){
     click(settingsButtonBy);
     clear(userNameBy);
     writeText(userNameBy,name);
     writeText(userEmailBy,email);
     click(saveButtonBy);
     return this;
    }

    public ChatPage verifyIsRegisteredUser(){
      assertTrue(userChatBy);
        return this;
    }

    public ChatPage sendingMessageByUser(String text) {
        click(fieldInputTextBy);
        writeText(fieldInputTextBy, text);
        click(sendButtonBy);
        return this;
    }
    private List<WebElement> getMessageList()
    {
        return driver.findElements(By.xpath("//div[@class='integri-chat-messages-container']"));
    }
    public String getLastMessage() {
        List<WebElement> messages = getMessageList();
        String lastMessage = messages.get(messages.size() - 1).getText();
        return lastMessage;
    }
    public ChatPage verifySendMessage (String lastMessage,String expectedText)
    {
        assertEquals(lastMessage,expectedText);
        return this;
    }

}
