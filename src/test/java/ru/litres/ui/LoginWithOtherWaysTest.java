package ru.litres.ui;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.litres.ui.pages.home.HomePage;
import ru.litres.ui.pages.login.otherways.OtherWaysMessages;
import ru.litres.ui.pages.login.otherways.OtherWaysPage;

@Epic("UI тесты")
@Feature("UI тесты формы логина при входе другими способами")
public class LoginWithOtherWaysTest extends BaseUiTest {
    private OtherWaysPage otherWaysPage;
    private HomePage homePage;

    @BeforeEach
    public void setUp() {
        logger.info("Переход на страницу 'Другие способы входа'.");
        homePage = new HomePage().clickButtonLogin();
        otherWaysPage=new OtherWaysPage().clickButtonOtherWays();
    }

    @Test
    @DisplayName("Проверка корректности названия блока 'Другие способы'")
    public void testOtherWaysTitle() {
        logger.info("ЗАПУСК ТЕСТА: Проверка корректности названия блока 'Другие способы'");

        Assertions.assertEquals(OtherWaysMessages.TEXT_OTHER_WAYS, otherWaysPage.getOtherWaysText(), "Название блока 'Другие способы' отображается некорректно");

        logger.info("ТЕСТ ЗАВЕРШЕН: Проверка корректности названия блока 'Другие способы'");
    }

    @Test
    @DisplayName("Проверка работы ссылки 'Публичная оферта'")
    public void testPublicOfferLink() {
        logger.info("ЗАПУСК ТЕСТА: Проверка работы ссылки 'Публичная оферта'");

        otherWaysPage.clickButtonLitresOferta();
        Assertions.assertEquals(OtherWaysMessages.TEXT_LITRES_OFERTA, otherWaysPage.getLitresOfertaText(), "Переход по ссылке 'Публичная оферта' некорректен");

        logger.info("ТЕСТ ЗАВЕРШЕН: Проверка работы ссылки 'Публичная оферта'");
    }

    @Test
    @DisplayName("Проверка работы ссылки 'Политика обработки персональных данных'")
    public void testPrivacyPolicyLink() {
        logger.info("ЗАПУСК ТЕСТА: Проверка работы ссылки 'Политика обработки персональных данных'");

        otherWaysPage.clickButtonPrivacyPolicy();
        Assertions.assertEquals(OtherWaysMessages.TEXT_PRIVACY_POLICY, otherWaysPage.getPrivacyPolicyText(), "Переход по ссылке 'Политика обработки персональных данных' некорректен");

        logger.info("ТЕСТ ЗАВЕРШЕН: Проверка работы ссылки 'Политика обработки персональных данных'");
    }

    @Test
    @DisplayName("Проверка наличия логотипов социальных сетей")
    public void testSocialMediaLogosDisplayed() {
        logger.info("ЗАПУСК ТЕСТА: Проверка наличия логотипов социальных сетей");

        Assertions.assertTrue(otherWaysPage.checkLogoSocialsLinks(), "Не все логотипы социальных сетей отображаются");

        logger.info("ТЕСТ ЗАВЕРШЕН: Проверка наличия логотипов социальных сетей");
    }

    @Test
    @DisplayName("Проверка работы кнопки 'Приложение Литрес'")
    public void testLitresAppButton() {
        logger.info("ЗАПУСК ТЕСТА: Проверка работы кнопки 'Приложение Литрес'");

        otherWaysPage.clickButtonLitresApp();
        Assertions.assertEquals(OtherWaysMessages.TEXT_LITRES_APP, otherWaysPage.getLitresAppText(), "Переход по ссылке 'Приложение Литрес' некорректно");

        logger.info("ТЕСТ ЗАВЕРШЕН: Проверка работы кнопки 'Приложение Литрес'");
    }

    @Test
    @DisplayName("Проверка работы кнопки 'Google'")
    public void testGoogleLogoLink() {
        logger.info("ЗАПУСК ТЕСТА: Проверка работы кнопки 'Google'");

        otherWaysPage.clickButtonGoogle();
        String currentUrl = otherWaysPage.getCurrentUrl();
        Assertions.assertTrue(currentUrl.contains("google.com"), "Пользователь не перенаправлен на сайт Google.");

        logger.info("ТЕСТ ЗАВЕРШЕН: Проверка работы кнопки 'Google'");
    }

    @Test
    @DisplayName("Проверка работы кнопки 'Yandex'")
    public void testYandexLogoLink() {
        logger.info("ЗАПУСК ТЕСТА: Проверка работы кнопки 'Yandex'");

        otherWaysPage.clickButtonYandex();
        String currentUrl = otherWaysPage.getCurrentUrl();
        Assertions.assertTrue(currentUrl.contains("yandex.ru"), "Пользователь не перенаправлен на сайт Yandex.");

        logger.info("ТЕСТ ЗАВЕРШЕН: Проверка работы кнопки 'Yandex'");
    }

    @Test
    @DisplayName("Проверка работы кнопки 'Вконтакте'")
    public void testVkLogoLink() {
        logger.info("ЗАПУСК ТЕСТА: Проверка работы кнопки 'Вконтакте'");

        otherWaysPage.clickButtonVk();
        String currentUrl = otherWaysPage.getCurrentUrl();
        Assertions.assertTrue(currentUrl.contains("vk.com"), "Пользователь не перенаправлен на сайт Вконтакте.");

        logger.info("ТЕСТ ЗАВЕРШЕН: Проверка работы кнопки 'Вконтакте'");
    }

    @Test
    @DisplayName("Проверка работы кнопки 'Одноклассники'")
    public void testOkLogoLink() {
        logger.info("ЗАПУСК ТЕСТА: Проверка работы кнопки 'Одноклассники'");

        otherWaysPage.clickButtonOk();
        String currentUrl = otherWaysPage.getCurrentUrl();
        Assertions.assertTrue(currentUrl.contains("ok.ru"), "Пользователь не перенаправлен на сайт Одноклассники.");

        logger.info("ТЕСТ ЗАВЕРШЕН: Проверка работы кнопки 'Одноклассники'");
    }

    @Test
    @DisplayName("Проверка работы кнопки 'Сбербанк'")
    public void testSberLogoLink() {
        logger.info("ЗАПУСК ТЕСТА: Проверка работы кнопки 'Сбербанк'");

        otherWaysPage.clickButtonSb();
        String currentUrl = otherWaysPage.getCurrentUrl();
        Assertions.assertTrue(currentUrl.contains("sber.ru"), "Пользователь не перенаправлен на сайт Сбербанк.");

        logger.info("ТЕСТ ЗАВЕРШЕН: Проверка работы кнопки 'Сбербанк'");
    }

    @Test
    @DisplayName("Проверка работы кнопки 'Mail'")
    public void testMailLogoLink() {
        logger.info("ЗАПУСК ТЕСТА: Проверка работы кнопки 'Mail'");

        otherWaysPage.clickButtonMail();
        String currentUrl = otherWaysPage.getCurrentUrl();
        Assertions.assertTrue(currentUrl.contains("mail.ru"), "Пользователь не перенаправлен на сайт Mail.");

        logger.info("ТЕСТ ЗАВЕРШЕН: Проверка работы кнопки 'Mail'");
    }
}
