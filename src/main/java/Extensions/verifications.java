package Extensions;

import Utilities.commonOps;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class verifications extends commonOps
{
    @Step("Verify text in element")
    public static void assertEquals(WebElement element,String expectedValue)
    {
        if (Platform.equalsIgnoreCase("desktop"))
            Assert.assertEquals(element.getText().replaceAll("Display is","").trim(),expectedValue);
        else
            Assert.assertEquals(element.getText(),expectedValue);
    }

    @Step("Verify Element Visually")
    public static void verifyVisualElement(WebElement imageElement,String imageName)
    {
        BufferedImage expectedImage = null;
        try
        {
            expectedImage = ImageIO.read(new File("./ImageRepository/" + imageName + ".png"));
        }
        catch (Exception e)
        {
            System.out.println("Error reading image file " + e);
        }

        Screenshot imageScreenShot = new AShot().coordsProvider(new WebDriverCoordsProvider()).takeScreenshot(driver,imageElement);
        BufferedImage actualImage = imageScreenShot.getImage();
        imgDiff = new ImageDiffer();
        diff = imgDiff.makeDiff(actualImage,expectedImage);
        Assert.assertFalse(diff.hasDiff(),"Images are not the same."); //diff.hadDiff return true or false,if true there is a difference between the images.
    }

    @Step("Verify text")
    public static void verifyText(String actual,String expected)
    {
        Assert.assertEquals(actual,expected);
    }
}
