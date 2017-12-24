package framework.utilities;

import java.sql.Connection;
import java.util.Hashtable;


public class ReportingUtil {


    public static void CreateTestCycle(Connection connection) {
        //Params
        Hashtable table = new Hashtable();
        table.put("AUT", "Ecommerce");
        table.put("ExecutedBy", "Rohit Current");
        table.put("RequestedBy", "Rohit saini");
        table.put("BuildNo", "1.0");
        table.put("ApplicationVersion", "1.0");
        table.put("MachineName", "Windows 10");
        table.put("TestType", 1);

        DatabaseUtil.ExecuteStoredProc("sp_CreateTestCycleID", table, connection);

    }

    public static void WriteTestResults(Connection connection, String featureName, String scenarioName, String stepName, String Exception, String Result) {
        try {
            Hashtable table = new Hashtable();
            table.put("FeatureName", featureName);
            table.put("ScenarioName", scenarioName);
            table.put("StepName", stepName);
            table.put("Exception", Exception);
            table.put("Result", Result);
            DatabaseUtil.ExecuteStoredProc("sp_InsertResult", table, connection);
        }
        catch (Exception e) {

        }
    }


}
