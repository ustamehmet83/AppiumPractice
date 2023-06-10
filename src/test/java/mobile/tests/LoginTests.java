package mobile.tests;

import com.qa.pages.LoginPage;
import com.qa.pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.TestUtils;

public class LoginTests {
    LoginPage loginPage = new LoginPage();
    ProductsPage productsPage = new ProductsPage();

    @Test
    public void invalidUsername() throws Exception {
        TestUtils.enterUserName("invalidusername",loginPage.usernameTextFld);
        TestUtils.enterPassword("secret_sauce", loginPage.passTextFld);
        TestUtils.pressLoginBtn(loginPage.loginBtn);
        String actualErrTxt = loginPage.invalidLgnTxt.getText();
        String expectedErrTxt="Username and password do not match any user in this service.";
        Assert.assertEquals(actualErrTxt, expectedErrTxt);

    }

    @Test
    public void invalidPassword() throws Exception {
        TestUtils.enterUserName("standart_user",loginPage.usernameTextFld);
        TestUtils.enterPassword("secret_sauce", loginPage.passTextFld);
        TestUtils.pressLoginBtn(loginPage.loginBtn);
        String actualErrTxt = loginPage.invalidLgnTxt.getText();
        String expectedErrTxt="Username and password do not match any user in this service.";
        Assert.assertEquals(actualErrTxt, expectedErrTxt);

    }

    @Test
    public void successfulLogin() throws InterruptedException {
        TestUtils.enterUserName("standard_user",loginPage.usernameTextFld);
        TestUtils.enterPassword("secret_sauce", loginPage.passTextFld);
        TestUtils.pressLoginBtn(loginPage.loginBtn);
        productsPage.productTitle.isDisplayed();
        String productText = "PRODUCTS";
        Assert.assertEquals(productText, productsPage.productTitle.getText());
    }


}
