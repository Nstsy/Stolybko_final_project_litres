package ru.litres.domain;

import io.qameta.allure.Step;
import ru.litres.enums.CountryCode;

public class UsersWithPhoneAndCountryCode {
    private static final String PHONE_INVALID = "0000000000";
    private static final String PHONE_VALID_BY = "292309010";
    private static final String PHONE_VALID_AB = "999999";
    private static final String PHONE_VALID_RU = "9999999999";
    private static final String PHONE_EMPTY = "";

    @Step("Создание пользователя с пустым кодом страны и пустым номером телефона.")
    public static User getUserWithEmptyCodePhone() {
        return new User()
                .setPhone(PHONE_EMPTY)
                .setCode(CountryCode.EMPTY);
    }

    @Step("Создание пользователя с некорректным номером телефона и неверным кодом страны.")
    public static User getUserWithInvalidCodePhone() {
        return new User()
                .setPhone(PHONE_INVALID)
                .setCode(CountryCode.INVALID);
    }

    @Step("Создание пользователя без указанного кода страны.")
    public static User getUserWithoutCode() {
        return new User()
                .setPhone(PHONE_INVALID)
                .setCode(CountryCode.EMPTY);
    }

    @Step("Создание пользователя без указанного номера телефона.")
    public static User getUserWithoutPhone() {
        return new User()
                .setPhone(PHONE_EMPTY)
                .setCode(CountryCode.INVALID);
    }

    @Step("Создание пользователя с неверным номером телефона и корректным кодом.")
    public static User getUserWithValidCode() {
        return new User()
                .setPhone(PHONE_INVALID)
                .setCode(CountryCode.AB);
    }

    @Step("Создание пользователя с корректным номером телефона и неверным кодом страны.")
    public static User getUserWithValidPhone() {
        return new User()
                .setPhone(PHONE_VALID_BY)
                .setCode(CountryCode.INVALID);
    }

    @Step("Создание пользователя с валидным номером телефона и кодом страны AB.")
    public static User getValidUserCodePhoneAB() {
        return new User()
                .setPhone(PHONE_VALID_AB)
                .setCode(CountryCode.AB);
    }

    @Step("Создание пользователя с валидным номером телефона и кодом страны BY.")
    public static User getValidUserCodePhoneBY() {
        return new User()
                .setPhone(PHONE_VALID_BY)
                .setCode(CountryCode.BY);
    }

    @Step("Создание пользователя с валидным номером телефона и кодом страны RU.")
    public static User getValidUserCodePhoneRU() {
        return new User()
                .setPhone(PHONE_VALID_RU)
                .setCode(CountryCode.RU);
    }
}
