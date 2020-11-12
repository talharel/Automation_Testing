package Extensions;

import Utilities.commonOps;
import io.qameta.allure.Step;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class dbActions extends commonOps
{
    @Step("Get the data from DB")
    public static List<String> getDataFromDB(String query)
    {
        List <String> list = new ArrayList<String>();
        try
        {
            rs = stmt.executeQuery(query);
            rs.next();
            list.add(rs.getString(1));
            list.add(rs.getString(2));

        } catch (Exception e)
        {
            System.out.println("Error occurred while printing table data, See Details: " + e);
        }

        return list;
    }
}
