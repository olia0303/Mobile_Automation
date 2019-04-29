package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import module.DataUser;
import java.util.List;



public class BasePage {
    WebDriver driver;
    private WebDriverWait wait;
    private static final int TIMEOUT = 10;

    public BasePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver,TIMEOUT);
    }
    public void waitVisibilityAll(By elementBy){
         wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
    }
    public void clear(By elementBy){
        waitVisibilityAll(elementBy);
        driver.findElement(elementBy).clear();
    }
    public void click(By elementBy){
        waitVisibilityAll(elementBy);
        driver.findElement(elementBy).click();
    }
    public void writeText (By elementBy, String text) {
        waitVisibilityAll(elementBy);
        driver.findElement(elementBy).sendKeys(text);
    }

    public String readText (By elementBy) {
        waitVisibilityAll(elementBy);
        return driver.findElement(elementBy).getText();

    }

    public void assertTrue (By elementBy){
        waitVisibilityAll(elementBy);
        Assert.assertTrue(true);
    }
    public void assertEquals (By elementBy, String expectedText) {
        waitVisibilityAll(elementBy);
        Assert.assertEquals(readText(elementBy), expectedText);

    }
    public void assertEquals (String actualText,String expectedText) {
        Assert.assertEquals(actualText, expectedText);

    }
}