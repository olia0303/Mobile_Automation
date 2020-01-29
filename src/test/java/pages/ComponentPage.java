package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import static io.appium.java_client.touch.offset.PointOption.point;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ComponentPage extends BasePage {
    @AndroidFindBy(id = "container1")
    public MobileElement itemViewOne;
    @AndroidFindBy(id = "container2")
    public MobileElement itemViewTwo;
    @AndroidFindBy(id = "container3")
    public MobileElement itemViewThree;
    @AndroidFindBy(id = "slider")
    public MobileElement slider;

    private static final By lIST_VIEW_BY = By.xpath("//android.widget.ScrollView[@content-desc='scrollView']/android.view.ViewGroup");
    private static final By NATIVE_VIEW_BY = By.xpath("//*[@text='Native View']");
    private static final By SLIDER_BY = By.xpath("//*[@text='Slider']");
    private static final By SWIPE_BY = By.xpath("//*[@text='Vertical swiping']");
    
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
    
    public ComponentPage listNativeViewShouldBeLoaded(){
        assertThat("Hello World, I'm View one", waitForElementToAppear(itemViewOne), equalTo(true));
        assertThat("Hello World, I'm View two", waitForElementToAppear(itemViewTwo), equalTo(true));
        assertThat("Hello World, I'm View three", waitForElementToAppear(itemViewThree), equalTo(true));
        return this;
    }
    
    public ComponentPage openSlider() {
        click(SLIDER_BY);
        return this;
    }
    
    public ComponentPage moveSlider() {
        int start = slider.getLocation().getX();
        int y = slider.getLocation().getY();
        int end = slider.getSize().getWidth();
        TouchAction action = new TouchAction(driver);
        int moveTo = (int)(end*0.5);
        action.press(point(start,y)).moveTo(point(moveTo, y)).release().perform();
        return this;
    }
    
    public ComponentPage openVerticalSwiping() {
        click(SWIPE_BY);
        return this;
    }
    
    public ComponentPage verticalSwipe() {
        Dimension dimension = driver.manage().window().getSize();
        int height = dimension.getHeight();
        int width = dimension.getWidth();
        int x = width/2;
        int start = (int)(height*0.80);
        int end = (int)(height*0.20);
        
        return this;
    }
}
