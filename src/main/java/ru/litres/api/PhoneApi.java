package ru.litres.api;

import io.restassured.response.ValidatableResponse;
import ru.litres.domain.User;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static ru.litres.api.endpoints.Endpoints.PHONE_ENDPOINT;
import static ru.litres.api.endpoints.Endpoints.getURI;

public class PhoneApi {

    public ValidatableResponse getResponseForRequestWithData(String phone, String code) {
        return given()
                .body(getBody(phone, code))
                .headers(getHeaders())
                .when()
                .post(getURI(PHONE_ENDPOINT))
                .then()
                .log().all();
    }

    public ValidatableResponse getResponseForRequestWithData(User user) {
        return getResponseForRequestWithData(user.getCode().code + user.getPhone(), user.getCode().name());
    }

    public static String getBody(String phone, String code) {
        return "{\"phone\":\"" + phone + "\",\"country_code\":\"" + code + "\"}";
    }

    public static Map<String, String> getHeaders() {
        Map<String, String> headers = new HashMap<>();
        headers.put("app-id", "115");
        headers.put("Content-Type", "application/json");
        return headers;
    }
}
