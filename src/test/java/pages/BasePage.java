package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

abstract public class BasePage {

    WebDriver driver;
    private WebDriverWait wait;
    private static final int TIMEOUT = 20;

    abstract public BasePage openPage();

    abstract public BasePage isPageOpened();

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, TIMEOUT);
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
        driver.findElement(elementBy).sendKeys(text);
    }

    public String readText(By elementBy) {
        waitVisibilityAll(elementBy);
        return driver.findElement(elementBy).getText();
    }

    public void isDisplayedElement(By elementBy) {
        driver.findElement(elementBy).isDisplayed();
    }
}
