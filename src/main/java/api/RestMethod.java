package api;

import Utilities.BaseTest;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class RestMethod {

    public static Response POST(RequestSpecification requestSpec, String Endpoint, String body)
    {
        Response response = given().
                spec(requestSpec).
                contentType("application/json").
                body(body).
                when().
                post(Endpoint);
        return response;
    }

    public static Response PUT(RequestSpecification requestSpec, String Endpoint, String body,String id)
    {
        Response response = given().
                spec(requestSpec).
                contentType("application/json").
                body(body).
                when().
                put(Endpoint+"/"+id);
        return response;
    }

    public static Response GET(RequestSpecification requestSpec, String Endpoint, String id)
    {
        Response response =  given().
                spec(requestSpec).
                contentType("application/json").
                when().
                get(Endpoint+"/"+id);
        return response;
    }

}
