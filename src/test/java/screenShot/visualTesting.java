package screenShot;
import Utilities.commonOps;
import Utilities.takeElementScreenShotClass;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import WorkFlows.webFlows;
public class visualTesting extends commonOps
{
    @Test
    public static void test01()
    {
        webFlows.login("standard_user","secret_sauce");
//        takeElementScreenShotClass.takeElementScreenShot(driver.findElement(By.cssSelector("div[class='peek']")),"Robot");
        takeElementScreenShotClass.takeElementScreenShot(sauceProducts.img_Robot,"Robot");
    }
}
