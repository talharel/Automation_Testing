package WorkFlows;

import Extensions.dbActions;
import Extensions.uiActions;
import Utilities.commonOps;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;


public class webFlows extends commonOps
{

    @Step("Login to sauceDemoWeb")
    public static void login(String userName,String password)
    {

        uiActions.updateText(sauceLogin.userNameField,userName);
        uiActions.updateText(sauceLogin.passwordField,password);
        uiActions.click(sauceLogin.btn_login);
    }


    @Step("Login to sauceDemoWeb with DB credentials")
    public static void loginDB()
    {
        List <String> list = dbActions.getDataFromDB("SELECT name,password FROM Test WHERE id='10'");
        uiActions.updateText(sauceLogin.userNameField,list.get(0));
        uiActions.updateText(sauceLogin.passwordField,list.get(1));
        uiActions.click(sauceLogin.btn_login);
    }

    @Step("Add one product")
    public static void addToCart(String sortValue)
    {
        uiActions.updateDropDown(sauceProducts.btn_sort,sortValue);
        uiActions.scrollDown(sauceProducts.product5);
        uiActions.click(sauceProducts.product5);
    }

    @Step("Add all the products")
    public static void addAll_MoveToCart_return()
    {
        uiActions.click(sauceProducts.product5);
        addAllProducts(sauceProducts.allProducts);
        uiActions.click(sauceProducts.btn_toCart);
        uiActions.scrollDown(sauceCart.btn_continueShopping);
        uiActions.click(sauceCart.btn_continueShopping);
    }
    public static void addAllProducts(List<WebElement> list)
    {
        for (int i = 0;i<=list.size()-1;i++)
        {
            uiActions.moveToElementAndClick(list.get(i));
        }
    }

    @Step("Navigate to LabsPage")
    public static void navigateToLabsPage()
    {
        uiActions.click(sauceProducts.btn_menu);
        uiActions.click(sauceProducts.btn_menuAbout);
    }
}

