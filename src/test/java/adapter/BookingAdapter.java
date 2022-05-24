package adapter;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import constants.EndPoints;
import constants.Status;
import io.restassured.http.Header;
import io.restassured.response.Response;
import model.Booking;
import model.CreatedBooking;

public class BookingAdapter extends BaseAdapter {

    public CreatedBooking createBooking(Booking booking) {
        Response response = post(EndPoints.BOOKING, booking);
        response.then().statusCode(Status.OK);
        return response.as(CreatedBooking.class);
    }

    public Booking getBooking(Integer id, int statusCode) {
        String url = EndPoints.BOOKING + id;
        Response response = get(url);
        response.then().statusCode(statusCode);
        try {
            return new Gson().fromJson(response.getBody().asString(), Booking.class);
        } catch (JsonSyntaxException ex) {
            return null;
        }
    }


    public void deleteBooking(Integer id, Header tokenHeader) {
        String url = EndPoints.BOOKING + id;
        Response response = delete(url, tokenHeader);
        response.then().statusCode(201);
    }

}