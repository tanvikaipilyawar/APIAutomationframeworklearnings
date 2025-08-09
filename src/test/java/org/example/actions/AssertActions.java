package org.example.actions;

import io.restassured.response.Response;

import static org.testng.Assert.assertEquals;

public class AssertActions {

    public void verifyResponseBody(String actual,String expected, String description){
        assertEquals(actual,expected,description);
    }

    public void verifyResponseBody(float actual,float expected, String description){
        assertEquals(actual,expected,description);
    }

    public void verifyStatusCodeInvalidReq(Response response){
        assertEquals(String.valueOf(response.statusCode()).startsWith("50"),true,
                "value os status code is"+response.getStatusCode());
    }
    public void verifyStatusCode(Response response){
        assertEquals(String.valueOf(response.statusCode()).startsWith("200"),true,
                "value os status code is"+response.getStatusCode());
    }
}
