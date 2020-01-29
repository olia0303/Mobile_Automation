package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Log4j2
abstract public class BasePage {

    AppiumDriver<MobileElement> driver;
    
    private WebDriverWait wait;
    private static final int TIMEOUT = 30;
    private static final int POLLING = 100;
    

    abstract public BasePage isPageOpened();

    public BasePage(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, TIMEOUT, POLLING);
    }

    void initElements(BasePage page){
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), page);
    }

    boolean waitForElementToAppear(MobileElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        }catch (TimeoutException ex){
            return false;
        }
    }

    boolean waitForElementToDissapear(MobileElement element){
        try {
            wait.until(ExpectedConditions.invisibilityOf(element));
            return true;
        }catch (TimeoutException ex){
            return false;
        }
    }

    public void waitVisibilityAll(By elementBy) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
    }

    public void waitInVisibility(By elementBy) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(elementBy));
    }

    public void clear(By elementBy) {
        waitVisibilityAll(elementBy);
        driver.findElement(elementBy).clear();
    }

    public void click(By elementBy) {
        waitVisibilityAll(elementBy);
        driver.findElement(elementBy).click();
    }

    public void writeText(By elementBy, String text) {
        waitVisibilityAll(elementBy);
        log.info("Write text: "  + text);
        driver.findElement(elementBy).sendKeys(text);
    }

    public String readText(By elementBy) {
        waitVisibilityAll(elementBy);
        log.info("Get message: "  + elementBy );
        return driver.findElement(elementBy).getText();
    }

    public void isDisplayedElement(By elementBy) {
        driver.findElement(elementBy).isDisplayed();
    }
}
