import Utilities.ExcelLib;
import api.RestMethod;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import java.lang.reflect.Method;

import static api.SpecBuilder.getRequestSpec;
import static api.SpecBuilder.getResponseSpec;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class Spotify {

    @DataProvider(name="DataFromExcel")
    public Object[][] data(Method m) throws Exception {
        System.out.println(m.getName());
        ExcelLib xl = new ExcelLib("Capture Customer Info API ", m.getName());
        return xl.getTestdataMAD();
    }

    @Test(dataProvider="DataFromExcel", description="Create PlayList")
    public void CreatePlaylist(String title, String description, String Expected_result, String payload, String expectedcode) {
        System.out.println("Title : "+ title);
        System.out.println("Description : "+ description);
        System.out.println("Expected Result : "+ Expected_result);
        Response response = RestMethod.post("/users/yv0gp1oce9zbixdi7g58tjcgb/playlists",payload);
        assertThat(response.statusCode(), equalTo(201));
    }

    @Test//(dataProvider="DataFromExcel", description="Get All Playlist")
    public void GetALLPlaylists()
    {
        Response response = RestMethod.get("/users/yv0gp1oce9zbixdi7g58tjcgb/playlists","");
        assertThat(response.statusCode(), equalTo(200));
    }

    @Test(dataProvider="DataFromExcel", description="Get Playlist")
    public void GetPlaylist()
    {
        Response response = RestMethod.get("/playlists/3j2pHh3bW9tujO0CgEjjCq","");
        assertThat(response.statusCode(), equalTo(200));
    }

    @Test(dataProvider="DataFromExcel", description="Update the Playlist")
    public void UpdatePlaylist()
    {
        Response response = RestMethod.put("/playlists/3j2pHh3bW9tujO0CgEjjCq");
        assertThat(response.statusCode(), equalTo(200));
    }

}
