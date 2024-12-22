package ru.litres.ui.pages.login.login_password;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.litres.ui.driver.Driver;

public class LoginPasswordPage {

    private final WebDriver driver;

    public LoginPasswordPage() {
        driver = Driver.getDriver();
    }

    @Step("Заполнить поле логин")
    public LoginPasswordPage fillLogin(String login) {
        driver.findElement(By.xpath(LoginPasswordXpath.INPUT_LOGIN_XPATH)).sendKeys(login);
        return this;
    }

    @Step("Кликнуть по кнопке 'Продолжить'")
    public LoginPasswordPage clickButtonContinue() {
        driver.findElement(By.xpath(LoginPasswordXpath.BUTTON_CONTINUE_XPATH)).click();
        return this;
    }

    @Step("Заполнить поле пароль")
    public LoginPasswordPage fillPassword(String password) {
        driver.findElement(By.xpath(LoginPasswordXpath.INPUT_PASSWORD_XPATH)).sendKeys(password);
        return this;
    }

    @Step("Кликнуть по кнопке 'Войти'")
    public LoginPasswordPage clickButtonLogin() {
        driver.findElement(By.xpath(LoginPasswordXpath.BUTTON_LOGIN_XPATH)).click();
        return this;
    }

    @Step("Получить сообщение при пустом пароле")
    public String getEmptyPwdMes() {
        return driver.findElement(By.xpath(LoginPasswordXpath.EMPTY_PSW_MES_XPATH)).getText();
    }

    @Step("Получить сообщение при пустом логине")
    public String getEmptyLoginMes() {
        return driver.findElement(By.xpath(LoginPasswordXpath.EMPTY_LOGIN_MES_XPATH)).getText();
    }

    @Step("Получить сообщение при невалидном логине")
    public String getInvalidLoginMes() {
        return driver.findElement(By.xpath(LoginPasswordXpath.INVALID_LOGIN_MES_XPATH)).getText();
    }

    @Step("Получить сообщение при неверном логине или пароле")
    public String getInvalidLoginOrPwdMes() {
        return driver.findElement(By.xpath(LoginPasswordXpath.INVALID_LOGIN_OR_PSW_MES_XPATH)).getText();
    }

    @Step("Получить сообщение при незарегистрированном логине")
    public String getUnregisteredLoginMes() {
        return driver.findElement(By.xpath(LoginPasswordXpath.UNREG_LOGIN_MES_XPATH)).getText();
    }

    @Step("Закрыть модальное окно")
    public LoginPasswordPage clickButtonClose() {
        driver.findElement(By.xpath(LoginPasswordXpath.BUTTON_CLOSE_XPATH)).click();
        return this;
    }
}
