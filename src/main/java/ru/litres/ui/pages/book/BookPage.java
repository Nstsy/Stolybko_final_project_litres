package ru.litres.ui.pages.book;

import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.litres.ui.driver.Driver;

public class BookPage {
    private WebDriver driver;
    private static final Logger logger = LogManager.getLogger();

    public BookPage() {
        driver = Driver.getDriver();
    }

    @Step("Кликнуть по кнопке 'Добавить в корзину'")
    public BookPage addBookToCart() {
        logger.info("Клик по кнопке 'Добавить в корзину'");
        driver.findElement(By.xpath(BookXpath.BUTTON_ADD_CART_XPATH)).click();
        logger.info("Книга успешно добавлена в корзину.");
        return this;
    }

    @Step("Получить текст о том, что товар добавлен в корзину")
    public String getBookInCartText() {
        logger.info("Получение текста о том, что книга добавлена в корзину.");
        String text = driver.findElement(By.xpath(BookXpath.TEXT_BOOK_IN_CART_XPATH)).getText();
        logger.info("Текст о добавлении в корзину: {}", text);
        return text;
    }

    @Step("Закрыть модальное окно")
    public BookPage clickButtonClose() {
        logger.info("Закрытие модального окна.");
        driver.findElement(By.xpath(BookXpath.BUTTON_CLOSE_MODAL_XPATH)).click();
        return this;
    }

    @Step("Кликнуть по кнопке 'Корзина'")
    public BookPage clickButtonCart() {
        logger.info("Клик по кнопке 'Корзина'");
        driver.findElement(By.xpath(BookXpath.BUTTON_CART_XPATH)).click();
        logger.info("Открыта страница 'Корзина'.");
        return this;
    }

    @Step("Кликнуть по кнопке 'Удалить'")
    public BookPage clickButtonDelete() {
        logger.info("Клик по кнопке 'Удалить'");
        driver.findElement(By.xpath(BookXpath.BUTTON_DELETE_XPATH)).click();
        return this;
    }

    @Step("Кликнуть по кнопке 'Удалить' повторно")
    public BookPage clickButtonDeleteConfirm() {
        logger.info("Клик по кнопке 'Удалить' повторно");
        driver.findElement(By.xpath(BookXpath.BUTTON_CONFIRM_DELETE_XPATH)).click();
        logger.info("Книга успешно удалена из корзины.");
        return this;
    }

    @Step("Получить текст 'Пустая корзина'")
    public String getTextEmptyCart() {
        logger.info("Получение текста о пустой корзине.");
        String text = driver.findElement(By.xpath(BookXpath.TEXT_EMPTY_CART_XPATH)).getText();
        logger.info("Текст о пустой корзине: {}", text);
        return text;
    }
}
