package ru.litres.api;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

@Epic("API тесты")
@Feature("API тест поисковой строки")
public class SearchApiTest {
    private static final Logger logger = LogManager.getLogger();

    @Test
    @DisplayName("Запрос в поисковой строке")
    public void searchTest() {
        logger.info("ЗАПУСК ТЕСТА: Запрос в поисковой строке");

        SearchApi searchApi = new SearchApi();
        String searchText = "Стивен Кинг";
        ValidatableResponse response = searchApi.getResponseForRequestWithData(searchText);

        int actualStatusCode = response.extract().statusCode();
        List<String> texts = response.extract().jsonPath().getList("payload.data.text");

        Assertions.assertAll(
                () -> Assertions.assertEquals(HttpStatus.SC_OK, actualStatusCode, "Статус-код должен быть 200"),
                () -> Assertions.assertTrue(searchApi.containsText(texts, searchText.toLowerCase()), "Ответ должен содержать текст: " + searchText)
        );

        logger.info("ТЕСТ ЗАВЕРШЕН: Ответ содержит текст '{}' - проверка успешна.", searchText);
    }
}
