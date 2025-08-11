package org.example.modules;

import com.google.gson.Gson;
import org.example.pojos.*;

public class PayloadManager {
  static Gson gson;
    public String createPayloadAsString(){

        Booking booking=new Booking();
        booking.setFirstname("Tanvi");
        booking.setLastname("kaips");
        booking.setTotalprice("211");
        booking.setDepositpaid("true");

        BookingDates bookingDates=new BookingDates();
        bookingDates.setCheckin("2024-02-01");
        bookingDates.setCheckout("2024-02-02");
        booking.setBookingDates(bookingDates);
        booking.setAdditionalneeds("snacks");
        gson = new Gson();

        String jsonPayload = gson.toJson(booking);
        return jsonPayload;

    }
    public String fullupdatePayloadAsString(){
        Booking booking=new Booking();
        booking.setFirstname("James");
        booking.setLastname("kaips");
        booking.setTotalprice("211");
        booking.setDepositpaid("true");

        BookingDates bookingDates=new BookingDates();
        bookingDates.setCheckin("2024-02-01");
        bookingDates.setCheckout("2024-02-02");
        booking.setBookingDates(bookingDates);
        booking.setAdditionalneeds("snacks");

        return gson.toJson(booking);

    }

    public static BookingResponse bookingResponseJava(String responseString){

        gson = new Gson();

        BookingResponse bookingResponse = gson.fromJson(responseString,BookingResponse.class);
        return bookingResponse;

    }

    public String setAuthPayload(){
   Auth auth = new Auth();
   auth.setUsername("admin");
    auth.setPassword("password123");
    gson = new Gson();

    String jsonPayloadString = gson.toJson(auth);
        return jsonPayloadString;
    }


    public String getTokenFromJson(String tokenResponse){

        gson = new Gson();
         //Response is in in JSON --> Object of tokenResponse
        //deserialization
        TokenResponse tokenResponse1 =gson.fromJson(tokenResponse,TokenResponse.class);
        return tokenResponse1.getToken();
    }

    public Booking getResponseFromJson(String getResponse){


        gson = new Gson();
        //Response is in in JSON --> Object of tokenResponse
        //deserialization

        Booking booking = gson.fromJson(getResponse,Booking.class);
        return  booking;
    }
}
