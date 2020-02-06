package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class NativeViewPage extends BasePage {
    @AndroidFindBy(id = "container1")
    public MobileElement itemViewOne;
    @AndroidFindBy(id = "container2")
    public MobileElement itemViewTwo;
    @AndroidFindBy(id = "container3")
    public MobileElement itemViewThree;

    private static final String NATIVE_VIEW_BY = "//*[@text='Native View']";
    private static final String NATIVE_PAGE_BY = "//*[@text='Native View Demo']";

    public NativeViewPage(AppiumDriver<MobileElement> driver) {
        super(driver);
        initElements(this);
    }

    @Override
    public void isPageOpened() {
        driver.findElement(By.xpath(NATIVE_PAGE_BY)).isDisplayed();
    }

    public NativeViewPage openNativeView() {
        driver.findElement(By.xpath(NATIVE_VIEW_BY)).click();
        return this;
    }

    public NativeViewPage listNativeViewShouldBeLoaded(){
        assertThat("Hello World, I'm View one", waitForElementToAppear(itemViewOne), equalTo(true));
        assertThat("Hello World, I'm View two", waitForElementToAppear(itemViewTwo), equalTo(true));
        assertThat("Hello World, I'm View three", waitForElementToAppear(itemViewThree), equalTo(true));
        return this;
    }
}
