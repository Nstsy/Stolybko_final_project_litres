package ru.litres.ui;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.litres.domain.UsersPhone;
import ru.litres.ui.pages.login.phone.PhoneMessages;
import ru.litres.ui.pages.login.phone.PhonePage;
import ru.litres.ui.steps.LoginWithPhoneStep;

@Epic("UI тесты")
@Feature("UI тесты формы логина при входе с номером телефона")
public class LoginWithPhoneTest extends BaseUiTest {
    private PhonePage phonePage;
    private LoginWithPhoneStep loginWithPhoneStep;

    @BeforeEach
    public void setUp() {
        logger.info("Настройка тестовой среды.");
        phonePage = new PhonePage();
        phonePage.clickButtonNumberPhone();
        loginWithPhoneStep = new LoginWithPhoneStep(phonePage);
    }

    @Test
    @DisplayName("Проверка сообщения при пустом номере телефона, любая страна")
    public void testEmptyPhoneNumber() {
        logger.info("ЗАПУСК ТЕСТА: Проверка сообщения при пустом номере телефона.");

        loginWithPhoneStep.fillPhoneAndClickContinue(UsersPhone.getUserWithoutPhone());

        String expectedText = PhoneMessages.EMPTY_PHONE_MES;
        String actualText = phonePage.getEmptyPhoneMes();
        Assertions.assertEquals(expectedText, actualText, "Неверное сообщение при пустом номере телефона");

        logger.info("ТЕСТ ЗАВЕРШЕН: Проверка сообщения при пустом номере телефона.");
    }

    @Test
    @DisplayName("Проверка сообщения при некорректном номере телефона")
    public void testIncorrectPhoneNumber() {
        logger.info("ЗАПУСК ТЕСТА: Проверка сообщения при некорректном номере телефона.");

        loginWithPhoneStep.fillPhoneAndClickContinue(UsersPhone.getUserWithInvalidCodePhone());

        String expectedText = PhoneMessages.INVALID_PHONE_MES;
        String actualText = phonePage.getInvalidPhoneMes();
        Assertions.assertEquals(expectedText, actualText, "Неверное сообщение при некорректном номере телефона");

        logger.info("ТЕСТ ЗАВЕРШЕН: Проверка сообщения при некорректном номере телефона.");
    }

    @Test
    @DisplayName("Проверка сообщения при корректном номере телефона, Россия")
    public void testCorrectPhoneNumber() {
        logger.info("ЗАПУСК ТЕСТА: Проверка сообщения при корректном номере телефона, Россия.");

        loginWithPhoneStep.fillPhoneAndClickContinue(UsersPhone.getValidUserCodePhoneRU());

        String expectedText = PhoneMessages.CORRECT_PHONE_MES;
        String actualText = phonePage.getCorrectPhoneMes();
        Assertions.assertEquals(expectedText, actualText, "Неверное сообщение при корректном номере телефона");

        logger.info("ТЕСТ ЗАВЕРШЕН: Проверка сообщения при корректном номере телефона, Россия.");
    }

    @Test
    @DisplayName("Проверка сообщения при корректном номере телефона, Абхазия")
    public void testAbkhaziaCorrectPhone() {
        logger.info("ЗАПУСК ТЕСТА: Проверка сообщения при корректном номере телефона, Абхазия.");

        loginWithPhoneStep.chooseCountryAndfillPhone(UsersPhone.getValidUserCodePhoneAB());

        String expectedText = PhoneMessages.ABKHAZIA_COUNTRY_MES;
        String actualText = phonePage.getAbkhaziaCountryMes();
        Assertions.assertEquals(expectedText, actualText, "Неверное сообщение при корректном номере телефона и выборе Абхазии");

        logger.info("ТЕСТ ЗАВЕРШЕН: Проверка сообщения при корректном номере телефона, Абхазия.");
    }

    @Test
    @DisplayName("Проверка сообщения при корректном номере телефона, но недоступной стране")
    public void testUnavailableCountryCorrectPhone() {
        logger.info("ЗАПУСК ТЕСТА: Проверка сообщения при корректном номере телефона, но недоступной стране.");

        loginWithPhoneStep.chooseCountryAndfillPhone(UsersPhone.getValidUserCodePhoneBY());

        String expectedText = PhoneMessages.UNAVAILABLE_COUNTRY_MES;
        String actualText = phonePage.getUnavailableCountryMes();
        Assertions.assertEquals(expectedText, actualText, "Неверное сообщение при недоступной для регистрации стране");

        logger.info("ТЕСТ ЗАВЕРШЕН: Проверка сообщения при корректном номере телефона, но недоступной стране.");
    }
}
