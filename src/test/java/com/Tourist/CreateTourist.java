package com.Tourist;

import Utilities.BaseTest;
import Utilities.PropertyReader;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

import static Utilities.PropertyReader.readConfigurationFile;
import static io.restassured.RestAssured.given;

public class CreateTourist extends BaseTest{

    @Test
    public void POST_CreateTourist()
    {
        Random random = new Random();
        Response response = given().
                spec(requestSpec).
                contentType("application/json").
                body("{ \"tourist_name\": \"Mike\",\"tourist_email\": \"mike"+random.nextInt(1000)+"@gmail.com\",\"tourist_location\": \"Paris\"}").
                when().
                post("/api/Tourist");
        System.out.println(response.getBody().asString());
        Assert.assertEquals(response.getStatusCode(),201);
    }

    @Test
    public void GET_ToursitDetails()
    {
        Response response = given().
                spec(requestSpec).
                contentType("application/json").
                when().
                get("/api/Tourist/119657");
        System.out.println(response.getBody().asString());
        Assert.assertEquals(response.getStatusCode(),200);
    }
}
