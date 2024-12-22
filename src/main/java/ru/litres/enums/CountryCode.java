package ru.litres.enums;

public enum CountryCode {
    RU("7"), AB("79407"), AU("61"), AT("43"), AZ("994"), AM("374"), BY("375"), BE("32"), BG("359"), GB("44"),
    HU("36"), VN("84"), DE("49"), GR("30"), GE("995"), DK("45"), IL("972"), ID("62"), IE("353"), ES("34"),
    IT("39"), KZ("7702"), CA("1"), CN("86"), KG("996"), LV("371"), LT("370"), MD("373"), NL("31"), NZ("64"),
    NO("47"), AE("971"), PL("48"), PT("351"), CY("357"), RO("40"), US("1"), RS("381"), SG("65"), SK("421"),
    TJ("992"), TH("66"), TR("90"), UZ("998"), UA("380"), FI("358"), FR("33"), ME("382"), CZ("420"), CH("41"),
    SE("46"), EE("372"), KR("82"), JP("81"), EMPTY(""), INVALID("111");

    public final String code;

    CountryCode(String code) {
        this.code = code;
    }
}
