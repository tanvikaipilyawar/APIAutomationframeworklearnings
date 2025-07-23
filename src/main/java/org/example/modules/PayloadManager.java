package org.example.modules;

import com.google.gson.Gson;
import org.example.pojos.Booking;
import org.example.pojos.BookingDates;

public class PayloadManager {
 Gson gson;
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

        return gson.toJson(booking);

    }
}
