package ru.litres.api;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.restassured.response.ValidatableResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.litres.domain.User;
import ru.litres.domain.UsersPhone;

import static org.hamcrest.Matchers.equalTo;

@Epic("API тесты")
@Feature("API тесты формы входа с номером телефона")
public class LoginWithPhoneApiTest extends BaseApiTest {
    private static final Logger logger = LogManager.getLogger(LoginWithPhoneApiTest.class);

    @Test
    @DisplayName("Не заданы параметры кода страны и телефона")
    public void testWithEmptyCodePhone() {
        logger.info("ЗАПУСК ТЕСТА: Не заданы параметры кода страны и телефона");

        User userWithEmptyCodePhone = UsersPhone.getUserWithEmptyCodePhone();
        ValidatableResponse response = phoneApi.getResponseForRequestWithData(userWithEmptyCodePhone);
        response.log().all();

        response.statusCode(422);
        response.body(
                "status", equalTo(422),
                "error.type", equalTo("ParamValidationError"));

        logger.info("ТЕСТ ЗАВЕРШЕН: ожидаемый статус-код 422 подтвержден.");
    }

    @Test
    @DisplayName("Некорректные параметры кода страны и телефона")
    public void testWithInvalidCodePhone() {
        logger.info("ЗАПУСК ТЕСТА: Некорректные параметры кода страны и телефона");

        User userWithInvalidCodePhone = UsersPhone.getUserWithInvalidCodePhone();
        ValidatableResponse response = phoneApi.getResponseForRequestWithData(userWithInvalidCodePhone);
        response.log().all();

        response.statusCode(422);
        response.body(
                "status", equalTo(422),
                "error.type", equalTo("ParamValidationError"));

        logger.info("ТЕСТ ЗАВЕРШЕН: ожидаемый статус-код 422 подтвержден.");
    }

    @Test
    @DisplayName("Отсутствует код страны в запросе")
    public void testWithoutCode() {
        logger.info("ЗАПУСК ТЕСТА: Отсутствует код страны в запросе");

        User userWithoutCode = UsersPhone.getUserWithoutCode();
        ValidatableResponse response = phoneApi.getResponseForRequestWithData(userWithoutCode);
        response.log().all();

        response.statusCode(422);
        response.body(
                "status", equalTo(422),
                "error.type", equalTo("ParamValidationError"));

        logger.info("ТЕСТ ЗАВЕРШЕН: ожидаемый статус-код 422 подтвержден.");
    }

    @Test
    @DisplayName("Отсутствует телефон в запросе")
    public void testWithoutPhone() {
        logger.info("ЗАПУСК ТЕСТА: Отсутствует телефон в запросе");

        User userWithoutPhone = UsersPhone.getUserWithoutPhone();
        ValidatableResponse response = phoneApi.getResponseForRequestWithData(userWithoutPhone);
        response.log().all();

        response.statusCode(422);
        response.body(
                "status", equalTo(422),
                "error.type", equalTo("ParamValidationError"));

        logger.info("ТЕСТ ЗАВЕРШЕН: ожидаемый статус-код 422 подтвержден.");
    }

    @Test
    @DisplayName("Заданы корректные данные")
    public void testSuccessfulLogin() {
        logger.info("ЗАПУСК ТЕСТА: Заданы корректные данные");

        User validUser = UsersPhone.getValidUserCodePhoneBY();
        ValidatableResponse response = phoneApi.getResponseForRequestWithData(validUser);
        response.log().all();

        response.statusCode(200);
        response.body("status", equalTo(200));

        logger.info("ТЕСТ ЗАВЕРШЕН: ожидаемый статус-код 200 подтвержден.");
    }

    @Test
    @DisplayName("Задан коррекный код страны, некорректный телефон")
    public void testWithValidCode() {
        logger.info("ЗАПУСК ТЕСТА: Задан коррекный код страны, некорректный телефон");

        User userWithValidCode = UsersPhone.getUserWithValidCode();
        ValidatableResponse response = phoneApi.getResponseForRequestWithData(userWithValidCode);
        response.log().all();

        response.statusCode(400);
        response.body(
                "status", equalTo(400),
                "error.type", equalTo("InvalidPhoneNumber"));

        logger.info("ТЕСТ ЗАВЕРШЕН: ожидаемый статус-код 400 подтвержден.");
    }

    @Test
    @DisplayName("Задан некоррекный код страны, корректный телефон")
    public void testWithValidPhone() {
        logger.info("ЗАПУСК ТЕСТА: Задан некоррекный код страны, корректный телефон");

        User userWithValidPhone = UsersPhone.getUserWithValidPhone();
        ValidatableResponse response = phoneApi.getResponseForRequestWithData(userWithValidPhone);

        response.log().all();

        response.statusCode(422);
        response.body(
                "status", equalTo(422),
                "error.type", equalTo("ParamValidationError"));

        logger.info("ТЕСТ ЗАВЕРШЕН: ожидаемый статус-код 422 подтвержден.");
    }
}
