package ru.litres.ui.pages.book;

public class BookXpath {
    public static final String BUTTON_ADD_CART_XPATH = "//div[contains(text(), 'Добавить в корзину')]";
    public static final String BUTTON_CLOSE_MODAL_XPATH = "//div[@aria-label='Закрыть']";
    public static final String TEXT_BOOK_IN_CART_XPATH = "//div[contains(text(), 'В корзине')]";
    public static final String BUTTON_CART_XPATH = "//div[@data-testid='tab-basket']";
    public static final String BUTTON_DELETE_XPATH = "//button[@data-testid='cart__listDeleteButton']";
    public static final String BUTTON_CONFIRM_DELETE_XPATH = "(//div[contains(text(), 'Удалить')])[2]";
    public static final String TEXT_EMPTY_CART_XPATH = "//h2[contains(text(), 'Корзина пуста')]";
}
