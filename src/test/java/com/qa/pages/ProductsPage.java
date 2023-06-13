package com.qa.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class ProductsPage extends BasePage {
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"test-Toggle\"]/parent::*[1]/preceding::*[1]")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Cart drop zone\"]/android.view.ViewGroup/android.widget.TextView")
    public WebElement productTitle;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"test-Item title\"])[1]")
    @AndroidFindBy(xpath = "(//android.widget.TextView[@content-desc=\"test-Item title\"])[1]")
    public WebElement SLBTitle;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"test-Price\"])[1]")
    @AndroidFindBy(xpath = "(//android.widget.TextView[@content-desc=\"test-Price\"])[1]")
    public WebElement SLBPrice;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"test-Description\"]/android.widget.TextView[2]")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Description\"]/android.widget.TextView[2]")
    public WebElement SLBText;

    @iOSXCUITFindBy(xpath = "/hierarchy/android.widget.FrameLayout")
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout")
    public WebElement ListFrame;





}



