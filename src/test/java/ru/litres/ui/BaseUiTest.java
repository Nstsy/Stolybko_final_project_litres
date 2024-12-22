package ru.litres.ui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import ru.litres.ui.driver.Driver;
import ru.litres.ui.pages.home.HomePage;

public class BaseUiTest {
    protected static final Logger logger = LogManager.getLogger();
    protected HomePage homePage;

    @BeforeEach
    public void startFromHome() {
        logger.info("Переход на главную страницу https://www.litres.ru/");
        WebDriver driver = Driver.getDriver();
        driver.get("https://www.litres.ru/");
        logger.info("Главная страница загружена. Переход к странице входа.");
        homePage = new HomePage().clickButtonLogin();
    }

    @AfterEach
    public void tearDown() {
        logger.info("Завершение теста. Закрытие драйвера.");
        Driver.quit();
    }
}
