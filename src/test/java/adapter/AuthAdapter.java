package adapter;

import constants.EndPoints;
import constants.Status;
import io.restassured.response.Response;
import model.User;

public class AuthAdapter extends BaseAdapter {

    public String getToken(User user) {
        Response response = post(EndPoints.AUTH, user);
        response.then().statusCode(Status.OK);
        return response.body().path("token");
    }

}