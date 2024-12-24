package ru.litres.ui.pages.login.otherways;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.litres.ui.driver.Driver;

import java.util.Set;

public class OtherWaysPage {
    private final WebDriver driver;

    public OtherWaysPage() {
        driver = Driver.getDriver();
    }

    @Step("Кликнуть по кнопке 'Другие способы'")
    public OtherWaysPage clickButtonOtherWays() {
        driver.findElement(By.xpath(OtherWaysXpath.BUTTON_OTHER_WAYS_XPATH)).click();
        return this;
    }

    @Step("Получить текст 'Другие способы'")
    public String getOtherWaysText() {
        return driver.findElement(By.xpath(OtherWaysXpath.TEXT_OTHER_WAYS_XPATH)).getText();
    }

    @Step("Кликнуть по кнопке 'Приложение Литрес'")
    public OtherWaysPage clickButtonLitresApp() {
        driver.findElement(By.xpath(OtherWaysXpath.BUTTON_LITRES_APP_XPATH)).click();
        return this;
    }

    @Step("Получить текст 'Вход через приложение'")
    public String getLitresAppText() {
        return driver.findElement(By.xpath(OtherWaysXpath.LITRES_APP_TEXT_XPATH)).getText();
    }

    @Step("Кликнуть по ссылке 'публичная оферта'")
    public OtherWaysPage clickButtonLitresOferta() {
        driver.findElement(By.xpath(OtherWaysXpath.LINK_LITRES_OFERTA_XPATH)).click();
        getNewWindow();
        return this;
    }

    @Step("Кликнуть по ссылке 'обработка персональных данных'")
    public OtherWaysPage clickButtonPrivacyPolicy() {
        driver.findElement(By.xpath(OtherWaysXpath.LINK_PRIVACY_POLICY_XPATH)).click();
        getNewWindow();
        return this;
    }

    @Step("Получить текст 'публичная оферта'")
    public String getLitresOfertaText() {
        return driver.findElement(By.xpath(OtherWaysXpath.TEXT_LITRES_OFERTA_XPATH)).getText();
    }

    @Step("Получить текст 'обработка персональных данных'")
    public String getPrivacyPolicyText() {
        return driver.findElement(By.xpath(OtherWaysXpath.TEXT_PRIVACY_POLICY_XPATH)).getText();
    }

    @Step("Проверить наличие логотипов социальных сетей")
    public boolean checkLogoSocialsLinks() {
        String[] expectedLogo = {"gp", "vk", "ok", "sb", "ya", "ma"};
        for (String altLogo : expectedLogo) {
            driver.findElement(By.xpath("//img[@alt='" + altLogo + "']")).isDisplayed();
        }
        return true;
    }

    @Step("Перейти на новую вкладку")
    public void getNewWindow() {
        String originalWindow = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        for (String handle : windowHandles) {
            if (!handle.equals(originalWindow)) {
                driver.switchTo().window(handle);
                break;
            }
        }
    }

    @Step("Кликнуть по логотипу 'Google'")
    public OtherWaysPage clickButtonGoogle() {
        driver.findElement(By.xpath(OtherWaysXpath.BUTTON_GOOGLE_XPATH)).click();
        getNewWindow();
        return this;
    }

    @Step("Кликнуть по логотипу 'Yandex'")
    public OtherWaysPage clickButtonYandex() {
        driver.findElement(By.xpath(OtherWaysXpath.BUTTON_YANDEX_XPATH)).click();
        getNewWindow();
        return this;
    }

    @Step("Кликнуть по логотипу 'Вконтакте'")
    public OtherWaysPage clickButtonVk() {
        driver.findElement(By.xpath(OtherWaysXpath.BUTTON_VK_XPATH)).click();
        getNewWindow();
        return this;
    }

    @Step("Кликнуть по логотипу 'Одноклассники'")
    public OtherWaysPage clickButtonOk() {
        driver.findElement(By.xpath(OtherWaysXpath.BUTTON_OK_XPATH)).click();
        getNewWindow();
        return this;
    }

    @Step("Кликнуть по логотипу 'Сбербанк'")
    public OtherWaysPage clickButtonSb() {
        driver.findElement(By.xpath(OtherWaysXpath.BUTTON_SBER_XPATH)).click();
        getNewWindow();
        return this;
    }

    @Step("Кликнуть по логотипу 'Mail'")
    public OtherWaysPage clickButtonMail() {
        driver.findElement(By.xpath(OtherWaysXpath.BUTTON_MAIL_XPATH)).click();
        getNewWindow();
        return this;
    }

    @Step("Получить текущий URL")
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
