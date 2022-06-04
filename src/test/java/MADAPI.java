import Utilities.ExcelLib;
import api.RestMethod;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;

public class MADAPI {


    @DataProvider(name="DataFromExcel")
    public Object[][] data(Method m) throws Exception {
        System.out.println(m.getName());
        ExcelLib xl = new ExcelLib("Capture Customer Info API ", m.getName());
        return xl.getTestdataMAD();
    }

    @Test(dataProvider="DataFromExcel", description="Get Tourist Details")
    public void GET_MADAPI_DEV(String title, String Description,String ExpectedResult,String id, String ExpectedCode) throws IOException {
        System.out.println("End Test");
    }


}
