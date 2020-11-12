package PageObjects.ApiDemos;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class viewsPage
{
    @FindBy(xpath = "//*[@text='Date Widgets']")
    public WebElement btn_DateWidgets;
}
