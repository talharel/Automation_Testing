package PageObjects.Desktop;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class mainPage
{
    @FindBy(name = "Eight")
    public WebElement btn_eight;

    @FindBy(name = "Six")
    public WebElement btn_six;

    @FindBy(name = "Multiply by")
    public WebElement btn_Multiplication;

    @FindBy(name = "Equals")
    public WebElement btn_equal;

    @FindBy(xpath = "//*[@AutomationId='CalculatorResults']")
    public WebElement field_result;
}
