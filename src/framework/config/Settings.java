package framework.config;

import framework.base.BrowserType;
import framework.utilities.LogUtil;

import java.sql.Connection;


public class Settings
{
   //For Application Backend
    public static Connection AUTConnection;
    //For EARS Reporting
    public static Connection ReportingConnection;
    //For Application backend connection string
    public static String AUTConnectionString;
    public static String ReportingConnectionString;
    //Log Path for framework
    public static String LogPath;
    //Driver Type for SQL Server connectivity
    public static String DriverType;
    public static String ExcelSheetPath;
    public static String AUT;
    public static  BrowserType BrowserType;
    public static LogUtil Logs;
    public static String FeatureContext;
    public static String ScenarioContext;
    public static String GetStepName;
    public static  String GetScreenShotPath;
    public static String ReportFileName;
}
