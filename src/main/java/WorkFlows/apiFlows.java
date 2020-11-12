package WorkFlows;

import Utilities.commonOps;
import Extensions.apiActions;
import io.qameta.allure.Step;
import io.restassured.response.Response;

public class apiFlows extends commonOps
{
    @Step("Get team from Grafana")
    public static String getTeamProperty(String path)
    {
        Response response = apiActions.get("/api/teams/search");
            return apiActions.extractFromJson(response,path);
    }

    @Step("Create new team in Grafana")
    public static void postTeam(String name, String email)
    {
        requestParameters.put("name",name);
        requestParameters.put("email",email);

        apiActions.post(requestParameters,"/api/teams");
    }

    @Step("Update team in Grafana")
    public static void updateTeam(String name,String email,String id)
    {
        requestParameters.put("name",name);
        requestParameters.put("email",email);
        apiActions.update(requestParameters,"/api/teams/" + id);
    }


    @Step("Delete team from Grafana")
    public static void deleteTeam(String id)
    {
        apiActions.delete("/api/teams/",id);
    }
}
