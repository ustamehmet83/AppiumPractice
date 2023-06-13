package com.qa.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class SettingsPage extends BasePage{


    @iOSXCUITFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-ALL ITEMS\"]")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-ALL ITEMS\"]")
    public WebElement allItemsBtn;

    @iOSXCUITFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-WEBVIEW\"]")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-WEBVIEW\"]")
    public WebElement webViewBtn;

    @iOSXCUITFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-QR CODE SCANNER\"]")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-QR CODE SCANNER\"]")
    public WebElement qrCodeScannerBtn;

    @iOSXCUITFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-GEO LOCATION\"]")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-GEO LOCATION\"]")
    public WebElement geoLocationBtn;

    @iOSXCUITFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-DRAWING\"]")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-DRAWING\"]")
    public WebElement drawingBtn;

    @iOSXCUITFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-ABOUT\"]")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-ABOUT\"]")
    public WebElement aboutBtn;

    @iOSXCUITFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-LOGOUT\"]")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-LOGOUT\"]")
    public WebElement logoutBtn;

    @iOSXCUITFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-RESET APP STATE\"]")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-RESET APP STATE\"]")
    public WebElement resetAppStateBtn;
}
