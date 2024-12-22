package ru.litres.ui.steps;

import io.qameta.allure.Step;
import ru.litres.domain.User;
import ru.litres.ui.pages.login.login_password.LoginPasswordPage;

public class LoginPasswordStep {
    @Step("Заполнить логин и пароль и кликнуть 'Войти'")
    public void fillLoginPasswordAndSubmit(User user) {
        LoginPasswordPage loginPasswordPage = new LoginPasswordPage();
        fillLoginAndSubmit(user);
        loginPasswordPage
                .fillPassword(user.getPassword())
                .clickButtonLogin();
    }

    @Step("Заполнить логин и кликнуть 'Продолжить'")
    public void fillLoginAndSubmit(User user) {
        LoginPasswordPage loginPasswordPage = new LoginPasswordPage();
        loginPasswordPage
                .fillLogin(user.getLogin())
                .clickButtonContinue();
    }
}
