package Utilities;

import org.openqa.selenium.support.PageFactory;

public class managePages extends base
{
    public static void init()
    {
        // Web
        sauceLogin = PageFactory.initElements(driver,PageObjects.Saucedemo.loginPage.class);
        sauceProducts = PageFactory.initElements(driver,PageObjects.Saucedemo.productPage.class);
        sauceCart = PageFactory.initElements(driver,PageObjects.Saucedemo.cartPage.class);



        //Mobile
        ApiDemos_main = PageFactory.initElements(driver,PageObjects.ApiDemos.mainPage.class);
        ApiDemos_views = PageFactory.initElements(driver,PageObjects.ApiDemos.viewsPage.class);
        ApiDemos_dateWidgets = PageFactory.initElements(driver,PageObjects.ApiDemos.dateWidgetsPage.class);
        ApiDemos_clock = PageFactory.initElements(driver,PageObjects.ApiDemos.clockPage.class);

        //Electron
        electron_mainMenu = PageFactory.initElements(driver,PageObjects.Electron.mainMenu.class);
        electron_appSystem = PageFactory.initElements(driver,PageObjects.Electron.appSystemPage.class);

        //Desktop
        deskTop_calcMain = PageFactory.initElements(driver,PageObjects.Desktop.mainPage.class);
    }
}
