package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChatPage extends BasePage {
    public ChatPage(WebDriver driver) {
        super(driver);
    }
    By settingsButtonBy = By.xpath(".//*[@class=\"integri-chat-settings integri-pointer\"]");
    By userNameBy = By.xpath(".//*[@name=\"userName\"]");
    By userEmailBy = By.xpath(".//*[@name=\"userEmail\"]");
    By saveButtonBy = By.xpath("//button[@class='integri-user-settings-save integri-button-blue']");
    By fieldInputTextBy = By.xpath(".//*[@placeholder=\"Start typing here\"]");
    By sendButtonBy = By.xpath(".//*[@title=\"Send message\"]");
    By userChatBy = By.xpath(".//div[@class=\"integri-session-user-name\"]");

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





}
