package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import sun.jvm.hotspot.debugger.cdbg.TemplateType;

import static io.appium.java_client.touch.offset.PointOption.point;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestPage extends BasePage{

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name='TestApp']/XCUIElementTypeWindow[1]/XCUIElementTypeOther")
    public MobileElement pageView;
    @iOSXCUITFindBy(accessibility = "IntegerA")
    public MobileElement textFieldA;
    @iOSXCUITFindBy(accessibility = "IntegerB")
    public MobileElement textFieldB;
    @iOSXCUITFindBy(accessibility = "Compute Sum")
    public MobileElement computeSumButton;
    @iOSXCUITFindBy(accessibility = "Answer")
    public MobileElement answer;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='show alert']")
    public MobileElement showAlertButton;
    @iOSXCUITFindBy(accessibility = "this alert is so cool.")
    public MobileElement alert;
    @iOSXCUITFindBy(accessibility = "OK")
    public MobileElement okButton;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSlider[@name='AppElem']")
    public MobileElement slider;
    @iOSXCUITFindBy(accessibility = "locationStatus")
    public MobileElement location;
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeMap'")
    public MobileElement map;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Test Gesture']")
    public MobileElement testGestureButton;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name='TestApp']/XCUIElementTypeWindow[1]")
    public MobileElement mapPageView;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Check calendar authorized']")
    public MobileElement calendarButton;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Calendar Authorization Status']")
    public MobileElement calendarStatus;
    @iOSXCUITFindBy(accessibility = "Access'ibility")
    public MobileElement text;

    public TestPage(AppiumDriver<MobileElement> driver) {
        super(driver);
        initElements(this);
    }

    @Override
    public void isPageOpened() {
        pageView.isDisplayed();
    }

    public TestPage checkSum(String text) {
        textFieldA.sendKeys(text);
        textFieldB.sendKeys(text);
        computeSumButton.click();
        assertThat("Compute sum should be", answer.getText(), equalTo("4"));
        return this;
    }

    public TestPage checkAlert() {
        showAlertButton.click();
        assertThat("Alert is displayed", waitForElementToAppear(alert), equalTo(true));
        okButton.click();
        return this;
    }

    public TestPage swipeRightScroll() {
        slider.sendKeys("0.22");
        return this;
    }

    public TestPage checkLocation() {
        location.isEnabled();
        return this;
    }

    public TestPage swipeScrollView(double indexStart, double indexY) {
        int height = mapPageView.getSize().getHeight();
        int width = mapPageView.getSize().getWidth();
        int startX = width/2;
        int startY = (int) (height * indexStart);
        int endY = (int) (height * indexY);
        TouchAction action = new TouchAction(driver);
        action.press(point(startX,startY)).moveTo(point(startX, endY)).release().perform();
        return this;
    }

    public TestPage checkTestGesture() {
        testGestureButton.click();
        map.isDisplayed();
        return this;
    }

    public TestPage checkCalendarAuth() {
        calendarButton.click();
        assertThat("Calendar status", waitForElementToAppear(calendarStatus), equalTo(true));
        okButton.click();
        return this;
    }

    public TestPage checkText() {
        assertThat(text.getText(), equalTo("A test label"));
        return this;
    }
}
