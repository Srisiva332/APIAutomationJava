package Utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyReader {
    protected static Properties properties;

    public static String readConfigurationFile(String key) {
        try{
            properties = new Properties();
            properties.load(new FileInputStream(getEnvironmentProperties()));

        } catch (Exception e){
            System.out.println("Cannot find key: "+key+" in Config file due to exception : "+e);
        }
        return properties.getProperty(key).trim();
    }

    public static String getEnvironmentProperties() throws Exception {
        String environment = null;
        switch (FrameworkConstants.Environment.toLowerCase())
        {
            case "dev" :
                environment= FrameworkConstants.Dev_Config;
                break;
            case "sit" :
                environment= FrameworkConstants.SIT_Config;
                break;
            case "uat" :
                environment= FrameworkConstants.UAT_Config;
                break;
            default:
                throw new Exception(FrameworkConstants.Environment + " is not available");
        }
        return environment;
    }
}
