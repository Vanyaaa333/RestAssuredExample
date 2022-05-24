package bookings;

import constants.Status;
import model.Booking;
import model.CreatedBooking;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class DeleteTests extends BaseTest {

    CreatedBooking createdBooking;

    @BeforeMethod
    public void createTestBooking() {
        createdBooking = booking.createBooking(new Booking());
    }


    @Test
    public void deleteBookingTest() {
        Booking createdBookingCheck = booking.getBooking(createdBooking.getBookingid(), Status.OK);
        assertThat(createdBookingCheck, equalTo(createdBooking.getBooking()));
        booking.deleteBooking(createdBooking.getBookingid(), tokenHeader);
        booking.getBooking(createdBooking.getBookingid(), Status.NOT_FOUND);
    }


}
