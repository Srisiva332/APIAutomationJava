package ss.co.mtn;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class CustomerBillManagement {

    @Test
    public void getUnpaidBillAmount()
    {
        Map<String,Object> headers = new HashMap<>();
        headers.put("x-api-key","k8hVx2YJhoRE0LcJ4PnJeI6fhtNWdCD7");
        headers.put("countryCode","SSD");
        Response response = given()
                .headers(headers)
                .get("https://mtn-preprod-staging.apigee.net/tmf-api/customerBillManagement/v4/customerBill?queryType=unpaidBill&offset=1&limit=2&customerType=2&customerId=6234567894");
        response.prettyPrint();
        System.out.println(response.getContentType());
        System.out.println(response.getStatusCode());

    }
}
