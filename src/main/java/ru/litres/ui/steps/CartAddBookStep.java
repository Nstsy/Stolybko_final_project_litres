package ru.litres.ui.steps;

import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.litres.ui.pages.book.BookPage;
import ru.litres.ui.pages.home.HomePage;

public class CartAddBookStep {
    private static final Logger logger = LogManager.getLogger();

    @Step("Найти книгу через поисковую строку")
    public CartAddBookStep searchBook(String book) {
        logger.info("Поиск книги: {}", book);
        new HomePage()
                .fillSearch(book)
                .clickSearchButton()
                .clickOnBookFromSearch();
        return this;
    }

    @Step("Добавить книгу в корзину")
    public CartAddBookStep addBookInCart() {
        logger.info("Добавление книги в корзину...");
        new BookPage()
                .addBookToCart()
                .clickButtonClose();
        return this;
    }

    @Step("Удалить книгу из корзины")
    public CartAddBookStep deleteBookFromCart() {
        logger.info("Удаление книги из корзины...");
        new BookPage()
                .clickButtonCart()
                .clickButtonDelete()
                .clickButtonDeleteConfirm();
        return this;
    }
}