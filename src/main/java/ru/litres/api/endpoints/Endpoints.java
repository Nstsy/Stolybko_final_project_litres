package ru.litres.api.endpoints;

public class Endpoints {
    public static final String BASE_URL = "https://api.litres.ru/foundation";
    public static final String LOGIN_ENDPOINT = "/api/auth/login";
    public static final String PHONE_ENDPOINT = "/api/auth/phone-available";
    public static final String SEARCH_ENDPOINT = "/api/search/suggestions";

    public static String getURI(String endpoint) {
        return BASE_URL + endpoint;
    }
}
