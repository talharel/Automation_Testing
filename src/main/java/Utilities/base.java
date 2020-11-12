package Utilities;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class base
{

//    platform name
    public static String Platform;

    //Web
    public static WebDriver driver;
    public static JavascriptExecutor js;
    public static WebDriverWait wait;
    public static Actions action;
    public static Screenshot imageScreenshot;
    public static ImageDiffer imgDiff;
    public static ImageDiff diff;

    //Web PageObjects
    public static PageObjects.Saucedemo.loginPage sauceLogin;
    public static PageObjects.Saucedemo.productPage sauceProducts;
    public static PageObjects.Saucedemo.cartPage sauceCart;


    //Mobile
    public static DesiredCapabilities dc = new DesiredCapabilities();

    //Mobile PageObjects
    public static PageObjects.ApiDemos.mainPage ApiDemos_main;
    public static PageObjects.ApiDemos.viewsPage ApiDemos_views;
    public static PageObjects.ApiDemos.dateWidgetsPage ApiDemos_dateWidgets;
    public static PageObjects.ApiDemos.clockPage ApiDemos_clock;

    //Api
    public static RequestSpecification httpRequest;
    public static Response response;
    public static JSONObject requestParameters = new JSONObject();
    public static JsonPath jp;

    //Electron PageObjects
    public static PageObjects.Electron.mainMenu electron_mainMenu;
    public static PageObjects.Electron.appSystemPage electron_appSystem;

    //Desktop PageObjects
    public static PageObjects.Desktop.mainPage deskTop_calcMain;

    //DB
    public static ResultSet rs;
    public static Connection con;
    public static Statement stmt;

}
