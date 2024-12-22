package ru.litres.ui.steps;

import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.litres.domain.User;
import ru.litres.ui.pages.login.phone.PhonePage;

public class LoginWithPhoneStep {
    private static final Logger logger = LogManager.getLogger();
    private PhonePage phonePage;

    public LoginWithPhoneStep(PhonePage phonePage) {
        this.phonePage = phonePage;
    }

    @Step("Заполнить номер телефона и кликнуть 'Продолжить'")
    public void fillPhoneAndClickContinue(User user) {
        phonePage
                .fillPhone(user.getPhone())
                .clickButtonContinuePhone();
    }

    @Step("Выбрать страну и заполнить номер телефона, кликнуть 'Продолжить'")
    public void chooseCountryAndfillPhone(User user) {
        phonePage
                .clickCountryList()
                .clickButtonChooseCountry(user.getCode());
        fillPhoneAndClickContinue(user);
    }
}
