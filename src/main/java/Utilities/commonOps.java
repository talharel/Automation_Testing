package Utilities;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.windows.WindowsDriver;
import io.restassured.RestAssured;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.w3c.dom.Document;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class commonOps extends base
{

    @BeforeClass
    @Parameters({"PlatformName"})
    public void startSession(String PlatformName)
    {
        Platform = PlatformName;

        if (Platform.equalsIgnoreCase("web"))
            initBrowser(getData("BrowserName"));

        else if (Platform.equalsIgnoreCase("mobile"))
            initMobile();

        else if (Platform.equalsIgnoreCase("api"))
            initApi();

        else if (Platform.equalsIgnoreCase("electron"))
            initElectron();

        else if(Platform.equalsIgnoreCase("desktop"))
            initDesktop();

        else
            throw new RuntimeException("Invalid platform name stated");

        managePages.init();
        manageDB.initConnection(getData("DB_Url"),getData("DB_UserName"),getData("DB_PassWord"));

    }

    @AfterClass
    public void closeSession()
    {
        manageDB.closeConnection();
        if (!Platform.equalsIgnoreCase("api"))
            driver.quit();
    }



    //----WebFunctions----

    public static void initBrowser(String browserType)
    {
        if (browserType.equalsIgnoreCase("chrome"))
            driver = initChromeDriver();

        else if (browserType.equalsIgnoreCase("firefox"))
            driver = initFireFoxDriver();

        else if (browserType.equalsIgnoreCase("edge"))
            driver = initEdgeDriver();

        else
            throw new RuntimeException("Invalid browserType name");

        driver.manage().window().maximize();
        driver.get(getData("Url_Web"));
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("TimeOut")), TimeUnit.SECONDS);

        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver,Long.parseLong(getData("TimeOut")));
        action = new Actions(driver);
    }

    public static WebDriver initChromeDriver()
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        return driver;
    }

    public static WebDriver initFireFoxDriver()
    {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        return driver;
    }

    public static WebDriver initEdgeDriver()
    {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        return driver;
    }


    //----Mobile----

    public static void initMobile()
    {
        dc.setCapability(MobileCapabilityType.UDID, getData("UDID"));
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, getData("APP_PACKAGE"));
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, getData("APP_ACTIVITY"));
        try
        {
            driver = new RemoteWebDriver(new URL(getData("appiumServer") + "/wd/hub"), dc);
        }
        catch (Exception e)
        {
            System.out.println("Can not connect to Appium server, see details " + e);
        }


       driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("TimeOut")),TimeUnit.SECONDS);
    }

    //----Api----

    public static void initApi()
    {
        RestAssured.baseURI = getData("urlApi");
        httpRequest = RestAssured.given().auth().preemptive().basic(getData("userNameApi"),getData("passwordApi"));
    }


    //----Electron----
    public static void initElectron()
    {
        System.setProperty("webdriver.chrome.driver",getData("electronDriverPath"));
        ChromeOptions opt = new ChromeOptions();
        opt.setBinary(getData("electronAppPath"));
        dc.setCapability("chromeOptions", opt);
        dc.setBrowserName("chrome");
        driver = new ChromeDriver(dc);
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("TimeOut")),TimeUnit.SECONDS);
    }

    //----Desktop----
    public static void initDesktop()
    {
        dc.setCapability("app", getData("calculatorApp"));
        try
        {
            driver = new WindowsDriver(new URL(getData("appiumServer")), dc);
        } catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    //----XML----

    public static String getData (String nodeName)
    {
        DocumentBuilder dBuilder;
        Document doc = null;
        File fXmlFile = new File("./Configuration/dataConfig.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fXmlFile);
        }
        catch(Exception e) {
            System.out.println("Exception in reading XML file: " + e);
        }
        doc.getDocumentElement().normalize();
            return doc.getElementsByTagName(nodeName).item(0).getTextContent();
    }
}
