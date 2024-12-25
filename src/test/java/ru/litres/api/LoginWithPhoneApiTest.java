package ru.litres.api;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.litres.api.utils.ValidationUtils;
import ru.litres.domain.User;
import ru.litres.domain.UsersWithPhoneAndCountryCode;

@Epic("API тесты")
@Feature("API тесты формы входа с номером телефона")
public class LoginWithPhoneApiTest extends BaseApiTest {

    @Test
    @DisplayName("Не заданы параметры кода страны и телефона")
    public void testWithEmptyCodePhone() {
        logger.info("ЗАПУСК ТЕСТА: Не заданы параметры кода страны и телефона");

        User userWithEmptyCodePhone = UsersWithPhoneAndCountryCode.getUserWithEmptyCodePhone();
        ValidatableResponse response = phoneApi.getResponseForRequestWithData(userWithEmptyCodePhone);

        ValidationUtils.validateUnprocessableEntity(response);

        logger.info("ТЕСТ ЗАВЕРШЕН: ожидаемый статус-код 422 подтвержден.");
    }

    @Test
    @DisplayName("Некорректные параметры кода страны и телефона")
    public void testWithInvalidCodePhone() {
        logger.info("ЗАПУСК ТЕСТА: Некорректные параметры кода страны и телефона");

        User userWithInvalidCodePhone = UsersWithPhoneAndCountryCode.getUserWithInvalidCodePhone();
        ValidatableResponse response = phoneApi.getResponseForRequestWithData(userWithInvalidCodePhone);

        ValidationUtils.validateUnprocessableEntity(response);

        logger.info("ТЕСТ ЗАВЕРШЕН: ожидаемый статус-код 422 подтвержден.");
    }

    @Test
    @DisplayName("Отсутствует код страны в запросе")
    public void testWithoutCode() {
        logger.info("ЗАПУСК ТЕСТА: Отсутствует код страны в запросе");

        User userWithoutCode = UsersWithPhoneAndCountryCode.getUserWithoutCode();
        ValidatableResponse response = phoneApi.getResponseForRequestWithData(userWithoutCode);

        ValidationUtils.validateUnprocessableEntity(response);

        logger.info("ТЕСТ ЗАВЕРШЕН: ожидаемый статус-код 422 подтвержден.");
    }

    @Test
    @DisplayName("Отсутствует телефон в запросе")
    public void testWithoutPhone() {
        logger.info("ЗАПУСК ТЕСТА: Отсутствует телефон в запросе");

        User userWithoutPhone = UsersWithPhoneAndCountryCode.getUserWithoutPhone();
        ValidatableResponse response = phoneApi.getResponseForRequestWithData(userWithoutPhone);

        ValidationUtils.validateUnprocessableEntity(response);

        logger.info("ТЕСТ ЗАВЕРШЕН: ожидаемый статус-код 422 подтвержден.");
    }

    @Test
    @DisplayName("Заданы корректные данные")
    public void testSuccessfulLogin() {
        logger.info("ЗАПУСК ТЕСТА: Заданы корректные данные");

        User validUser = UsersWithPhoneAndCountryCode.getValidUserCodePhoneBY();
        ValidatableResponse response = phoneApi.getResponseForRequestWithData(validUser);

        ValidationUtils.validateOk(response);

        logger.info("ТЕСТ ЗАВЕРШЕН: ожидаемый статус-код 200 подтвержден.");
    }

    @Test
    @DisplayName("Задан коррекный код страны, некорректный телефон")
    public void testWithValidCode() {
        logger.info("ЗАПУСК ТЕСТА: Задан коррекный код страны, некорректный телефон");

        User userWithValidCode = UsersWithPhoneAndCountryCode.getUserWithValidCode();
        ValidatableResponse response = phoneApi.getResponseForRequestWithData(userWithValidCode);

        ValidationUtils.validateBadRequest(response);

        logger.info("ТЕСТ ЗАВЕРШЕН: ожидаемый статус-код 400 подтвержден.");
    }

    @Test
    @DisplayName("Задан некоррекный код страны, корректный телефон")
    public void testWithValidPhone() {
        logger.info("ЗАПУСК ТЕСТА: Задан некоррекный код страны, корректный телефон");

        User userWithValidPhone = UsersWithPhoneAndCountryCode.getUserWithValidPhone();
        ValidatableResponse response = phoneApi.getResponseForRequestWithData(userWithValidPhone);

        ValidationUtils.validateUnprocessableEntity(response);

        logger.info("ТЕСТ ЗАВЕРШЕН: ожидаемый статус-код 422 подтвержден.");
    }
}
