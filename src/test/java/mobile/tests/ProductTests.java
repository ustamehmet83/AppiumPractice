package mobile.tests;

import com.google.common.collect.ImmutableMap;
import com.qa.pages.BasePage;
import com.qa.pages.ProductsPage;
import io.appium.java_client.AppiumBy;
import mobile.utils.BrowserUtils;
import mobile.utils.ConfigurationReader;
import mobile.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ProductTests {
    ProductsPage productsPage=new ProductsPage();

    @Test
    public void validateProductOnProductsPage() throws Exception {
        SoftAssert softAssert= new SoftAssert();
        BrowserUtils.login(ConfigurationReader.loginUsers.getJSONObject("validUser").getString("username"),
        ConfigurationReader.loginUsers.getJSONObject("validUser").getString("password"));

        String SLBTitleText=productsPage.SLBTitle.getText();
        softAssert.assertEquals(SLBTitleText,ConfigurationReader.strings.get("product_page_slb_title"));

        productsPage.SLBTitle.click();
        String SLBText=productsPage.SLBText.getText();
        softAssert.assertEquals(SLBText,ConfigurationReader.strings.get("product_page_slb_txt"));

       BrowserUtils.scrollDown(productsPage.ListFrame);
        String SLBPriceText=productsPage.SLBPrice.getText();
        softAssert.assertEquals(SLBPriceText,ConfigurationReader.strings.get("product_page_slb_price"));
    }










}
