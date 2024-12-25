package ru.litres.api.utils;

import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;

import static org.hamcrest.Matchers.equalTo;

public class ValidationUtils {
    public static void validateUnprocessableEntity(ValidatableResponse response) {
        response.statusCode(HttpStatus.SC_UNPROCESSABLE_ENTITY)
                .body("status", equalTo(HttpStatus.SC_UNPROCESSABLE_ENTITY),
                        "error.type", equalTo("ParamValidationError"));
    }

    public static void validateUnauthorized(ValidatableResponse response) {
        response.statusCode(HttpStatus.SC_UNAUTHORIZED)
                .body("status", equalTo(HttpStatus.SC_UNAUTHORIZED),
                        "error.type", equalTo("Unauthorized"));
    }

    public static void validateOk(ValidatableResponse response) {
        response.statusCode(HttpStatus.SC_OK)
                .body("status", equalTo(HttpStatus.SC_OK));
    }

    public static void validateBadRequest(ValidatableResponse response) {
        response.statusCode(HttpStatus.SC_BAD_REQUEST)
                .body("status", equalTo(HttpStatus.SC_BAD_REQUEST),
                        "error.type", equalTo("InvalidPhoneNumber"));
    }
}
