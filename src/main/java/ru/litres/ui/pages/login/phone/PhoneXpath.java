package ru.litres.ui.pages.login.phone;

public class PhoneXpath {
    public static final String BUTTON_NUMBER_PHONE_XPATH = "//div[contains(text(), 'Номер телефона')]";
    public static final String INPUT_PHONE_XPATH = "//div[@class='PhoneInput_phoneInput__input__placeholder__bRCf_']";
    public static final String EMPTY_PHONE_MES_XPATH = "//div[contains(text(), 'Номер введён не полностью')]";
    public static final String INVALID_PHONE_MES_XPATH = "//div[@class='Alert_alert__description__ddXvB']";
    public static final String CORRECT_PHONE_MES_XPATH = "//h3[contains(text(), 'Ввести пароль')]";
    public static final String BUTTON_CONTINUE_PHONE_XPATH = "//div[contains(text(), 'Продолжить')]";

    public static final String BUTTON_COUNTRY_XPATH = "//a[@class='PhoneInput_phoneInput__pick__tZBez']";

    public static final String UNAVAILABLE_COUNTRY_MES_XPATH = "//div[@class='ControlInput_input__error__0DtKl']";
    public static final String ABKHAZIA_COUNTRY_MES_XPATH = "//h3[contains(text(), 'Ввести код')]";
}
