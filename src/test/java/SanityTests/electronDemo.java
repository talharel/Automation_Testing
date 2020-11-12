package SanityTests;

import Utilities.commonOps;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import WorkFlows.electronFlows;
import Extensions.verifications;


@Listeners(Utilities.Listeners.class)
public class electronDemo extends commonOps
{

    @Test(description = "Test01: Get the app's location")
    @Description("Test Description: Get app's location and verify it")
    public void test01_appLocation() throws InterruptedException
    {
        electronFlows.getAppLocation();
        verifications.assertEquals(electron_appSystem.appInfo,"This app is located at: C:\\Automation\\electronApp\\ElectronAPIDemos-win32-ia32\\resources\\app");
    }
}
