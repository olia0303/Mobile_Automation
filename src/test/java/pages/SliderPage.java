package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;

import static io.appium.java_client.touch.offset.PointOption.point;

public class SliderPage extends BasePage {
    @AndroidFindBy(id = "slider")
    public MobileElement slider;
    
    private static final String SLIDER_BY = "//*[@text='Slider']";
    
    public SliderPage(AppiumDriver<MobileElement> driver) {
        super(driver);
        initElements(this);
    }

    @Override
    public void isPageOpened() {
        isDisplayedElement(slider);
    }

    public SliderPage openSlider() {
        driver.findElement(By.xpath(SLIDER_BY)).click();
        return this;
    }

    public SliderPage moveSlider(double index) {
        int start = slider.getLocation().getX();
        int y = slider.getLocation().getY();
        int end = slider.getSize().getWidth();
        TouchAction action = new TouchAction(driver);
        int moveTo = (int)(end*index);
        action.press(point(start,y)).moveTo(point(moveTo, y)).release().perform();
        return this;
    }
}
