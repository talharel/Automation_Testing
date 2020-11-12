package SanityTests;

import Utilities.commonOps;
import WorkFlows.apiFlows;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Extensions.verifications;

@Listeners(Utilities.Listeners.class)
public class grafanaApi extends commonOps
{
   @Test(description = "Test01: Get team from Grafana")
   @Description("Test Description: Login to Grafana and Get Team")
    public static void test01_getTeam()
   {
       verifications.verifyText(apiFlows.getTeamProperty("teams[0].name"),"blueTeam");
   }

   @Test(description = "Test 02: Add team and verify")
   @Description("Add team to Grafana and verify it")
    public static void test02_addTeamAndVerify()
   {
        apiFlows.postTeam("redTeam","redTeam@redteam.com");
        verifications.verifyText(apiFlows.getTeamProperty("teams[1].name"),"redTeam");
   }


    @Test(description = "Test 03: update Team and verify ")
    @Description("Update team to Grafana and verify it")
    public static void test03_update()
    {
        String id = apiFlows.getTeamProperty("teams[1].id"); //הוספתי את המשתנה לכאן כי בלעדיו אני צריך לעדכן את הid כי הוא קופץ באחד
        apiFlows.updateTeam("purpleTeam","purpleTeam@purpleteam.com",id);
        verifications.verifyText(apiFlows.getTeamProperty("teams[1].name"),"purpleTeam");
    }

    @Test(description = "Test 04: Delete Team and verify")
    @Description("Delete team from Grafana and verify it")
    public static void test04_update()
    {
        String id = apiFlows.getTeamProperty("teams[1].id"); // כנל
        apiFlows.deleteTeam(id);
        verifications.verifyText(apiFlows.getTeamProperty("totalCount"),"1");
    }
}
