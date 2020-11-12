package PageObjects.Saucedemo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class cartPage
{
    @FindBy(xpath = "//*[@id='cart_contents_container']/div/div[2]/a[1]")
    public WebElement btn_continueShopping;
}
