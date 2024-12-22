package ru.litres.api;

import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;
import static ru.litres.api.endpoints.Endpoints.SEARCH_ENDPOINT;
import static ru.litres.api.endpoints.Endpoints.getURI;

public class SearchApi {
    public ValidatableResponse getResponseForRequestWithData(String query) {
        String getURL = getURI(SEARCH_ENDPOINT) + "?q=" + query;
        return given()
                .queryParam("q", query)
                .when()
                .get(getURL)
                .then()
                .log().all();
    }
}
