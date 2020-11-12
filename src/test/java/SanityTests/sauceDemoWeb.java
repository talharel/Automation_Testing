package SanityTests;

import Extensions.verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import WorkFlows.webFlows;
import Utilities.commonOps;


@Listeners(Utilities.Listeners.class)
public class sauceDemoWeb extends commonOps
{
    @Test(description = "Test01: Login to sauceDemo")
    @Description("Test Description: login to sauceDemp Web")
    public void test01()
    {
        webFlows.login("standard_user","secret_sauce");
        verifications.assertEquals(sauceProducts.productTitle,"Products");
    }

    @Test(description = "Test02: Add one product")
    @Description("Test Description: Add to cart one product and verifies number of products in the cart (1)")
    public void test02()
    {
        webFlows.addToCart("lohi");
        verifications.assertEquals(sauceProducts.QuantityOfProducts,"1");
    }

    @Test(description = "Test03: Add all products")
    @Description("Test Description: Add all products to the cart and verifies number of products in the cart (6)")
    public void test03()
    {
        webFlows.addAll_MoveToCart_return();
        verifications.assertEquals(sauceProducts.QuantityOfProducts,"6");
    }

    @Test(description = "Test04: Verify product's page robot")
    @Description("Test Description: Verify product's page robot ")
    public void test04()
    {
        verifications.verifyVisualElement(sauceProducts.img_Robot,"Robot");
    }

    @Test(description = "Test04: Navigate to LabsPage")
    @Description("Test Description: Navigate to LabsPage and verify it")
    public void test05()
    {
        webFlows.navigateToLabsPage();
        verifications.verifyText(driver.getCurrentUrl(),"https://saucelabs.com/");
    }
}
