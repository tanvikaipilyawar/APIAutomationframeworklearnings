package org.example.pojos;

public class BookingResponse {
    private Integer bookingId;
    private Booking booking;

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    @Override
    public String toString() {
        return "BookingResponse{" +
                "bookingId=" + bookingId +
                ", booking=" + booking +
                '}';
    }

    public Integer getBookingId() {
        return bookingId;
    }

    public Booking getBooking() {
        return booking;
    }
}
