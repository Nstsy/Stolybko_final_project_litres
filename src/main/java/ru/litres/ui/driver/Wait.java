package ru.litres.ui.driver;

import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Wait {
    private static WebDriverWait wait;

    public static WebDriverWait getWaitDriver(int seconds){
        return wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(seconds));
    }
    public static void getWait(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
