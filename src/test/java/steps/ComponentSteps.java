package steps;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import pages.ComponentPage;
import pages.LoginPage;

@Log4j2
public class ComponentSteps {
    private ComponentPage componentPage;
    private LoginPage loginPage;

    public ComponentSteps(AppiumDriver driver) {
        loginPage = new LoginPage(driver);
        componentPage = new ComponentPage(driver);
    }

    @Step("Log IN")
    public ComponentSteps logIn() {
        loginPage.isPageOpened();
        loginPage.logInAsRegisteredUser();
        componentPage.isPageOpened();
        return this;
    }

    @Step("Open Native View Page")
    public ComponentSteps openNativeView() {
        componentPage.openNativeView()
                .listNativeViewShouldBeLoaded();
        return this;
    }
}