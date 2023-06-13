package com.qa.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import mobile.utils.Driver;
import mobile.utils.BrowserUtils;
import java.time.Duration;

public class LoginPage extends BasePage {



    @AndroidFindBy(accessibility = "test-Username")
    @iOSXCUITFindBy(id = "test-Username")
    public WebElement usernameTextFld;

    @iOSXCUITFindBy(id = "test-Password")
    @AndroidFindBy(accessibility = "test-Password")
    public WebElement passTextFld;

    @iOSXCUITFindBy(id = "test-LOGIN")
    @AndroidFindBy(accessibility = "test-LOGIN")
    public WebElement loginBtn;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"test-Error message\"]/child::XCUIElementTypeStaticText")
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
