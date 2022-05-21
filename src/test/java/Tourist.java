import Utilities.BaseTest;
import Utilities.ExcelLib;
import Utilities.FrameworkConstants;
import api.RestMethod;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.request;

public class Tourist extends BaseTest {

    private String id = null;

    @DataProvider (name="DataFromExcel")
    public Object[][] data(Method m) throws Exception {
        System.out.println(m.getName());
        ExcelLib xl = new ExcelLib("TestData", m.getName());
        return xl.getTestdata();
    }

    @Test(dataProvider="DataFromExcel", description="Get Tourist Details")
    public void GET_TouristDetails(String id, String ExpectedCode) throws IOException {
        Response response = RestMethod.GET(requestSpec,"/api/Tourist",id) ;
        System.out.println(response.getBody().asString());
        Assert.assertEquals(response.getStatusCode(),Integer.parseInt(ExpectedCode));

    }

    @Test(dataProvider="DataFromExcel", description="Get Tourist Details")
    public void POST_CreateTourist(String body, String ExpectedCode) throws IOException {
        Response response = RestMethod.POST(requestSpec,"/api/Tourist",body);
        System.out.println(response.getBody().asString());
        System.out.println(response.then().extract().path("id"));
        id = response.then().extract().path("id").toString();
        Assert.assertEquals(response.getStatusCode(),Integer.parseInt(ExpectedCode));
    }

    @Test(dataProvider="DataFromExcel", description="Get Tourist Details")
    public void PUT_UpdateTourist(String Postbody, String PutBody, String ExpectedCode) throws IOException {
        Response response = RestMethod.POST(requestSpec, "/api/Tourist", Postbody);
        id = response.then().extract().path("id").toString();
        response = RestMethod.PUT(requestSpec, "/api/Tourist", UpdateBody(PutBody, id), id);
        System.out.println(response.getBody().asString());
        Assert.assertEquals(response.getStatusCode(), Integer.parseInt(ExpectedCode));
    }

        // Extent Reports & Extent report attachments - P2
        // Put  - P1
        // Update Excel for better options - P3
        // Git Configuration and usage.


}
