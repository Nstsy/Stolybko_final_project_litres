package ru.litres.api;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.restassured.response.ValidatableResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.litres.domain.User;
import ru.litres.domain.UsersLogin;

import static org.hamcrest.Matchers.equalTo;

@Epic("API тесты")
@Feature("API тесты формы входа с логином и паролем")
public class LoginWithLoginAndPasswordApiTest extends BaseApiTest {
    private static final Logger logger = LogManager.getLogger(LoginWithLoginAndPasswordApiTest.class);

    @Test
    @DisplayName("Не заданы параметры логина и пароля")
    public void testWithEmptyParameters() {
        logger.info("ЗАПУСК ТЕСТА: Не заданы параметры логина и пароля");

        User userWithEmptyParameters = UsersLogin.getUserWithEmptyLoginPassword();
        ValidatableResponse response = loginApi.getResponseForRequestWithData(userWithEmptyParameters);
        response.log().all();

        response.statusCode(422);
        response.body(
                "status", equalTo(422),
                "error.type", equalTo("ParamValidationError"));

        logger.info("ТЕСТ ЗАВЕРШЕН: ожидаемое состояние 422 подтверждено.");
    }

    @Test
    @DisplayName("Некорректные параметры логина и пароля")
    public void testWithInvalidParameters() {
        logger.info("ЗАПУСК ТЕСТА: Некорректные параметры логина и пароля");

        User userWithInvalidParameters = UsersLogin.getUserWithInvalidLoginPassword();
        ValidatableResponse response = loginApi.getResponseForRequestWithData(userWithInvalidParameters);
        response.log().all();

        response.statusCode(401);
        response.body(
                "status", equalTo(401),
                "error.type", equalTo("Unauthorized"));

        logger.info("ТЕСТ ЗАВЕРШЕН: ожидаемое состояние 401 подтверждено.");
    }

    @Test
    @DisplayName("Отсутствует логин в запросе")
    public void testWithoutLogin() {
        logger.info("ЗАПУСК ТЕСТА: Отсутствует логин в запросе");

        User userWithoutLogin = UsersLogin.getUserWithEmptyLogin();
        ValidatableResponse response = loginApi.getResponseForRequestWithData(userWithoutLogin);
        response.log().all();

        response.statusCode(422);
        response.body(
                "status", equalTo(422),
                "error.type", equalTo("ParamValidationError"));

        logger.info("ТЕСТ ЗАВЕРШЕН: ожидаемое состояние 422 подтверждено.");
    }

    @Test
    @DisplayName("Отсутствует пароль в запросе")
    public void testWithoutPassword() {
        logger.info("ЗАПУСК ТЕСТА: Отсутствует пароль в запросе");

        User userWithoutPassword = UsersLogin.getUserWithValidLoginEmptyPassword();
        ValidatableResponse response = loginApi.getResponseForRequestWithData(userWithoutPassword);
        response.log().all();

        response.statusCode(422);
        response.body(
                "status", equalTo(422),
                "error.type", equalTo("ParamValidationError"));

        logger.info("ТЕСТ ЗАВЕРШЕН: ожидаемое состояние 422 подтверждено.");
    }

    @Test
    @DisplayName("Заданы корректные данные")
    public void testSuccessfulLogin() {
        logger.info("ЗАПУСК ТЕСТА: Заданы корректные данные");

        User validUser = UsersLogin.getValidUser();
        ValidatableResponse response = loginApi.getResponseForRequestWithData(validUser);
        response.log().all();

        response.statusCode(200);
        response.body(
                "status", equalTo(200));

        logger.info("ТЕСТ ЗАВЕРШЕН: ожидаемое состояние 200 подтверждено.");
    }

    @Test
    @DisplayName("Задан коррекный логин, некорректный пароль")
    public void testWithValidLogin() {
        logger.info("ЗАПУСК ТЕСТА: Задан коррекный логин, некорректный пароль");

        User userWithValidLogin = UsersLogin.getUserWithValidLoginInvalidPassword();
        ValidatableResponse response = loginApi.getResponseForRequestWithData(userWithValidLogin);
        response.log().all();

        response.statusCode(401);
        response.body(
                "status", equalTo(401),
                "error.type", equalTo("Unauthorized"));

        logger.info("ТЕСТ ЗАВЕРШЕН: ожидаемое состояние 401 подтверждено.");
    }

    @Test
    @DisplayName("Задан некоррекный логин, корректный пароль")
    public void testWithValidPassword() {
        logger.info("ЗАПУСК ТЕСТА: Задан некоррекный логин, корректный пароль");

        User userWithValidPassword = UsersLogin.getUserWithInvalidLoginValidPassword();
        ValidatableResponse response = loginApi.getResponseForRequestWithData(userWithValidPassword);
        response.log().all();

        response.statusCode(401);
        response.body(
                "status", equalTo(401),
                "error.type", equalTo("Unauthorized"));

        logger.info("ТЕСТ ЗАВЕРШЕН: ожидаемое состояние 401 подтверждено.");
    }
}
