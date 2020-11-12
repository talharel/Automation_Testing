package Utilities;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class Listeners extends commonOps implements ITestListener
{

    public void onTestStart(ITestResult result)
    {
        System.out.println("------------------- Starting Test: " + result.getName() + " -------------------");
    }


    public void onTestSuccess(ITestResult result)
    {
        System.out.println("------------------- Test: " + result.getName() + " Passed -------------------");
    }


    public void onTestFailure(ITestResult result)
    {
        System.out.println("------------------- Test: " + result.getName() + " Failed -------------------");
        if (!Platform.equalsIgnoreCase("api"))
            makeScreenshotOnFailure();
    }

    public void onTestSkipped(ITestResult result)
    {
        System.out.println("------------------- Skipping Test: " + result.getName() + " Failed -------------------");
    }


    public void onTestFailedButWithinSuccessPercentage(ITestResult result)
    {
        System.out.println("Failure of test cases and its details are : " + result.getName());
    }


    public void onStart(ITestContext context)
    {
        System.out.println("------------------- Starting Execution -------------------");
    }

    public void onFinish(ITestContext context)
    {
        System.out.println("------------------- Ending Execution -------------------");
    }

    @Attachment("Screenshot on failure")
    public byte[] makeScreenshotOnFailure() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
