package ru.litres.ui.pages.login.phone;

import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.litres.enums.CountryCode;
import ru.litres.ui.driver.Driver;

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

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement phoneInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(PhoneXpath.INPUT_PHONE_XPATH)));
        try {
            Thread.sleep(1000L);
            Actions actions = new Actions(driver);
            actions.moveToElement(phoneInput).click().perform();
            for (char c : phone.toCharArray()) {
                actions.sendKeys(String.valueOf(c)).perform();
                Thread.sleep(20L);
            }
        } catch (InterruptedException e) {
            logger.error("Ошибка при вводе номера.");
            throw new RuntimeException(e);
        }

        logger.info("Номер телефона успешно введен.");
        return this;
    }

    @Step("Выбрать страну {country}")
    public PhonePage clickButtonChooseCountry(CountryCode country) {
        logger.info("Выбор страны: {}", country.name());

        String xpath = "//img[@alt='" + country.name().toLowerCase() + "']";
        WebElement countryElement = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        countryElement.click();

        logger.info("Страна {} выбрана.", country.name());
        return this;
    }

    @Step("Кликнуть по списку стран")
    public PhonePage clickCountryList() {
        logger.info("Клик по списку стран.");

        try {
            Thread.sleep(500L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement countryList = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PhoneXpath.BUTTON_COUNTRY_XPATH)));
        Actions actions = new Actions(driver);
        actions.moveToElement(countryList).click().perform();

        logger.info("Список стран открыт.");
        return this;
    }
}
