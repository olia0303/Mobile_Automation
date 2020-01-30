package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.touch.TouchActions;

public class DoubleTapPage extends BasePage {
    private static final By DOUBLE_TAP_BY = By.xpath("//*[@text='Double Tap']");
    private static final By DOUBLE_TAP_DEMO_BY = By.xpath("//*[@text='Double Tap Demo']");
    private static final By DOUBLE_TAB_BUTTON_XPATH = By.xpath("//*[@text='Double Tap Me']");
            
    public DoubleTapPage(AppiumDriver<MobileElement> driver) {
        super(driver);
        initElements(this);
    }

    public DoubleTapPage openDoubleTap() {
        click(DOUBLE_TAP_BY);
        return this;
    }
    
    @Override
    public void isPageOpened() {
       isDisplayedElement(DOUBLE_TAP_DEMO_BY); 
    }
    
    public DoubleTapPage doubleTapAction() {
        MobileElement element = driver.findElement(DOUBLE_TAB_BUTTON_XPATH);
        TouchActions action = new TouchActions(driver);
        action.doubleTap(element);
        action.perform();
        return this;
    }
}
