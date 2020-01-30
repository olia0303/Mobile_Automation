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

    private static final By NATIVE_VIEW_BY = By.xpath("//*[@text='Native View']");
    private static final By NATIVE_PAGE_BY = By.xpath("//*[@text='Native View Demo']");

    public NativeViewPage(AppiumDriver<MobileElement> driver) {
        super(driver);
        initElements(this);
    }

    @Override
    public void isPageOpened() {
        isDisplayedElement(NATIVE_PAGE_BY);
    }

    public NativeViewPage openNativeView() {
        click(NATIVE_VIEW_BY);
        return this;
    }

    public NativeViewPage listNativeViewShouldBeLoaded(){
        assertThat("Hello World, I'm View one", waitForElementToAppear(itemViewOne), equalTo(true));
        assertThat("Hello World, I'm View two", waitForElementToAppear(itemViewTwo), equalTo(true));
        assertThat("Hello World, I'm View three", waitForElementToAppear(itemViewThree), equalTo(true));
        return this;
    }
}
