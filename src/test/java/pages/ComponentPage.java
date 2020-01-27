package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ComponentPage extends BasePage {
    @AndroidFindBy(id = "container1")
    private MobileElement itemViewOne;
    @AndroidFindBy(id = "container2")
    private MobileElement itemViewTwo;
    @AndroidFindBy(id = "container3")
    private MobileElement itemViewThree;

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

    public ComponentPage listNativeViewShouldBeLoaded(){
        assertThat("Hello World, I'm View one", waitForElementToAppear(itemViewOne), equalTo(true));
        assertThat("Hello World, I'm View two", waitForElementToAppear(itemViewTwo), equalTo(true));
        assertThat("Hello World, I'm View three", waitForElementToAppear(itemViewThree), equalTo(true));
        return this;
    }
}
