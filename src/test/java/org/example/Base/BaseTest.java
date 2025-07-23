package org.example.Base;

import org.testng.annotations.BeforeTest;

public class BaseTest {
    public RequestSpecification requestSpecification;
    public AssertActions assertActions;
    public PayloadManager payloadManager;
    public JsonPath jsonPath;
    public Response response;
    public ValidableResponse validableResponse;
    @BeforeTest
    public void setConfig(){
        System.out.println("Before Test");
    }
}
