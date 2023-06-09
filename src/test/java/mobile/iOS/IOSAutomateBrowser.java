package mobile.iOS;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Driver;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class IOSAutomateBrowser {

    public static void main(String[] args) throws Exception {

        AppiumDriver driver= Driver.getDriver("iOS");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        driver.get("https://tesla.com");
        driver.findElement(AppiumBy.xpath("//span[.='Menu']")).click();
        Thread.sleep(3000);
        driver.findElement(AppiumBy.xpath("//span[.='Model X']"));
        Thread.sleep(3000);
        driver.findElement(AppiumBy.xpath("//span[.='Order Now']")).click();
        Map<String, Object> params = new HashMap<>();
        params.put("direction", "up");
        driver.executeScript("mobile: swipe", params);

        driver.findElement(AppiumBy.xpath("//span[.='Continue to Payment']")).click();

        WebElement element2 = driver.findElement(AppiumBy.xpath("//span[.='Order with Card']"));

        ((JavascriptExecutor)driver).executeScript("argument[0].scrollIntoView(true)",element2);
        driver.findElement(AppiumBy.xpath("//button[.='Order with Card']")).click();

        WebElement firstNameInput=driver.findElement(AppiumBy.xpath("//input[@id='FIRST_NAME']"));
        WebDriverWait wait=new WebDriverWait(Driver.getDriver("iOs"),Duration.ofSeconds(3));
        wait.until(ExpectedConditions.invisibilityOf(firstNameInput));

        firstNameInput.sendKeys("Mehmet");


    }
}
