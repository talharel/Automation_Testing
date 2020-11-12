package PageObjects.Electron;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class appSystemPage
{
    @FindBy(id = "app-info")
    public WebElement btn_viewDemo;

    @FindBy(id = "got-app-info")
    public WebElement appInfo;
}
