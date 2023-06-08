package tests;

import io.appium.java_client.AppiumDriver;
import utils.Driver;

import java.time.Duration;

public class AndChromeDriverAuto {
    public static void main(String[] args) throws Exception {
        AppiumDriver driver= Driver.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        driver.get("https://tesla.com");
    }
}
