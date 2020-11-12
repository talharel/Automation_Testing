package Utilities;

import org.openqa.selenium.WebElement;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;

import javax.imageio.ImageIO;
import java.io.File;

public class takeElementScreenShotClass extends commonOps
{
    public takeElementScreenShotClass(WebElement img_robot, String image)
    {
        super();
    }

    public static void takeElementScreenShot(WebElement imageElement, String imageName)
    {
        imageScreenshot = new AShot().coordsProvider(new WebDriverCoordsProvider()).takeScreenshot(driver,imageElement);
        try
        {
            ImageIO.write(imageScreenshot.getImage(),"png",new File(getData("imageRepository")+ imageName + ".png"));
        }
        catch (Exception e)
        {
            System.out.println("Error writing image file,see details: " + e);
        }

    }
}
