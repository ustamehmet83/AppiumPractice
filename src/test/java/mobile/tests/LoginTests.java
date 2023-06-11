package mobile.tests;

import com.qa.pages.LoginPage;
import com.qa.pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import mobile.utils.BrowserUtils;
import mobile.utils.ConfigurationReader;

public class LoginTests {
    LoginPage loginPage = new LoginPage();
    ProductsPage productsPage = new ProductsPage();


    @BeforeClass
    public void beforeClass() {


    }

    @Test
    public void invalidUsername() {
        BrowserUtils.enterUserName(ConfigurationReader.loginUsers.getJSONObject("invalidUser").getString("username"), loginPage.usernameTextFld);
        BrowserUtils.enterPassword(ConfigurationReader.loginUsers.getJSONObject("invalidUser").getString("password"), loginPage.passTextFld);
        BrowserUtils.pressLoginBtn(loginPage.loginBtn);
        String actualErrTxt = loginPage.invalidLgnTxt.getText();
        String expectedErrTxt = "Username and password do not match any user in this service.";
        Assert.assertEquals(actualErrTxt, expectedErrTxt);

    }

    @Test
    public void invalidPassword() {
        BrowserUtils.enterUserName(ConfigurationReader.loginUsers.getJSONObject("invalidPassword").getString("username"), loginPage.usernameTextFld);
        BrowserUtils.enterPassword(ConfigurationReader.loginUsers.getJSONObject("invalidPassword").getString("password"), loginPage.passTextFld);
        BrowserUtils.pressLoginBtn(loginPage.loginBtn);
        String actualErrTxt = loginPage.invalidLgnTxt.getText();
        String expectedErrTxt = ConfigurationReader.strings.get("err_valid_username_or_password");
        Assert.assertEquals(actualErrTxt, expectedErrTxt);

    }

    @Test
    public void successfulLogin() {
        BrowserUtils.enterUserName(ConfigurationReader.loginUsers.getJSONObject("validUser").getString("username"), loginPage.usernameTextFld);
        BrowserUtils.enterPassword(ConfigurationReader.loginUsers.getJSONObject("validUser").getString("password"), loginPage.passTextFld);
        BrowserUtils.pressLoginBtn(loginPage.loginBtn);
        productsPage.productTitle.isDisplayed();
        String productText = ConfigurationReader.strings.get("product_title");
        Assert.assertEquals(productText, productsPage.productTitle.getText());
    }


}
