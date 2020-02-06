package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class LoginPage extends BasePage{

    private static final String LOGIN_BUTTON_BY = "//*[@text='LOG IN']";
    private static final String LOGIN_ICON_BY = "android.widget.ImageView";
    private static final String lIST_VIEW_BY = "//android.widget.ScrollView[@content-desc='scrollView']/android.view.ViewGroup";
    
    public LoginPage(AppiumDriver<MobileElement> driver) {
        super(driver);
        initElements(this);
    }
    
   @Override
    public void isPageOpened() {
        driver.findElement(new By.ByClassName(LOGIN_ICON_BY)).isDisplayed();
    }

    public LoginPage logInAsRegisteredUser() {
        driver.findElement(By.xpath(LOGIN_BUTTON_BY)).click();
        return this;
    }
    
    public LoginPage isListViewOpened() {
        driver.findElement(By.xpath(lIST_VIEW_BY)).isDisplayed();
        return this;
    }
}
