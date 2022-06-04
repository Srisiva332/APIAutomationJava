package api;

import Utilities.BaseTest;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static api.SpecBuilder.getRequestSpec;
import static api.SpecBuilder.getResponseSpec;
import static io.restassured.RestAssured.given;

public class RestMethod {

    static String access_token = "BQCcQOQ1NBjVCnFgV1C6sf2m79DeO53Y5h5CGd_7bOJ8jE2qr_wtubUaaW8u9QhlWistVJThMxPcp2kjgZ417wKQWC13dunN86lvSM5LDuLSJt93MG9ANJlx3Ov0Bn46Nv82SD0amXB8CLsoe-_cRSTkMPcd9oavCfm2Rhn10zEw494SOZBGxjNdVPcV1u2UIqbtZU8yisc4ZHrIwjtFmyX0qPwEICDdyJjMPJkewxpc";
    public static Response post(RequestSpecification requestSpec, String Endpoint, String body)
    {
        Response response = given().
                spec(requestSpec).
                contentType("application/json").
                body(body).
                when().
                post(Endpoint);
        return response;
    }

    public static Response put(RequestSpecification requestSpec, String Endpoint, String body,String id)
    {
        Response response = given().
                spec(requestSpec).
                contentType("application/json").
                body(body).
                when().
                put(Endpoint+"/"+id);
        return response;
    }

    public static Response get(RequestSpecification requestSpec, String Endpoint, String id)
    {
        Response response =  given().
                spec(requestSpec).
                contentType("application/json").
                when().
                get(Endpoint+"/"+id);
        return response;
    }

    public static Response post(String endpoint, String payload)
    {
        return given(getRequestSpec())
                .body(payload)
                .header("Authorization","Bearer "+ access_token)
                .when()
                .post("/users/yv0gp1oce9zbixdi7g58tjcgb/playlists")
                .then().spec(getResponseSpec())
                .extract()
                .response();
    }

    public static Response get(String endpoint, String id)
    {
        return given(getRequestSpec())
                .header("Authorization","Bearer "+ access_token)
                .when()
                .get("/users/yv0gp1oce9zbixdi7g58tjcgb/playlists")
                .then().spec(getResponseSpec())
                .extract()
                .response();
    }

    public static Response put(String id)
    {
        return given(getRequestSpec())
                .header("Authorization","Bearer "+ access_token)
                .when()
                .get("/users/yv0gp1oce9zbixdi7g58tjcgb/playlists")
                .then().spec(getResponseSpec())
                .extract()
                .response();
    }


}
