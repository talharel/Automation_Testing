package PageObjects.Saucedemo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class productPage
{
    @FindBy(xpath = "//*[@id='inventory_filter_container']/div")
    public WebElement productTitle;

    @FindBy(xpath = "//*[@id='inventory_container']/div/div[4]/div[3]/button")
    public WebElement product5;

    @FindBy(xpath = "//*[@id='inventory_filter_container']/select")
    public WebElement btn_sort;

    @FindBy(xpath = "//*[@id='shopping_cart_container']/a/span")
    public WebElement QuantityOfProducts;

    @FindBy(xpath = "//*[@id='menu_button_container']/div/div[3]/div/button")
    public WebElement btn_menu;

    @FindBy(id = "about_sidebar_link")
    public WebElement btn_menuAbout;

    @FindBy(xpath = "//*[@id='inventory_container']/div/div/div[3]/button")
    public List <WebElement> allProducts;

    @FindBy(css = "a[href='./cart.html']")
    public WebElement btn_toCart;

    @FindBy(css = "div[class='peek']")
    public WebElement img_Robot;

}
