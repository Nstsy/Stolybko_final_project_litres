package ru.litres.api;

import io.restassured.response.ValidatableResponse;
import ru.litres.domain.User;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static ru.litres.api.endpoints.Endpoints.LOGIN_ENDPOINT;
import static ru.litres.api.endpoints.Endpoints.getURI;

public class LoginApi {

    public ValidatableResponse getResponseForRequestWithData(String login, String password) {
        return given()
                .body(getBody(login, password))
                .headers(getHeaders())
                .when()
                .post(getURI(LOGIN_ENDPOINT))
                .then()
                .log().all();
    }

    public static String getBody(String login, String password) {
        return "{\"login\":\"" + login + "\",\"password\":\"" + password + "\"}";
    }

    public static Map<String, String> getHeaders() {
        Map<String, String> headers = new HashMap<>();
        headers.put("app-id", "115");
        headers.put("Content-Type", "application/json");
        return headers;
    }

    public ValidatableResponse getResponseForRequestWithData(User user) {
        return getResponseForRequestWithData(user.getLogin(), user.getPassword());
    }
}
