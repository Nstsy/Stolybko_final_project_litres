package ru.litres.ui;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.litres.domain.UsersWithLoginAndPassword;
import ru.litres.ui.pages.home.HomePage;
import ru.litres.ui.pages.login.login_password.LoginPasswordMessages;
import ru.litres.ui.pages.login.login_password.LoginPasswordPage;
import ru.litres.ui.steps.LoginPasswordStep;

@Epic("UI тесты")
@Feature("UI тесты формы логина при входе с логином и паролем")
public class LoginWithPasswordTest extends BaseUiTest {
    private LoginPasswordPage loginPasswordPage;
    private LoginPasswordStep loginPasswordStep;
    private HomePage homePage;

    @BeforeEach
    public void setUp() {
        logger.info("Инициализация страницы лога с логином и паролем.");
        loginPasswordPage = new LoginPasswordPage();
        loginPasswordStep = new LoginPasswordStep();
        homePage = new HomePage().clickButtonLogin();
    }

    @Test
    @DisplayName("Проверка сообщения при пустом логине")
    public void testEmptyLogin() {
        logger.info("ЗАПУСК ТЕСТА: Проверка сообщения при пустом логине");

        loginPasswordStep.fillLoginAndSubmit(UsersWithLoginAndPassword.getUserWithEmptyLoginPassword());
        Assertions.assertEquals(LoginPasswordMessages.EMPTY_LOGIN_MESSAGE, loginPasswordPage.getEmptyLoginMes(), "Неверное сообщение при пустом логине");

        logger.info("ТЕСТ ЗАВЕРШЕН: Проверка сообщения при пустом логине");
    }

    @Test
    @DisplayName("Проверка сообщения при некорректном логине")
    public void testInvalidLogin() {
        logger.info("ЗАПУСК ТЕСТА: Проверка сообщения при некорректном логине");

        loginPasswordStep.fillLoginAndSubmit(UsersWithLoginAndPassword.getUserWithInvalidLoginPassword());
        Assertions.assertEquals(LoginPasswordMessages.INVALID_LOGIN_MESSAGE, loginPasswordPage.getInvalidLoginMes(), "Неверное сообщение при невалидном логине");

        logger.info("ТЕСТ ЗАВЕРШЕН: Проверка сообщения при некорректном логине");
    }

    @Test
    @DisplayName("Проверка сообщения при незарегистрированном логине")
    public void testUnregisteredLogin() {
        logger.info("ЗАПУСК ТЕСТА: Проверка сообщения при незарегистрированном логине");

        loginPasswordStep.fillLoginAndSubmit(UsersWithLoginAndPassword.getUserWithUnregisteredLogin());
        Assertions.assertEquals(LoginPasswordMessages.UNREGISTERED_LOGIN_MESSAGE, loginPasswordPage.getUnregisteredLoginMes(), "Неверное сообщение при незарегистрированном логине");

        logger.info("ТЕСТ ЗАВЕРШЕН: проверка сообщения при незарегистрированном логине");
    }

    @Test
    @DisplayName("Проверка сообщения при пустом пароле")
    public void testEmptyPassword() {
        logger.info("ЗАПУСК ТЕСТА: Проверка сообщения при пустом пароле");

        loginPasswordStep.fillLoginPasswordAndSubmit(UsersWithLoginAndPassword.getUserWithValidLoginEmptyPassword());
        Assertions.assertEquals(LoginPasswordMessages.EMPTY_PWD_MESSAGE, loginPasswordPage.getEmptyPwdMes(),
                "Неверное сообщение при пустом пароле");

        logger.info("ТЕСТ ЗАВЕРШЕН: Проверка сообщения при пустом пароле");
    }

    @Test
    @DisplayName("Проверка сообщения при корректном логине, некорректном пароле")
    public void testInvalidCredentials() {
        logger.info("ЗАПУСК ТЕСТА: Проверка сообщения при корректном логине и некорректном пароле");

        loginPasswordStep.fillLoginPasswordAndSubmit(UsersWithLoginAndPassword.getUserWithValidLoginInvalidPassword());
        Assertions.assertEquals(LoginPasswordMessages.INVALID_LOGIN_OR_PWD_MESSAGE, loginPasswordPage.getInvalidLoginOrPwdMes(), "Неверное сообщение при некорректном логине или пароле");

        logger.info("ТЕСТ ЗАВЕРШЕН: Проверка сообщения при корректном логине и некорректном пароле");
    }

    @Test
    @DisplayName("Введены валидные данные логина и пароля")
    public void testValidCredentials() {
        logger.info("ЗАПУСК ТЕСТА: Проверка введенных валидных данных логина и пароля");

        loginPasswordStep.fillLoginPasswordAndSubmit(UsersWithLoginAndPassword.getValidUser());
        loginPasswordPage.clickButtonClose();

        Assertions.assertEquals(LoginPasswordMessages.TEXT_PROFILE, homePage.getTextProfile(), "Ожидается текст 'Профиль'");

        logger.info("ТЕСТ ЗАВЕРШЕН: Проверка введенных валидных данных логина и пароля");
    }
}
