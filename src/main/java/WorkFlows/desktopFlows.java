package WorkFlows;

import Utilities.commonOps;
import Extensions.uiActions;
import io.qameta.allure.Step;

public class desktopFlows extends commonOps
{
    @Step("Calculate multiplication")
    public static void calculateMultiplication ()
    {
        uiActions.click(deskTop_calcMain.btn_eight);
        uiActions.click(deskTop_calcMain.btn_Multiplication);
        uiActions.click(deskTop_calcMain.btn_six);
        uiActions.click(deskTop_calcMain.btn_equal);
    }
}
