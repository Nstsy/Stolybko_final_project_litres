package ru.litres.api;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.litres.api.utils.ValidationUtils;
import ru.litres.domain.User;
import ru.litres.domain.UsersWithLoginAndPassword;

@Epic("API тесты")
@Feature("API тесты формы входа с логином и паролем")
public class LoginWithLoginAndPasswordApiTest extends BaseApiTest {

    @Test
    @DisplayName("Не заданы параметры логина и пароля")
    public void testWithEmptyParameters() {
        logger.info("ЗАПУСК ТЕСТА: Не заданы параметры логина и пароля");

        User userWithEmptyParameters = UsersWithLoginAndPassword.getUserWithEmptyLoginPassword();
        ValidatableResponse response = loginApi.getResponseForRequestWithData(userWithEmptyParameters);

        ValidationUtils.validateUnprocessableEntity(response);

        logger.info("ТЕСТ ЗАВЕРШЕН: ожидаемое состояние 422 подтверждено.");
    }

    @Test
    @DisplayName("Некорректные параметры логина и пароля")
    public void testWithInvalidParameters() {
        logger.info("ЗАПУСК ТЕСТА: Некорректные параметры логина и пароля");

        User userWithInvalidParameters = UsersWithLoginAndPassword.getUserWithInvalidLoginPassword();
        ValidatableResponse response = loginApi.getResponseForRequestWithData(userWithInvalidParameters);

        ValidationUtils.validateUnauthorized(response);

        logger.info("ТЕСТ ЗАВЕРШЕН: ожидаемое состояние 401 подтверждено.");
    }

    @Test
    @DisplayName("Отсутствует логин в запросе")
    public void testWithoutLogin() {
        logger.info("ЗАПУСК ТЕСТА: Отсутствует логин в запросе");

        User userWithoutLogin = UsersWithLoginAndPassword.getUserWithEmptyLogin();
        ValidatableResponse response = loginApi.getResponseForRequestWithData(userWithoutLogin);

        ValidationUtils.validateUnprocessableEntity(response);

        logger.info("ТЕСТ ЗАВЕРШЕН: ожидаемое состояние 422 подтверждено.");
    }

    @Test
    @DisplayName("Отсутствует пароль в запросе")
    public void testWithoutPassword() {
        logger.info("ЗАПУСК ТЕСТА: Отсутствует пароль в запросе");

        User userWithoutPassword = UsersWithLoginAndPassword.getUserWithValidLoginEmptyPassword();
        ValidatableResponse response = loginApi.getResponseForRequestWithData(userWithoutPassword);

        ValidationUtils.validateUnprocessableEntity(response);

        logger.info("ТЕСТ ЗАВЕРШЕН: ожидаемое состояние 422 подтверждено.");
    }

    @Test
    @DisplayName("Заданы корректные данные")
    public void testSuccessfulLogin() {
        logger.info("ЗАПУСК ТЕСТА: Заданы корректные данные");

        User validUser = UsersWithLoginAndPassword.getValidUser();
        ValidatableResponse response = loginApi.getResponseForRequestWithData(validUser);

        ValidationUtils.validateOk(response);


        logger.info("ТЕСТ ЗАВЕРШЕН: ожидаемое состояние 200 подтверждено.");
    }

    @Test
    @DisplayName("Задан коррекный логин, некорректный пароль")
    public void testWithValidLogin() {
        logger.info("ЗАПУСК ТЕСТА: Задан коррекный логин, некорректный пароль");

        User userWithValidLogin = UsersWithLoginAndPassword.getUserWithValidLoginInvalidPassword();
        ValidatableResponse response = loginApi.getResponseForRequestWithData(userWithValidLogin);

        ValidationUtils.validateUnauthorized(response);

        logger.info("ТЕСТ ЗАВЕРШЕН: ожидаемое состояние 401 подтверждено.");
    }

    @Test
    @DisplayName("Задан некоррекный логин, корректный пароль")
    public void testWithValidPassword() {
        logger.info("ЗАПУСК ТЕСТА: Задан некоррекный логин, корректный пароль");

        User userWithValidPassword = UsersWithLoginAndPassword.getUserWithInvalidLoginValidPassword();
        ValidatableResponse response = loginApi.getResponseForRequestWithData(userWithValidPassword);

        ValidationUtils.validateUnauthorized(response);

        logger.info("ТЕСТ ЗАВЕРШЕН: ожидаемое состояние 401 подтверждено.");
    }
}
