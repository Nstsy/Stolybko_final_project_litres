package ru.litres.ui.pages.login.phone;

import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.litres.enums.CountryCode;
import ru.litres.ui.driver.Driver;
import ru.litres.ui.driver.Wait;

import java.time.Duration;

public class PhonePage {
    private static final Logger logger = LogManager.getLogger();

    private final WebDriver driver;

    public PhonePage() {
        driver = Driver.getDriver();
    }

    @Step("Кликнуть по кнопке 'Номер телефона'")
    public PhonePage clickButtonNumberPhone() {
        logger.info("Клик по кнопке 'Номер телефона'.");
        driver.findElement(By.xpath(PhoneXpath.BUTTON_NUMBER_PHONE_XPATH)).click();
        return this;
    }

    @Step("Получить сообщение о пустом номере телефона")
    public String getEmptyPhoneMes() {
        String message = driver.findElement(By.xpath(PhoneXpath.EMPTY_PHONE_MES_XPATH)).getText();
        logger.info("Получено сообщение о пустом номере телефона: {}", message);
        return message;
    }

    @Step("Получить сообщение о невалидном номере телефона")
    public String getInvalidPhoneMes() {
        String message = driver.findElement(By.xpath(PhoneXpath.INVALID_PHONE_MES_XPATH)).getText();
        logger.info("Получено сообщение о невалидном номере телефона: {}", message);
        return message;
    }

    @Step("Получить сообщение о валидном номере телефона")
    public String getCorrectPhoneMes() {
        String message = driver.findElement(By.xpath(PhoneXpath.CORRECT_PHONE_MES_XPATH)).getText();
        logger.info("Получено сообщение о валидном номере телефона: {}", message);
        return message;
    }

    @Step("Получить сообщение о недоступной для регистрации стране")
    public String getUnavailableCountryMes() {
        String message = driver.findElement(By.xpath(PhoneXpath.UNAVAILABLE_COUNTRY_MES_XPATH)).getText();
        logger.info("Получено сообщение о недоступной стране: {}", message);
        return message;
    }

    @Step("Получить сообщение при выборе Абхазии и корректном номере телефона")
    public String getAbkhaziaCountryMes() {
        String message = driver.findElement(By.xpath(PhoneXpath.ABKHAZIA_COUNTRY_MES_XPATH)).getText();
        logger.info("Получено сообщение о корректном номере телефона для Абхазии: {}", message);
        return message;
    }

    @Step("Кликнуть по кнопке 'Продолжить'")
    public PhonePage clickButtonContinuePhone() {
        driver.findElement(By.xpath(PhoneXpath.BUTTON_CONTINUE_PHONE_XPATH)).click();
        logger.info("Кнопка 'Продолжить' нажата.");
        return this;
    }

    @Step("Заполнить номер телефона")
    public PhonePage fillPhone(String phone) {
        logger.info("Ввод номера телефона: {}", phone);

        WebElement phoneInput = Wait.getWaitDriver(5).
                until(ExpectedConditions.elementToBeClickable(By.xpath(PhoneXpath.INPUT_PHONE_XPATH)));
        enterPhoneNumber(phoneInput, phone);

        logger.info("Номер телефона введен.");
        return this;
    }

    private void enterPhoneNumber(WebElement phoneInput, String phone) {
        Wait.getWait(500L);
        clickElement(phoneInput);
        typePhoneNumber(phone);
    }

    private void clickElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
    }

    private void typePhoneNumber(String phone) {
        Actions actions = new Actions(driver);
        for (char c : phone.toCharArray()) {
            actions.sendKeys(String.valueOf(c)).perform();
            Wait.getWait(20L);}
    }

    @Step("Выбрать страну {country}")
    public PhonePage clickButtonChooseCountry(CountryCode country) {
        logger.info("Выбор страны: {}", country.name());

        String xpath = "//img[@alt='" + country.name().toLowerCase() + "']";
        Wait.getWaitDriver(5).until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))).click();
        return this;
    }

    @Step("Кликнуть по списку стран")
    public PhonePage clickCountryList() {
        logger.info("Клик по списку стран.");

        Wait.getWait(500L);
        WebElement countryList = driver.findElement(By.xpath(PhoneXpath.BUTTON_COUNTRY_XPATH));
        clickElement(countryList);

        logger.info("Список стран открыт.");
        return this;
    }
}
