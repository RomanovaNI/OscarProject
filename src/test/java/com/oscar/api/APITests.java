package com.oscar.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITests {

    //Z628xkCHK1WhSBQchEHDTJQgTjs0HBttqx3dWEH0IZcXDdqH6ORA5jK8zReKVHuJ
//http://selenium1py.pythonanywhere.com/en-gb/accounts/login/


    @Test
    public void loginPositiveTest() {
        RequestSpecification requestSpecification = io.restassured.RestAssured.given();

        Response response = requestSpecification.contentType(ContentType.JSON)
                .given().header("Authorization", "Z628xkCHK1WhSBQchEHDTJQgTjs0HBttqx3dWEH0IZcXDdqH6ORA5jK8zReKVHuJ")
                .given().body("{\n" +
                        "    \"username\": \"lola@ll.ua\",\n" +
                        "    \"password\": \"Lola1234$\"\n" + "}")
                .when().post("http://selenium1py.pythonanywhere.com/en-gb/accounts/login/");

        String responseBody = response.getBody().asString();
        System.out.println(responseBody);
        int statusCode=response.getStatusCode();
        System.out.println(statusCode);
    }
}
