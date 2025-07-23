package org.example.pojos;

public class Booking {

    public String firstname;
    public String lastname;
    public String totalprice;
    public String depositpaid;

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setTotalprice(String totalprice) {
        this.totalprice = totalprice;
    }

    public void setDepositpaid(String depositpaid) {
        this.depositpaid = depositpaid;
    }

    public void setBookingDates(BookingDates bookingDates) {
        this.bookingDates = bookingDates;
    }

    public void setAdditionalneeds(String additionalneeds) {
        Additionalneeds = additionalneeds;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", totalprice='" + totalprice + '\'' +
                ", depositpaid='" + depositpaid + '\'' +
                ", bookingDates=" + bookingDates +
                ", Additionalneeds='" + Additionalneeds + '\'' +
                '}';
    }

    public String getTotalprice() {
        return totalprice;
    }

    public String getDepositpaid() {
        return depositpaid;
    }

    public BookingDates getBookingDates() {
        return bookingDates;
    }

    public String getAdditionalneeds() {
        return Additionalneeds;
    }

    private BookingDates bookingDates;
    private String Additionalneeds;
}
