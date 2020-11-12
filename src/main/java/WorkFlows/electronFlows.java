package WorkFlows;

import Utilities.commonOps;
import Extensions.uiActions;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.ExecutionException;

public class electronFlows extends commonOps
{
    @Step("Get app's location")
    public static void getAppLocation()
    {
        uiActions.click(electron_mainMenu.btn_appInformation);
        uiActions.click(electron_appSystem.btn_viewDemo);
    }
}
