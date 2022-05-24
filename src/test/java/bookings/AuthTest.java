package bookings;
import org.testng.annotations.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class AuthTest extends BaseTest {

    @Test
    public void validAuth() {
        String token = auth.getToken(validUser);
        assertThat(token, notNullValue());
        assertThat(token.length(), equalTo(15));
    }

    /*
    @Test
    public void getAuthToken() {
        User validUser = new User("admin", "password123");
        String jsonUser = new Gson().toJson(validUser);
        String token = given()
                .contentType("application/json")
                .body(jsonUser)
                .when()
                .post("https://restful-booker.herokuapp.com/auth")
                .then()
                .statusCode(Status.OK)
                .extract()
                .body()
                .path("token");
        assertThat(token, notNullValue());
        assertThat(token.length(), equalTo(15));
    }
    */

}