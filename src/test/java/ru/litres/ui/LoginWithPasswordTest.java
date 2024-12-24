package ru.litres.ui;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.litres.domain.UsersLogin;
import ru.litres.ui.pages.login.login_password.LoginPasswordMessages;
import ru.litres.ui.pages.login.login_password.LoginPasswordPage;
import ru.litres.ui.steps.LoginPasswordStep;

@Epic("UI тесты")
@Feature("UI тесты формы логина при входе с логином и паролем")
public class LoginWithPasswordTest extends BaseUiTest {
    private LoginPasswordPage loginPasswordPage;
    private LoginPasswordStep loginPasswordStep;

    @BeforeEach
    public void setUp() {
        logger.info("Инициализация страницы лога с логином и паролем.");
        loginPasswordPage = new LoginPasswordPage();
        loginPasswordStep = new LoginPasswordStep();
    }

    @Test
    @DisplayName("Проверка сообщения при пустом логине")
    public void testEmptyLogin() {
        logger.info("ЗАПУСК ТЕСТА: Проверка сообщения при пустом логине");

        loginPasswordStep.fillLoginAndSubmit(UsersLogin.getUserWithEmptyLoginPassword());

        String expectedText = LoginPasswordMessages.EMPTY_LOGIN_MES;
        String actualText = loginPasswordPage.getEmptyLoginMes();
        Assertions.assertEquals(expectedText, actualText, "Неверное сообщение при пустом логине");

        logger.info("ТЕСТ ЗАВЕРШЕН: Проверка сообщения при пустом логине");
    }

    @Test
    @DisplayName("Проверка сообщения при некорректном логине")
    public void testInvalidLogin() {
        logger.info("ЗАПУСК ТЕСТА: Проверка сообщения при некорректном логине");

        loginPasswordStep.fillLoginAndSubmit(UsersLogin.getUserWithInvalidLoginPassword());

        String expectedText = LoginPasswordMessages.INVALID_LOGIN_MES;
        String actualText = loginPasswordPage.getInvalidLoginMes();
        Assertions.assertEquals(expectedText, actualText, "Неверное сообщение при невалидном логине");

        logger.info("ТЕСТ ЗАВЕРШЕН: Проверка сообщения при некорректном логине");
    }

    @Test
    @DisplayName("Проверка сообщения при незарегистрированном логине")
    public void testUnregisteredLogin() {
        logger.info("ЗАПУСК ТЕСТА: Проверка сообщения при незарегистрированном логине");
        loginPasswordStep.fillLoginAndSubmit(UsersLogin.getUserWithUnregisteredLogin());

        String expectedText = LoginPasswordMessages.UNREGISTERED_LOGIN_MES;
        String actualText = loginPasswordPage.getUnregisteredLoginMes();
        Assertions.assertEquals(expectedText, actualText, "Неверное сообщение при незарегистрированном логине");

        logger.info("ТЕСТ ЗАВЕРШЕН: проверка сообщения при незарегистрированном логине");
    }

    @Test
    @DisplayName("Проверка сообщения при пустом пароле")
    public void testEmptyPassword() {
        logger.info("ЗАПУСК ТЕСТА: Проверка сообщения при пустом пароле");

        loginPasswordStep.fillLoginPasswordAndSubmit(UsersLogin.getUserWithValidLoginEmptyPassword());

        String expectedText = LoginPasswordMessages.EMPTY_PWD_MES;
        String actualText = loginPasswordPage.getEmptyPwdMes();
        Assertions.assertEquals(expectedText, actualText, "Неверное сообщение при пустом пароле");

        logger.info("ТЕСТ ЗАВЕРШЕН: Проверка сообщения при пустом пароле");
    }

    @Test
    @DisplayName("Проверка сообщения при корректном логине, некорректном пароле")
    public void testInvalidCredentials() {
        logger.info("ЗАПУСК ТЕСТА: Проверка сообщения при корректном логине и некорректном пароле");

        loginPasswordStep.fillLoginPasswordAndSubmit(UsersLogin.getUserWithValidLoginInvalidPassword());

        String expectedText = LoginPasswordMessages.INVALID_LOGIN_OR_PWD_MES;
        String actualText = loginPasswordPage.getInvalidLoginOrPwdMes();
        Assertions.assertEquals(expectedText, actualText, "Неверное сообщение при некорректном логине или пароле");

        logger.info("ТЕСТ ЗАВЕРШЕН: Проверка сообщения при корректном логине и некорректном пароле");
    }

    @Test
    @DisplayName("Введены валидные данные логина и пароля")
    public void testValidCredentials() {
        logger.info("ЗАПУСК ТЕСТА: Проверка введенных валидных данных логина и пароля");

        loginPasswordStep.fillLoginPasswordAndSubmit(UsersLogin.getValidUser());
        loginPasswordPage.clickButtonClose();

        String expectedText = LoginPasswordMessages.TEXT_PROFILE;
        String actualText = homePage.getTextProfile();
        Assertions.assertEquals(expectedText, actualText, "Ожидается текст 'Профиль'");

        logger.info("ТЕСТ ЗАВЕРШЕН: Проверка введенных валидных данных логина и пароля");
    }
}
