package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.interactions.touch.TouchActions;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class DragDropPage extends BasePage {
    @AndroidFindBy(accessibility = "success")
    public MobileElement message;
    @AndroidFindBy(xpath = "//*[@text='Drag & Drop']")
    public MobileElement dragDrop;
    @AndroidFindBy(xpath = "//*[@text='Drag me!']")
    public MobileElement dragMeButton;
    
    public DragDropPage(AppiumDriver<MobileElement> driver) {
        super(driver);
        initElements(this);
    }

    @Override
    public void isPageOpened() {
        dragMeButton.isDisplayed();
    }

    public DragDropPage openDragDrop() {
        dragDrop.click();
        return this;
    }
    
    public DragDropPage dragDropAction() {
        TouchActions action = new TouchActions(driver);
        action.longPress(dragDrop)
                .moveToElement(dragMeButton)
                .release()
                .perform();
        
        return this;
    }
    
    public DragDropPage checkSuccessMessage() {
        assertThat("Circle dropped", waitForElementToAppear(message), equalTo(true));
        return this;
    }
}
