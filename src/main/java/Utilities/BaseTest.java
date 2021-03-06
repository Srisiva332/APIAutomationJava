package Utilities;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeSuite;

import static Utilities.PropertyReader.readConfigurationFile;

public class BaseTest {

    protected static RequestSpecification requestSpec;
    protected static ResponseSpecification responseSpec;

        @BeforeSuite
    public void setBaseURI() {


        requestSpec = new RequestSpecBuilder().
                setBaseUri(readConfigurationFile("AppBaseURL")).
                build();

    }




    public String UpdateBody(String body,String id)
    {
        StringBuffer str = new StringBuffer(body);
        str.insert(1,"\"id\" :"+id+",");
        return str.toString();

    }

}

