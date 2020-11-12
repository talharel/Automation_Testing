package PageObjects.ApiDemos;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class mainPage
{
    @FindBy(xpath = "//*[@text='Views']")
    public WebElement btn_views;
}
