package WorkFlows;

import Utilities.commonOps;
import io.qameta.allure.Step;
import Extensions.uiActions;

public class mobileFlows extends commonOps
{
    @Step("Enter to the clock application and check it")
    public static void checkClockApplication()
    {
        uiActions.click(ApiDemos_main.btn_views);
        uiActions.click(ApiDemos_views.btn_DateWidgets);
        uiActions.click(ApiDemos_dateWidgets.btn_inLine);
        uiActions.click(ApiDemos_clock.hourNumber_9);
        uiActions.click(ApiDemos_clock.minuteNumber_45);
    }
}
