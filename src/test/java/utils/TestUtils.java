package utils;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestUtils {
    public static final long WAIT=10;

    public static void waitForVisibility(WebElement e) {
        WebDriverWait wait;
        try {
            wait = new WebDriverWait(Driver.getDriver("saucelab"), Duration.ofSeconds(TestUtils.WAIT));
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        wait.until(ExpectedConditions.visibilityOf(e));
    }

    public static void clear(WebElement e) {
        waitForVisibility(e);
        e.clear();
    }

    public static void click(WebElement e) {
        waitForVisibility(e);
        e.click();
    }

    public static void sendKeys(WebElement e, String txt) {
        waitForVisibility(e);
        e.sendKeys(txt);
    }

    public void getAttribute(WebElement e, String attribute) {
        waitForVisibility(e);
    }

    public static void enterUserName(String username,WebElement userField) {
        clear(userField);
        sendKeys(userField, username);
    }

    public static void enterPassword(String password,WebElement passField) {
        clear(passField);
        sendKeys(passField, password);
    }

    public static void pressLoginBtn(WebElement loginBtn) {
        click(loginBtn);
    }

}
