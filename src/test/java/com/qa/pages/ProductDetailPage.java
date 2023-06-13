package com.qa.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class ProductDetailPage extends BasePage{

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"test-Description\"]/child::XCUIElementTypeStaticText[1]")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Description\"]/android.widget.TextView[1]")
    public WebElement productDetailTitle;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"test-Description\"]/child::XCUIElementTypeStaticText[2]")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Description\"]/android.widget.TextView[2]")
    public WebElement productDesc;

    @iOSXCUITFindBy(accessibility = "test-ADD TO CART")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"]/android.widget.TextView")
    public WebElement addToCartBtn;



}
