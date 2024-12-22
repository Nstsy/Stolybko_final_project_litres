package ru.litres.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import ru.litres.enums.CountryCode;

@Getter
@Setter
@Accessors(chain = true)
public class User {
    private String login;
    private String password;
    private String phone;
    private CountryCode code;
}
