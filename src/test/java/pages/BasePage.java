package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@Log4j2
abstract public class BasePage {

    AppiumDriver<MobileElement> driver;
    
    private WebDriverWait wait;
    private static final int TIMEOUT = 30;
    private static final int POLLING = 100;


    abstract protected void isPageOpened();

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

    boolean scrollToElement(By locatorForScrollableElement, By elementToBeDisplayed){
        boolean isElementFound = false;
        MobileElement scrollingElement = driver.findElement(locatorForScrollableElement);
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        try {
            int scrollRetryCount = 20;
            while (scrollRetryCount > 0) {
                if (driver.findElements(elementToBeDisplayed).size() > 0) {
                    isElementFound = true;
                    break;
                }
                TouchAction action = new TouchAction(driver);
                int scrollingToStartFromX = scrollingElement.getLocation().getX() + scrollingElement.getSize().width/2;
                int scrollingToStartFromY = scrollingElement.getLocation().getY() + scrollingElement.getSize().height - 20;
                int scrollingToStartToX = scrollingElement.getLocation().getX() + scrollingElement.getSize().width/2;
                int scrollingToStartToY = scrollingElement.getLocation().getY() + 20;
                action.longPress(PointOption.point(scrollingToStartFromX,scrollingToStartFromY))
                        .moveTo(PointOption.point(scrollingToStartToX,scrollingToStartToY))
                        .release()
                        .perform();
                scrollRetryCount--;
            }
            return isElementFound;
        }catch (Exception ex){
            return false;
        }finally {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
    }
    
    public void waitVisibilityAll(By elementBy) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
    }

    public void waitInVisibility(By elementBy) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(elementBy));
    }

    public void click(By elementBy) {
        waitVisibilityAll(elementBy);
        driver.findElement(elementBy).click();
    }

    public void isDisplayedElement(By elementBy) {
        driver.findElement(elementBy).isDisplayed();
    }

    public void isDisplayedElement(MobileElement element) {
        driver.findElementById(element.getId()).isDisplayed();
    }
}
