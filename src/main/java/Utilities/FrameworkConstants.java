package Utilities;

public class FrameworkConstants {

    public static final String Dev_Config = "src/test/resources/Environments/dev.properties";
    public static final String SIT_Config = "src/test/resources/Environments/sit.properties";
    public static final String UAT_Config = "src/test/resources/Environments/uat.properties";
    public static final String Environment = System.getProperty("environment","uat");
    //mvn clean install -Denvironment=dev
    public static final String DATA_FILE_PATH = "src/test/resources/TestData/TestData.xlsx";
    public static final String EXCEL_SHEET = "TestData";

    public static String id = "";

}
