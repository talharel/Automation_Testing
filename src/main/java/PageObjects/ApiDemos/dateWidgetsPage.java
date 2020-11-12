package PageObjects.ApiDemos;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class dateWidgetsPage
{
    @FindBy(xpath = "//*[@text='2. Inline']")
    public WebElement btn_inLine;
}
