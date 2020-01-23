package tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class AndroidTest extends BaseTest {
    @Test
    public void newTest() {
        
        WebElement three = driver.findElementById("com.android.calculator2:id/digit_3");
        three.click();

        driver.findElementByAccessibilityId("plus").click();

        WebElement two = driver.findElementById("com.android.calculator2:id/digit_2");
        two.click();

        driver.findElementByXPath("//android.widget.Button[@content-desc='equals']").click();

        String result = driver.findElementById("com.android.calculator2:id/result").getText();
        String expectedText = "5";
        assertThat(result, equalTo(expectedText));
    }
}
