package com.qa.pages;

import com.qa.BaseTest;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Driver;
import utils.BrowserUtils;
import java.time.Duration;

public class LoginPage extends BaseTest {


    @AndroidFindBy(accessibility = "test-Username")
    public WebElement usernameTextFld;
    @AndroidFindBy(accessibility = "test-Password")
    public WebElement passTextFld;
    @AndroidFindBy(accessibility = "test-LOGIN")
    public WebElement loginBtn;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Error message\"]/android.widget.TextView")
    public WebElement invalidLgnTxt;

    public void waitForVisibility(WebElement e) {
        WebDriverWait wait;
        try {
            wait = new WebDriverWait(Driver.getDriver("saucelab"), Duration.ofSeconds(BrowserUtils.WAIT));
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        wait.until(ExpectedConditions.visibilityOf(e));
    }



}
