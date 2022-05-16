import Utilities.BaseTest;
import Utilities.ExcelLib;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;

import static io.restassured.RestAssured.given;

public class Tourist extends BaseTest {

    @DataProvider (name="DataFromExcel")
    public Object[][] data(Method m) throws Exception {
        System.out.println(m.getName());
        ExcelLib xl = new ExcelLib("TestData", m.getName());
        return xl.getTestdata();
    }

    @Test(dataProvider="DataFromExcel", description="Get Tourist Details")
    public void GET_TouristDetails(String body, String ExpectedCode,String a) throws IOException {
        Response response = given().
                spec(requestSpec).
                contentType("application/json").
                when().
                get("/api/Tourist/119657");
        System.out.println(response.getBody().asString());
        Assert.assertEquals(response.getStatusCode(),Integer.parseInt(ExpectedCode));

    }

    @Test(dataProvider="DataFromExcel", description="Get Tourist Details")
    public void POST_CreateTourist(String body, String ExpectedCode,String a) throws IOException {
        Response response = given().
                spec(requestSpec).
                contentType("application/json").
                body(body).
                when().
                post("/api/Tourist");
        System.out.println(response.getBody().asString());
        Assert.assertEquals(response.getStatusCode(),Integer.parseInt(ExpectedCode));

    }
}
