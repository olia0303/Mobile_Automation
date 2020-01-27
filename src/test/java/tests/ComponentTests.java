package tests;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
public class ComponentTests extends BaseTest {

    @Test
    @Description("Log IN")
    public void userLogInTest() {
        steps.logIn()
                .openNativeView();
    }
}
