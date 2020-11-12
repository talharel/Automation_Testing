package Utilities;

import java.sql.DriverManager;

public class manageDB extends commonOps
{
    public static void initConnection(String dbUrl,String userName,String passWord)
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(dbUrl,userName,passWord);
            stmt = con.createStatement();
        }
        catch (Exception e)
        {
            System.out.println("Error occurred while Connecting to DB, See Details: " + e);
        }
    }

    public static void closeConnection()
    {
        try
        {
            con.close();
        }
        catch (Exception e)
        {
            System.out.println("Error occurred while Closing DB, See Details: " + e);
        }
    }
}
