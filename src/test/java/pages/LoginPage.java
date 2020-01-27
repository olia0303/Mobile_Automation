package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class LoginPage extends BasePage{

    private static final By LOGIN_BUTTON_BY = By.xpath("//*[@text='LOG IN']");
    private static final By LOGIN_ICON_BY = By.className("android.widget.ImageView");
    
    public LoginPage(AppiumDriver<MobileElement> driver) {
        super(driver);
        initElements(this);
    }
    
    @Override
    public LoginPage isPageOpened() {
        isDisplayedElement(LOGIN_ICON_BY);
        return this;
    }

    public LoginPage logInAsRegisteredUser() {
        click(LOGIN_BUTTON_BY);
        return this;
    }
}
