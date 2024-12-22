package ru.litres.domain;

import com.github.javafaker.Faker;
import io.qameta.allure.Step;

public class UsersLogin {

    static Faker faker = new Faker();

    private static final String LOGIN_INVALID = faker.name().firstName() + "@belarus";
    private static final String LOGIN_UNREGISTERED = faker.internet().emailAddress();
    private static final String LOGIN_VALID = "nstsy@yandex.ru";

    private static final String PASSWORD_INVALID = faker.internet().password();
    private static final String PASSWORD_VALID = "testapi";

    private static final String EMPTY_FIELD = "";

    @Step("Создание пользователя с незарегистрированным логином.")
    public static User getUserWithUnregisteredLogin() {
        return new User()
                .setLogin(LOGIN_UNREGISTERED)
                .setPassword(EMPTY_FIELD);
    }

    @Step("Создание пользователя с пустыми полями логина и пароля.")
    public static User getUserWithEmptyLoginPassword() {
        return new User()
                .setLogin(EMPTY_FIELD)
                .setPassword(EMPTY_FIELD);
    }

    @Step("Создание пользователя с некорректным логином и паролем.")
    public static User getUserWithInvalidLoginPassword() {
        return new User()
                .setLogin(LOGIN_INVALID)
                .setPassword(PASSWORD_INVALID);
    }

    @Step("Создание пользователя с корректным логином и пустым паролем.")
    public static User getUserWithValidLoginEmptyPassword() {
        return new User()
                .setLogin(LOGIN_VALID)
                .setPassword(EMPTY_FIELD);
    }

    @Step("Создание пользователя с пустым логином и некорректным паролем.")
    public static User getUserWithEmptyLogin() {
        return new User()
                .setLogin(EMPTY_FIELD)
                .setPassword(PASSWORD_INVALID);
    }

    @Step("Создание валидного пользователя.")
    public static User getValidUser() {
        return new User()
                .setLogin(LOGIN_VALID)
                .setPassword(PASSWORD_VALID);
    }

    @Step("Создание пользователя с корректным логином и некорректным паролем.")
    public static User getUserWithValidLoginInvalidPassword() {
        return new User()
                .setLogin(LOGIN_VALID)
                .setPassword(PASSWORD_INVALID);
    }

    @Step("Создание пользователя с некорректным логином и корректным паролем.")
    public static User getUserWithInvalidLoginValidPassword() {
        return new User()
                .setLogin(LOGIN_INVALID)
                .setPassword(PASSWORD_VALID);
    }
}