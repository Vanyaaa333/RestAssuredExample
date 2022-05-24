package bookings;

import adapter.AuthAdapter;
import adapter.BookingAdapter;
import com.google.gson.Gson;
import io.restassured.http.Header;
import model.User;
import org.testng.annotations.BeforeClass;
import utils.CookieUtils;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class BaseTest {

    private static final String CRED_PATH = "src/test/resources/ValidCredentials.json";

    AuthAdapter auth;
    BookingAdapter booking;
    User validUser;

    public Header tokenHeader;

    @BeforeClass
    public void setup() throws FileNotFoundException {
        validUser = new Gson().fromJson(new FileReader(CRED_PATH), User.class);
        auth = new AuthAdapter();
        booking = new BookingAdapter();

        String token = auth.getToken(validUser);
        tokenHeader = new Header("Cookie", CookieUtils.getTokenCookie(token));
    }


}
