package api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;

import static api.SpecBuilder.getResponseSpec;
import static io.restassured.RestAssured.given;

public class TokenManager {

    public static String renewToken()
    {
        HashMap<String,String> formParam = new HashMap<String,String>();
        formParam.put("client_id","9cdeb007607a4dd6bfd0997578a63a8e");
        formParam.put("client_secret","02d492f6d38b4948b8ff3845be02c919");
        formParam.put("refresh_token","AQBq6GLDIUg492OlvIqwQDv_Je4_bPmTDoWHrtSG7jgSSbdtjkVcGr5InivGe9mQxDLxNyPvNCAv9o7OCn7a59tVYYORyuA4vNmuNxgUpwxQbSX43XB8R2l4GnocHGcxRRE");
        formParam.put("grant_type","refresh_token");

        Response response = given()
                .baseUri("https://accounts.spotify.com")
                .contentType(ContentType.URLENC)
                .formParams(formParam)
                .when().post("/api/token")
                .then().spec(getResponseSpec())
                .extract()
                .response();

        if(response.statusCode()!=200)
            throw new RuntimeException("ABORT!! Renew token failed");

        return response.path("access_token");


    }
}
