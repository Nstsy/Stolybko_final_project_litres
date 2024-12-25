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
public class CartTest extends BaseUiTest {
    private static final Logger logger = LogManager.getLogger();
    private CartAddBookStep cartAddBookStep;

    @BeforeEach
    public void setUp() {
        cartAddBookStep = new CartAddBookStep();
    }

    @Test
    @DisplayName("Проверка добавления товара в корзину")
    public void testAddBookInCart() {
        logger.info("ЗАПУСК ТЕСТА: Проверка добавления товара в корзину");

        String book = "Гарри Поттер";
        cartAddBookStep
                .searchBook(book)
                .addBookInCart();

        Assertions.assertEquals(BookMessages.TEXT_BOOK_IN_CART, new BookPage().getBookInCartText(), "Ожидается текст 'В корзине Перейти'");

        logger.info("ТЕСТ ЗАВЕРШЕН: Проверка добавления товара в корзину");
    }

    @Test
    @DisplayName("Проверка удаления товара из корзины")
    public void testDeleteBookFromCart() {
        logger.info("ЗАПУСК ТЕСТА: Проверка удаления товара из корзины");

        String book = "Гарри Поттер";
        cartAddBookStep
                .searchBook(book)
                .addBookInCart()
                .deleteBookFromCart();

        Assertions.assertEquals(BookMessages.TEXT_EMPTY_CART, new BookPage().getTextEmptyCart(),
                "Ожидается текст 'Пустая корзина'");

        logger.info("ТЕСТ ЗАВЕРШЕН: Проверка удаления товара из корзины");
    }

    @AfterEach
    public void tearDown() {
        Driver.quit();
    }
}
