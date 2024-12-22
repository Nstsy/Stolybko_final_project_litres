package ru.litres.ui.pages.home;

import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.litres.ui.driver.Driver;
import ru.litres.ui.pages.login.login_password.LoginPasswordXpath;

import java.util.Set;

public class HomePage {
    private static final Logger logger = LogManager.getLogger();

    private WebDriver driver;

    public HomePage() {
        driver = Driver.getDriver();
    }

    @Step("Кликнуть по кнопке 'Войти'")
    public HomePage clickButtonLogin() {
        logger.info("Клик по кнопке 'Войти'");
        driver.findElement(By.xpath(HomeXpath.BUTTON_LOGIN_XPATH)).click();
        return this;
    }

    @Step("Получить текст 'Профиль'")
    public String getTextProfile() {
        logger.info("Получение текста 'Профиль'");
        return driver.findElement(By.xpath(LoginPasswordXpath.TEXT_PROFILE_XPATH)).getText();
    }

    @Step("Ввести в поисковую строку '{book}'")
    public HomePage fillSearch(String book) {
        logger.info("Ввод в поисковую строку: {}", book);
        driver.findElement(By.xpath(HomeXpath.INPUT_SEARCH_XPATH)).sendKeys(book);
        return this;
    }

    @Step("Кликнуть по кнопке 'Найти'")
    public HomePage clickSearchButton() {
        logger.info("Клик по кнопке 'Найти'");
        driver.findElement(By.xpath(HomeXpath.BUTTON_SEARCH_XPATH)).click();
        return this;
    }

    @Step("Открыть первую книгу из результатов поиска")
    public HomePage clickOnBookFromSearch() {
        logger.info("Открытие первой книги из результатов поиска");
        driver.findElement(By.xpath(HomeXpath.FIRST_BOOK_SEARCH_XPATH)).click();
        getBookPage();
        return this;
    }

    @Step("Перейти на новую вкладку")
    private HomePage getBookPage() {
        logger.info("Переход на новую вкладку книги");
        String originalWindow;
        originalWindow = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        for (String handle : windowHandles) {
            if (!handle.equals(originalWindow)) {
                driver.switchTo().window(handle);
                break;
            }
        }
        return this;
    }
}
