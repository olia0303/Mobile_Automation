package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LoginPage extends BasePage{
    @AndroidFindBy(xpath = "//*[@text='LOG IN']")
    public MobileElement loginButton;
    @AndroidFindBy(className = "android.widget.ImageView")
    public MobileElement loginIcon;
    @AndroidFindBy(xpath = "//*[@text='LOG IN']")
    public MobileElement listView;
    
    public LoginPage(AppiumDriver<MobileElement> driver) {
        super(driver);
        initElements(this);
    }
    
   @Override
    public void isPageOpened() {
       loginIcon.isDisplayed();
    }

    public LoginPage logInAsRegisteredUser() {
        loginButton.click();
        return this;
    }
    
    public LoginPage isListViewOpened() {
        listView.isDisplayed();
        return this;
    }
}
