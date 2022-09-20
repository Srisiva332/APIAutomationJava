package com.Tourist;

import Utilities.PropertyReader;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class InitialTests {

    @Test
    public void POST_CreateTourist()
    {
        Random random = new Random();
        System.out.println(PropertyReader.readConfigurationFile("AppBaseURL"));
        RestAssured.baseURI = PropertyReader.readConfigurationFile("AppBaseURL");
        RequestSpecification requestSpec = RestAssured.given();
        requestSpec.header("Content-type","application/json");
        Response response = requestSpec.body("{ \"tourist_name\": \"Mike\",\"tourist_email\": \"mike"+random.nextInt(1000)+"@gmail.com\",\"tourist_location\": \"Paris\"}").post("/api/Tourist");
        System.out.println(response.getBody().asString());
        Assert.assertEquals(response.getStatusCode(),201);
    }

    @Test
    public void GET_ToursitDetails()
    {
        System.out.println(PropertyReader.readConfigurationFile("AppBaseURL"));
        RestAssured.baseURI = PropertyReader.readConfigurationFile("AppBaseURL");
        RequestSpecification requestSpec = RestAssured.given();
        requestSpec.header("Content-type","application/json");
        Response response = requestSpec.get("/api/Tourist/119657");
        System.out.println(response.getBody().asString());
        Assert.assertEquals(response.getStatusCode(),200);
    }
}
