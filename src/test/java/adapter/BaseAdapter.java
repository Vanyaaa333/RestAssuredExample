package adapter;

import com.google.gson.Gson;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import model.JsonModel;

import static io.restassured.RestAssured.given;

public class BaseAdapter {

    private static final String BASE_URL = "https://restful-booker.herokuapp.com/";

    protected RequestSpecification requestSpec = new RequestSpecBuilder()
            .setContentType(ContentType.JSON)
            .build();

    public Response post(String url, JsonModel jsonModel) {
        return given()
                .spec(requestSpec)
                .body(new Gson().toJson(jsonModel))
                .when()
                .post(BASE_URL + url);
    }


      public Response delete(String url, Header tokenHeader) {
        Response response = given()
                .spec(requestSpec)
                .header(tokenHeader)
                .delete(BASE_URL + url);
        return response;
    }

    public Response get(String url) {
        return given()
                .spec(requestSpec)
                .get(BASE_URL + url);
    }


}