package org.example.tests.crud;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.restassured.RestAssured;
import org.example.Base.BaseTest;
import org.example.endpoints.APIConstants;
import org.example.modules.PayloadManager;
import org.example.pojos.BookingResponse;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class testCreateBookingPOST extends BaseTest {



      @Test(groups = "smoke")
              @Owner("Tan")
     // @Severity(Severity.NORMAL)
@Description("#TC1-Verifying that booking can be created")
      public void testCreateBooking(){
            requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);
            response= RestAssured
                    .given(requestSpecification)
                    .when().body(payloadManager.createPayloadAsString()).post();

              //validatableResponse Assertion
            validableResponse = response.then().log().all();
            validableResponse.statusCode(200);

            //BookingResponse bookingResponse = PayloadManager.bookingResponseJava(response.asString());

            //AssertJ Assertion
          //  assertThat(bookingResponse.getBookingId()).isNotNull();
          //  assertThat(bookingResponse.getBooking().getFirstname()).isNotNull().isNotBlank();
          //  assertThat(bookingResponse.getBooking().getLastname()).isEqualTo("Tanvi");

            //TestNG Assertion
            assertActions.verifyStatusCode(response);

      }


}
