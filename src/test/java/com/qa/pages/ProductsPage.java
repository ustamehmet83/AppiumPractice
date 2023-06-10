package com.qa.pages;

import com.qa.BaseTest;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class ProductsPage extends BaseTest{

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Cart drop zone\"]/android.view.ViewGroup/android.widget.TextView")
    public WebElement productTitle;
}
