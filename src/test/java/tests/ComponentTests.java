package tests;

import io.qameta.allure.Description;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
public class ComponentTests extends BaseTest {
   
    @Parameters(value={"deviceName", "platform"})
    @BeforeClass
    public void setupDeviceParameters (@Optional("iPhone 8") String deviceName, @Optional("iOS") String platform) {
        setCustomCapabilities(deviceName, platform);
    }

    @Test
    @Description("Write text")
    public void writeTextTest() {
        testPage.isPageOpened();
        testPage.checkSum("2");
    }

    @Test
    @Description("Show alert")
    public void showAlertTest() {
        testPage.isPageOpened();
        testPage.checkAlert();
    }

    @Test
    @Description("Slider")
    public void sliderTest() {
        testPage.isPageOpened();
        testPage.swipeRightScroll();
    }

    @Test
    @Description("Disabled button")
    public void disabledButtonTest() {
        testPage.isPageOpened();
        testPage.checkLocation();
    }

    @Test
    @Description("Test Gesture")
    public void gestureTest() {
        testPage.isPageOpened();
        double indexStart = 0.5;
        double indexY = 0.2;
        testPage.checkTestGesture()
                .swipeScrollView(indexStart, indexY);
    }

    @Test
    @Description("Check Calendar")
    public void checkCalendarAuthorizedTest() {
        testPage.isPageOpened();
        testPage.checkCalendarAuth();
    }

    @Test
    @Description("Check text")
    public void checkTextTest() {
        testPage.isPageOpened();
        testPage.checkText();
    }
}
