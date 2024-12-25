package ru.litres.api;

import io.restassured.response.ValidatableResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;

public class BaseApiTest {
    protected static final Logger logger = LogManager.getLogger();
    protected LoginApi loginApi;
    protected PhoneApi phoneApi;

    @BeforeEach
    public void setUp() {
        logger.info("Начало настройки теста");
        loginApi = new LoginApi();
        phoneApi = new PhoneApi();
    }
}
