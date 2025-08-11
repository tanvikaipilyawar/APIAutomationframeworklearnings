package org.example.Base;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.example.actions.AssertActions;
import org.example.endpoints.APIConstants;
import org.example.modules.PayloadManager;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    public RequestSpecification requestSpecification;
    public AssertActions assertActions;
    public PayloadManager payloadManager;
    public JsonPath jsonPath;
    public Response response;
    public ValidatableResponse validableResponse;
    @BeforeTest
    public void setUp(){
        System.out.println("Before Test");
        payloadManager = new PayloadManager();
        assertActions = new AssertActions();

        requestSpecification = new RequestSpecBuilder()
                .setBaseUri(APIConstants.BASE_URL)
                .addHeader("Content-Type","application/json")
                .build().log().all();
    }

    public String getToken(){
        //Set up the URLss
        requestSpecification = RestAssured.given().baseUri(APIConstants.BASE_URL)
                .basePath(APIConstants.AUTH_URL);

        //Setting up the Payload
        String payload =payloadManager.setAuthPayload();

        //Getting the Response-
          response= requestSpecification.contentType(ContentType.JSON).body(payload)
                .when().post();
          //Extracting of token via. deserialization
                String token = payloadManager.getTokenFromJson(response.asString());

                //Verify
                return token;
    }
}
