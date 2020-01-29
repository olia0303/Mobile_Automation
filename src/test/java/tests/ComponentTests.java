package tests;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
public class ComponentTests extends BaseTest {

    @Test
    @Description("Check Native view")
    public void nativeViewTest() {
        loginPage.logInAsRegisteredUser();
        componentPage.isPageOpened();
        componentPage.openNativeView()
                     .listNativeViewShouldBeLoaded();
    }

    @Test
    @Description("Slide your number")
    public void sliderTest() {
        loginPage.logInAsRegisteredUser();
        componentPage.isPageOpened();
        componentPage.openSlider()
                .moveSlider();
    }
    @Test
    @Description("Vertical Swiping")
    public void swipeTest() {
        loginPage.logInAsRegisteredUser();
        componentPage.isPageOpened();
        componentPage.openVerticalSwiping();
    }
}
