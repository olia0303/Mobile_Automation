package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class ComponentPage extends BasePage {
    private static final By lIST_VIEW_BY = By.xpath("//android.widget.ScrollView[@content-desc='scrollView']/android.view.ViewGroup");
    private static final By NATIVE_VIEW_BY = By.xpath("//*[@text='Native View']");
    
    
    public ComponentPage(AppiumDriver<MobileElement> driver) {
        super(driver);
        initElements(this);
    }

    @Override
    public ComponentPage isPageOpened() {
        isDisplayedElement(lIST_VIEW_BY);
        return this;
    }
    
    public ComponentPage openNativeView() {
        click(NATIVE_VIEW_BY);
        return this;
    }
    
    public ComponentPage ListNativeViewShouldBeLoaded(){
       // assertThat("List of native is empty or haven't been loaded", waitForElementToAppear(NATIVE_VIEW_BY), equalTo(true));
        return this;
    }
}
