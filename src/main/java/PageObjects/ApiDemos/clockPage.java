package PageObjects.ApiDemos;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class clockPage
{
    @FindBy(xpath = "//*[@contentDescription='12']")
    public WebElement hourNumber_12;

    @FindBy(xpath = "//*[@contentDescription='9']")
    public WebElement hourNumber_9;

    @FindBy(xpath = "//*[@contentDescription='15']")
    public WebElement minuteNumber_15;

    @FindBy(xpath = "//*[@contentDescription='45']")
    public WebElement minuteNumber_45;

    @FindBy(id = "hours")
    public WebElement hour;

    @FindBy(id = "separator")
    public WebElement colon;

    @FindBy(id = "minutes")
    public WebElement minutes;

}
