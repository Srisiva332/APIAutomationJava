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
import org.testng.annotations.Test;


import static api.SpecBuilder.getRequestSpec;
import static api.SpecBuilder.getResponseSpec;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class Spotify {

    @Test
    public void CreatePlaylist() {
        String payload = "{\n" +
                "  \"name\": \"Chandu's Playlist\",\n" +
                "  \"description\": \"New playlist description\",\n" +
                "  \"public\": false\n" +
                "}";
        Response response = RestMethod.post("/users/yv0gp1oce9zbixdi7g58tjcgb/playlists",payload);
        assertThat(response.statusCode(), equalTo(201));
    }

    @Test
    public void GetALLPlaylists()
    {
        Response response = RestMethod.get("/users/yv0gp1oce9zbixdi7g58tjcgb/playlists","");
        assertThat(response.statusCode(), equalTo(200));
    }

    @Test
    public void GetPlaylist()
    {
        Response response = RestMethod.get("/playlists/3j2pHh3bW9tujO0CgEjjCq","");
        assertThat(response.statusCode(), equalTo(200));
    }

    @Test
    public void UpdatePlaylist()
    {
        Response response = RestMethod.put("/playlists/3j2pHh3bW9tujO0CgEjjCq");
        assertThat(response.statusCode(), equalTo(200));
    }

}
