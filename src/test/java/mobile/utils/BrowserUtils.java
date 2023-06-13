package mobile.utils;


import com.google.common.collect.ImmutableMap;
import com.qa.pages.LoginPage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.InteractsWithApps;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;

public class BrowserUtils {
    public static final long WAIT=10;
    protected static ThreadLocal <String> platform = new ThreadLocal<String>();
    protected static ThreadLocal <AppiumDriver> driver = new ThreadLocal<AppiumDriver>();
    static LoginPage loginPage= new LoginPage();


    public static void waitForVisibility(WebElement e) {
        WebDriverWait wait;
        try {
            wait = new WebDriverWait(Driver.getDriver("saucelab"), Duration.ofSeconds(BrowserUtils.WAIT));
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        wait.until(ExpectedConditions.visibilityOf(e));
    }

    public static void clear(WebElement e) {
        waitForVisibility(e);
        e.clear();
    }

    public static void click(WebElement e) {
        waitForVisibility(e);
        e.click();
    }

    public static void sendKeys(WebElement e, String txt) {
        waitForVisibility(e);
        e.sendKeys(txt);
    }

    public void getAttribute(WebElement e, String attribute) {
        waitForVisibility(e);
    }

    public static void enterUserName(String username) {
        clear(loginPage.usernameTextFld);
        sendKeys(loginPage.usernameTextFld, username);
    }

    public static void enterPassword(String password) {
        clear(loginPage.passTextFld);
        sendKeys(loginPage.passTextFld, password);
    }
    public static void login(String username,String password){
        enterUserName(username);
        enterPassword(password);
        loginPage.loginBtn.click();

    }

    public static void scrollDown(WebElement element)  {
        try {
            Driver.getDriver("saucelab").executeScript("mobile: swipeGesture",ImmutableMap.of(
                    // "left", 100, "top", 100, "width", 600, "height", 600,
                    "elementId", ((RemoteWebElement) element).getId(),
                    "direction", "up",
                    "percent", 0.75
            ));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static WebElement scrollToElement() {
        try {
            return Driver.getDriver("saucelab").findElement(AppiumBy.androidUIAutomator(
                    "new UiScrollable(new UiSelector()" + ".scrollable(true)).scrollIntoView("
                            + "new UiSelector().description(\"test-Price\"));"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void iOSScrollToElement() {
//	  RemoteWebElement element = (RemoteWebElement)getDriver().findElement(By.name("test-ADD TO CART"));
//	  String elementID = element.getId();
        HashMap<String, String> scrollObject = new HashMap<String, String>();
//	  scrollObject.put("element", elementID);
        scrollObject.put("direction", "down");
//	  scrollObject.put("predicateString", "label == 'ADD TO CART'");
//	  scrollObject.put("name", "test-ADD TO CART");
//	  scrollObject.put("toVisible", "sdfnjksdnfkld");
        try {
            Driver.getDriver("saucelab").executeScript("mobile:scroll", scrollObject);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }






    }

















    public AppiumDriver getDriver() {
        return driver.get();
    }
    public void closeApp(){
        switch (platform.get()){
            case"Android":
                ((InteractsWithApps)getDriver()).terminateApp(ConfigurationReader.getProperty("androidAppPackage"));
            case"iOS":
                ((InteractsWithApps)getDriver()).terminateApp(ConfigurationReader.getProperty("iOSBundleId"));
        }
    }

    public void launchApp() {
        switch(platform.get()){
            case "Android":
                ((InteractsWithApps) getDriver()).activateApp(ConfigurationReader.getProperty("androidAppPackage"));
                break;
            case "iOS":
                ((InteractsWithApps) getDriver()).activateApp(ConfigurationReader.getProperty("iOSBundleId"));
        }
    }



    public static void pressLoginBtn(WebElement loginBtn) {
        click(loginBtn);
    }



}
