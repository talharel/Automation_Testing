package SanityTests;

import WorkFlows.desktopFlows;
import Utilities.commonOps;
import Extensions.verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Utilities.Listeners.class)
public class calculatorDeskTop extends commonOps
{

    @Test(description = "Test01: Verify multiplication command")
    @Description("Test01 Description: Verify multiplication command in calculator")
    public static void test01_multiplication()
    {
        desktopFlows.calculateMultiplication();
        verifications.assertEquals(deskTop_calcMain.field_result,"48");
    }
}
