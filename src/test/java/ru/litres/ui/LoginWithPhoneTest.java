package ru.litres.ui;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import ru.litres.domain.UsersWithPhoneAndCountryCode;
import ru.litres.ui.pages.home.HomePage;
import ru.litres.ui.pages.login.phone.PhoneMessages;
import ru.litres.ui.pages.login.phone.PhonePage;
import ru.litres.ui.steps.LoginWithPhoneStep;

@Epic("UI тесты")
@Feature("UI тесты формы логина при входе с номером телефона")
public class LoginWithPhoneTest extends BaseUiTest {
    private PhonePage phonePage;
    private LoginWithPhoneStep loginWithPhoneStep;
    private HomePage homePage;

    @BeforeEach
    public void setUp() {
        logger.info("Настройка тестовой среды.");
        homePage = new HomePage().clickButtonLogin();
        phonePage = new PhonePage().clickButtonNumberPhone();
        loginWithPhoneStep = new LoginWithPhoneStep(phonePage);
    }

    @Test
    @DisplayName("Проверка сообщения при пустом номере телефона, любая страна")
    public void testEmptyPhoneNumber() {
        logger.info("ЗАПУСК ТЕСТА: Проверка сообщения при пустом номере телефона.");

        loginWithPhoneStep.fillPhoneAndClickContinue(UsersWithPhoneAndCountryCode.getUserWithoutPhone());
        Assertions.assertEquals(PhoneMessages.EMPTY_PHONE_MESSAGE, phonePage.getEmptyPhoneMes(), "Неверное сообщение при пустом номере телефона");

        logger.info("ТЕСТ ЗАВЕРШЕН: Проверка сообщения при пустом номере телефона.");
    }

    @Test
    @DisplayName("Проверка сообщения при некорректном номере телефона")
    public void testIncorrectPhoneNumber() {
        logger.info("ЗАПУСК ТЕСТА: Проверка сообщения при некорректном номере телефона.");

        loginWithPhoneStep.fillPhoneAndClickContinue(UsersWithPhoneAndCountryCode.getUserWithInvalidCodePhone());
        Assertions.assertEquals(PhoneMessages.INVALID_PHONE_MESSAGE, phonePage.getInvalidPhoneMes(), "Неверное сообщение при некорректном номере телефона");

        logger.info("ТЕСТ ЗАВЕРШЕН: Проверка сообщения при некорректном номере телефона.");
    }

    @Test
    @DisplayName("Проверка сообщения при корректном номере телефона, Россия")
    public void testCorrectPhoneNumber() {
        logger.info("ЗАПУСК ТЕСТА: Проверка сообщения при корректном номере телефона, Россия.");

        loginWithPhoneStep.fillPhoneAndClickContinue(UsersWithPhoneAndCountryCode.getValidUserCodePhoneRU());
        Assertions.assertEquals(PhoneMessages.CORRECT_PHONE_MESSAGE, phonePage.getCorrectPhoneMes(), "Неверное сообщение при корректном номере телефона");

        logger.info("ТЕСТ ЗАВЕРШЕН: Проверка сообщения при корректном номере телефона, Россия.");
    }

    @Test
    @DisplayName("Проверка сообщения при корректном номере телефона, Абхазия")
    public void testAbkhaziaCorrectPhone() {
        logger.info("ЗАПУСК ТЕСТА: Проверка сообщения при корректном номере телефона, Абхазия.");

        loginWithPhoneStep.chooseCountryAndfillPhone(UsersWithPhoneAndCountryCode.getValidUserCodePhoneAB());
        Assertions.assertEquals(PhoneMessages.ABKHAZIA_COUNTRY_MESSAGE, phonePage.getAbkhaziaCountryMes(), "Неверное сообщение при корректном номере телефона и выборе Абхазии");

        logger.info("ТЕСТ ЗАВЕРШЕН: Проверка сообщения при корректном номере телефона, Абхазия.");
    }

    @Test
    @DisplayName("Проверка сообщения при корректном номере телефона, но недоступной стране")
    public void testUnavailableCountryCorrectPhone() {
        logger.info("ЗАПУСК ТЕСТА: Проверка сообщения при корректном номере телефона, но недоступной стране.");

        loginWithPhoneStep.chooseCountryAndfillPhone(UsersWithPhoneAndCountryCode.getValidUserCodePhoneBY());
        Assertions.assertEquals(PhoneMessages.UNAVAILABLE_COUNTRY_MESSAGE, phonePage.getUnavailableCountryMes(), "Неверное сообщение при недоступной для регистрации стране");

        logger.info("ТЕСТ ЗАВЕРШЕН: Проверка сообщения при корректном номере телефона, но недоступной стране.");
    }
}
