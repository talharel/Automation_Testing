package SanityTests;

import Utilities.commonOps;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import WorkFlows.mobileFlows;


@Listeners(Utilities.Listeners.class)
public class apiDemosMobile extends commonOps
{
    @Test(description = "Test01: Check the Clock")
    @Description("Test Description: Navigate to the clock and check his functions")
    public void test01_checkTheClock()
    {
        mobileFlows.checkClockApplication();
    }
}
