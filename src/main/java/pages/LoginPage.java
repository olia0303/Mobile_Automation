package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    By emailBy = By.xpath(".//*[@name=\"email\"]");
    By passwordBy = By.xpath(".//*[@name=\"password\"]");
    By loginButtonBy = By.className("btn");
    By logoutButtonBy = By.xpath(".//a[@href=\"/logout\"]");
    By forgotPasswordLinkBy = By.className("forgot");
    By recoveryButtonBy = By.xpath("//*[@class=\"btn btn-primary\"]");
    By messageWithInstructionsBy = By.xpath("//span[@data-notify='message']");

    public LoginPage loginToUser (String username, String password){
        writeText(emailBy,username);
        writeText(passwordBy, password);
        click(loginButtonBy);
        click(logoutButtonBy);
        return this;
    }

     public LoginPage forgotPassword(String username){
         writeText(emailBy,username);
         click(forgotPasswordLinkBy);
         writeText(emailBy,username);
         click(recoveryButtonBy);
         return this;
     }
    public LoginPage verifyPassword(String expectedText) {
        assertEquals(messageWithInstructionsBy, expectedText);
        return this;
    }
}
