package org.example.tests.Integration;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.example.Base.BaseTest;
import org.example.endpoints.APIConstants;
import org.example.modules.PayloadManager;
import org.example.pojos.Booking;
import org.example.pojos.BookingResponse;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TCIntegration extends BaseTest {


    //Create a booking Create a Token
    //Get Booking
    //Update the Booking
    //Delete the Booking

    @Test(groups = "integration",priority = 1)
    @Owner("Tanvi")
    @Description("Verify that the Booking can be created")
    public void testCreateBooking(ITestContext iTestContext){
         iTestContext.setAttribute("token",getToken());
        //Assert.assertTrue(true);

        requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);
        response = RestAssured.given().spec(requestSpecification)
                .when().body(payloadManager.createPayloadAsString()).post();
        validableResponse = response.then().log().all();
        validableResponse.statusCode(200);

        BookingResponse bookingResponse = PayloadManager.bookingResponseJava(response.asString());

        //AssertJ Assertion
         assertThat(bookingResponse.getBookingId()).isNotNull();
        assertThat(bookingResponse.getBooking().getFirstname()).isNotNull().isNotBlank();
         assertThat(bookingResponse.getBooking().getLastname()).isEqualTo("Tanvi");

        //TestNG Assertion
        assertActions.verifyStatusCode(response);

        //Set the Booking Id
        iTestContext.setAttribute("bookingid",bookingResponse.getBookingId());

    }

    @Test(groups = "integration",priority = 2)
    @Owner("Tanvi")
    @Description("Verify that the Booking by Id")
    public void testVerifyBookingId(ITestContext iTestContext){
       String bookingid =  iTestContext.getAttribute("bookingid").toString();

        String BasePathGET = APIConstants.CREATE_UPDATE_BOOKING_URL+"/"+bookingid;
        requestSpecification.basePath(BasePathGET);
        response = RestAssured.given().spec(requestSpecification)
                .when().get();
        validableResponse = response.then().log().all();
        validableResponse.statusCode(200);

      //  System.out.println(iTestContext.getAttribute("token"));
       // Assert.assertTrue(true);
        Booking booking = payloadManager.getResponseFromJson(response.asString());
        //assertThat(booking.getFirstname()).isNotNull();
        assertThat(booking.getFirstname()).isNotNull().isNotBlank();
        assertThat(booking.getFirstname()).isEqualTo("Tanvi");




       // String payload = payloadManager.createPayloadAsString();
        //System.out.println("payload being sent"+payload);
    }

    @Test(groups = "integration",priority = 3)
    @Owner("Tanvi")
    @Description("Verify the update Booking by Id")
    public void testUpdateBookingId(ITestContext iTestContext){
        String token = (String) iTestContext.getAttribute("token");
        String bookingid =  iTestContext.getAttribute("bookingid").toString();

        String BasePathPUTPATCH = APIConstants.CREATE_UPDATE_BOOKING_URL+"/"+bookingid;
        requestSpecification.basePath(BasePathPUTPATCH);

        response = RestAssured.given().spec(requestSpecification).cookie("token",token)
                .when().body(payloadManager.fullupdatePayloadAsString()).put();
        validableResponse = response.then().log().all();
        validableResponse.statusCode(200);

        //  System.out.println(iTestContext.getAttribute("token"));
        // Assert.assertTrue(true);
        Booking booking = payloadManager.getResponseFromJson(response.asString());
        //assertThat(booking.getFirstname()).isNotNull();
        assertThat(booking.getFirstname()).isNotNull().isNotBlank();
        assertThat(booking.getFirstname()).isEqualTo("Tanvi");



        // Assert.assertTrue(true);
    }

    @Test(groups = "integration",priority = 4)
    @Owner("Tanvi")
    @Description("Verify the delete Booking by Id")
    public void testDeleteBookingId(ITestContext iTestContext){
        System.out.println(iTestContext.getAttribute("token"));
        String token = (String) iTestContext.getAttribute("token");


        String bookingid =  iTestContext.getAttribute("bookingid").toString();

        String BasePathDelete = APIConstants.CREATE_UPDATE_BOOKING_URL+"/"+bookingid;
        requestSpecification.basePath(BasePathDelete).cookie("token",token);


        validableResponse = RestAssured.given().spec(requestSpecification)
                .when().delete().then().log().all();
        validableResponse = response.then().log().all();
        validableResponse.statusCode(201);

        // Assert.assertTrue(true);

    }

}
