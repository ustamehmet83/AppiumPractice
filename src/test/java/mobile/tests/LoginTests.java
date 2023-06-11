package mobile.tests;

import com.qa.pages.LoginPage;
import com.qa.pages.ProductsPage;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.BrowserUtils;
import utils.ConfigurationReader;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

public class LoginTests {
    LoginPage loginPage = new LoginPage();
    ProductsPage productsPage = new ProductsPage();
    InputStream dataIs;
    JSONObject loginUsers;

    @BeforeClass
    public void beforeClass() throws IOException {
        try {
            String dataFileName="data/loginUsers.json";
            dataIs=getClass().getClassLoader().getResourceAsStream(dataFileName);
            JSONTokener tokener= new JSONTokener(dataIs);
            loginUsers= new JSONObject(tokener);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(dataIs != null){
                dataIs.close();
            }
        }

    }

    @Test
    public void invalidUsername() throws Exception {
        BrowserUtils.enterUserName(loginUsers.getJSONObject("invalidUser").getString("username"),loginPage.usernameTextFld);
        BrowserUtils.enterPassword(loginUsers.getJSONObject("invalidUser").getString("password"), loginPage.passTextFld);
        BrowserUtils.pressLoginBtn(loginPage.loginBtn);
        String actualErrTxt = loginPage.invalidLgnTxt.getText();
        String expectedErrTxt="Username and password do not match any user in this service.";
        Assert.assertEquals(actualErrTxt, expectedErrTxt);

    }
    @Test
    public void invalidPassword() throws Exception {
        BrowserUtils.enterUserName(loginUsers.getJSONObject("invalidPassword").getString("username"),loginPage.usernameTextFld);
        BrowserUtils.enterPassword(loginUsers.getJSONObject("invalidPassword").getString("password"), loginPage.passTextFld);
        BrowserUtils.pressLoginBtn(loginPage.loginBtn);
        String actualErrTxt = loginPage.invalidLgnTxt.getText();
        String expectedErrTxt= ConfigurationReader.strings.get("err_valid_username_or_password");
        Assert.assertEquals(actualErrTxt, expectedErrTxt);

    }
    @Test
    public void successfulLogin() throws InterruptedException {
        BrowserUtils.enterUserName(loginUsers.getJSONObject("validUser").getString("username"),loginPage.usernameTextFld);
        BrowserUtils.enterPassword(loginUsers.getJSONObject("validUser").getString("password"),loginPage.passTextFld);
        BrowserUtils.pressLoginBtn(loginPage.loginBtn);
        productsPage.productTitle.isDisplayed();
        String productText = ConfigurationReader.strings.get("product_title");
        Assert.assertEquals(productText, productsPage.productTitle.getText());
    }


}
