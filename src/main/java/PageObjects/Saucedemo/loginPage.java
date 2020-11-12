package PageObjects.Saucedemo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPage
{
    @FindBy(id = "user-name")
    public WebElement userNameField;

    @FindBy(id = "password")
    public WebElement passwordField;

    @FindBy(id = "login-button")
    public WebElement btn_login;
}
