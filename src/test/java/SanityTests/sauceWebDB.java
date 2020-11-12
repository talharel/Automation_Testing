package SanityTests;

import Extensions.dbActions;
import Extensions.uiActions;
import Extensions.verifications;
import Utilities.commonOps;
import WorkFlows.webFlows;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.testng.annotations.Test;

public class sauceWebDB extends commonOps
{
    @Test(description = "Test01: Login to sauceDemo with DB")
    @Description("Test Description: login to sauceDemo Web with DB")
    public void test01_DB()
    {
        webFlows.loginDB();
        verifications.assertEquals(sauceProducts.productTitle,"Products");
    }
}
