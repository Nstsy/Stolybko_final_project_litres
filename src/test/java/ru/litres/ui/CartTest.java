package ru.litres.ui;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import ru.litres.ui.driver.Driver;
import ru.litres.ui.pages.book.BookMessages;
import ru.litres.ui.pages.book.BookPage;
import ru.litres.ui.steps.CartAddBookStep;

@Epic("UI тесты")
@Feature("UI тест добавления и удаления товара из корзины")
public class CartTest {
    private static final Logger logger = LogManager.getLogger();
    private CartAddBookStep cartAddBookStep;

    @BeforeEach
    public void setUp() {
        logger.info("Инициализация драйвера и переход на главную страницу.");
        WebDriver driver = Driver.getDriver();
        driver.get("https://www.litres.ru/");
        cartAddBookStep = new CartAddBookStep();
    }

    @Test
    @DisplayName("Проверка формы поиска и добавления товара в корзину")
    public void testAddBookInCart() {
        logger.info("ЗАПУСК ТЕСТА: Проверка формы поиска и добавления товара в корзину");

        cartAddBookStep.searchBook()
                .addBookInCart();

        String expectedText = BookMessages.TEXT_BOOK_IN_CART;
        String actualText = new BookPage().getBookInCartText();
        Assertions.assertEquals(expectedText, actualText, "Ожидается текст 'В корзине Перейти'");

        logger.info("ТЕСТ ЗАВЕРШЕН: Проверка формы поиска и добавления товара в корзину");
    }

    @Test
    @DisplayName("Проверка удаления товара из корзины")
    public void testDeleteBookFromCart() {
        logger.info("ЗАПУСК ТЕСТА: Проверка удаления товара из корзины");

        cartAddBookStep.searchBook()
                .addBookInCart()
                .deleteBookFromCart();

        String expectedText = BookMessages.TEXT_EMPTY_CART;
        String actualText = new BookPage().getTextEmptyCart();
        Assertions.assertEquals(expectedText, actualText, "Ожидается текст 'Пустая корзина'");

        logger.info("ТЕСТ ЗАВЕРШЕН: Проверка удаления товара из корзины");
    }

    @AfterEach
    public void tearDown() {
        Driver.quit();
    }
}
