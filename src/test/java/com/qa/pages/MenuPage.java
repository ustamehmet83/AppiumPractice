package com.qa.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class MenuPage extends BasePage {

    @iOSXCUITFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Menu\"]/android.view.ViewGroup/android.widget.ImageView")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Menu\"]/android.view.ViewGroup/android.widget.ImageView")
    public WebElement menuBar;

    @iOSXCUITFindBy(xpath = "//android.view.ViewGroup[1]/android.widget.ImageView[2]")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[1]/android.widget.ImageView[2]")
    public WebElement swagLabsTxt;

    @iOSXCUITFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.widget.ImageView")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.widget.ImageView")
    public WebElement cartBtn;

}
