package Extensions;
import Utilities.commonOps;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;



public class uiActions extends commonOps
{
    @Step("Click on element")
    public static void click(WebElement element)
    {
        element.click();
    }

    @Step("Send text to text-field")
    public static void updateText(WebElement element,String value)
    {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(value);
    }


    @Step("Update DropDown field")
    public static void updateDropDown(WebElement element,String value)
    {
        wait.until(ExpectedConditions.visibilityOf(element));
        Select select = new Select(element);
        select.selectByValue(value);
    }

    @Step("Scroll down to elemet")
    public static void scrollDown(WebElement element)
    {
        wait.until(ExpectedConditions.visibilityOf(element));
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    @Step("Move to element and click")
    public static void moveToElementAndClick(WebElement element)
    {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        action.moveToElement(element).click().build().perform();
    }

    @Step("Get URL")
    public static void waitForNewUrl()
    {
        driver.getCurrentUrl();
    }
}
