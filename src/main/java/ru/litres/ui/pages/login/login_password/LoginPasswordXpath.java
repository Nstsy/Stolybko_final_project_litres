package ru.litres.ui.pages.login.login_password;

public class LoginPasswordXpath {
    public static final String INPUT_LOGIN_XPATH = "//input[@name='email']";
    public static final String EMPTY_LOGIN_MES_XPATH = "//div[contains(text(), 'Поле не может быть пустым')]";
    public static final String INVALID_LOGIN_MES_XPATH = "//div[contains(text(), 'Пользователь не найден, чтобы зарегистрироваться укажите почту')]";
    public static final String UNREG_LOGIN_MES_XPATH = "//h3[contains(text(), 'Создать профиль')]";

    public static final String BUTTON_CONTINUE_XPATH = "//div[contains(text(), 'Продолжить')]";
    public static final String INPUT_PASSWORD_XPATH = "//input[@name='pwd']";
    public static final String BUTTON_LOGIN_XPATH = "//div[contains(text(), 'Войти')]";
    public static final String EMPTY_PSW_MES_XPATH = "(//div[contains(text(), 'Введите пароль')])[2]";
    public static final String INVALID_LOGIN_OR_PSW_MES_XPATH = "//div[contains(text(), 'Неверное сочетание логина и пароля')]";

    public static final String BUTTON_CLOSE_XPATH = "//div[@class='ModalStep_closeButton__f7MqM']";
    public static final String TEXT_PROFILE_XPATH = "//div[contains(text(), 'Профиль')]";
}
