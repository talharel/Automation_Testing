package Extensions;

import Utilities.commonOps;
import com.google.gson.JsonObject;
import io.qameta.allure.Step;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;

public class apiActions extends commonOps
{
    @Step("Get data from server")
    public static Response get(String apiParameters)
    {
        response = httpRequest.get(apiParameters);
        System.out.println(response.prettyPrint());
        return response;
    }

    @Step("Extract value from Json format")
    public static String extractFromJson(Response response, String path)
    {
        jp = response.jsonPath();
        return jp.get(path).toString();
    }

    @Step("Post data to the server")
    public static void post(JSONObject jsonParameter,String apiParameters)
    {
        httpRequest.header("Content-Type","application/json");
        httpRequest.body(jsonParameter.toJSONString());
        response = httpRequest.post(apiParameters);
        System.out.println(response.prettyPrint());
    }

    @Step("Update data to the server")
    public static void update(JSONObject jsonParameter,String apiParameters)
    {
        httpRequest.header("Content-Type","application/json");
        httpRequest.body(jsonParameter.toJSONString());
        response = httpRequest.put(apiParameters);
        System.out.println(response.prettyPrint());
    }

    @Step("Delete data from the server")
    public static void delete(String apiParameters,String id)
    {
        response = httpRequest.delete(apiParameters + id);
        System.out.println(response.prettyPrint());
    }
}
