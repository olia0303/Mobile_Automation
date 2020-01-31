package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;

import static io.appium.java_client.touch.offset.PointOption.point;

public class VerticalSwipingPage extends BasePage {
    @AndroidFindBy(id = "listview")
    public MobileElement listView;
    
    private static final By SWIPE_BY = By.xpath("//*[@text='Vertical swiping']");
    
    public VerticalSwipingPage(AppiumDriver<MobileElement> driver) {
        super(driver);
        initElements(this);
    }

    @Override
    public void isPageOpened() {
       isDisplayedElement(SWIPE_BY);
    }

    public VerticalSwipingPage openVerticalSwiping() {
        click(SWIPE_BY);
        return this;
    }
    
    public VerticalSwipingPage swipeScrollView(double indexStart, double indexY) {
        int height = listView.getSize().getHeight();
        int width = listView.getSize().getWidth();
        int startX = width/2;
        int startY = (int) (height * indexStart);
        int endY = (int) (height * indexY);
        TouchAction action = new TouchAction(driver);
        action.press(point(startX,startY)).moveTo(point(startX, endY)).release().perform();
        return this;
    }
}
