package com.spotify;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Spotify2 {

    RequestSpecification requestSpecification;
    ResponseSpecification responseSpecification;

    String access_token = "BQAT68KXsnopPmc1yOn2qemGtMqYnWdUxaB0cqxI75fgdidgcY4HcmNYQCmjx77Bvm0_yaBXAmbrCyLZcByl_0REfY00RKEoK4X8_KF_QhmnbAaTUuzLY2kGnEv7FsTBu_y-5oTH3r5qhTE1eVnsapeySkzDHrIhdEjtUlzW2MViVV6ba3kNjNX6r5_ag61-wezrPh9Q4IsU6dDIqxw1b1mwYZHNQrA8XyhejV2mi3NV";

    @BeforeClass
    public void beforeClass()
    {
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder()
                .setBaseUri("https://api.spotify.com")
                .setBasePath("/v1")
                .addHeader("Authorization","Bearer "+ access_token)
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL);

        requestSpecification = requestSpecBuilder.build();

        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder()
                .log(LogDetail.ALL);

        responseSpecification = responseSpecBuilder.build();


    }

    @Test
    public void CreatePlaylist() {
        String payload = "{\n" +
                "  \"name\": \"Chandu's Playlist\",\n" +
                "  \"description\": \"New playlist description\",\n" +
                "  \"public\": false\n" +
                "}";

        given(requestSpecification)
                .body(payload)
                .when()
                .post("/users/yv0gp1oce9zbixdi7g58tjcgb/playlists")
                .then().spec(responseSpecification)
                .assertThat()
                .statusCode(201);
    }

    @Test
    public void GetALLPlaylists()
    {
        given(requestSpecification)
                .when()
                .get("/users/yv0gp1oce9zbixdi7g58tjcgb/playlists")
                .then().spec(responseSpecification)
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void GetPlaylist()
    {
        given(requestSpecification)
                .when()
                .get("/playlists/3j2pHh3bW9tujO0CgEjjCq")
                .then().spec(responseSpecification)
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void UpdatePlaylist()
    {
        given(requestSpecification)
                .when()
                .put("/playlists/3j2pHh3bW9tujO0CgEjjCq")
                .then().spec(responseSpecification)
                .assertThat()
                .statusCode(200);
    }

}
