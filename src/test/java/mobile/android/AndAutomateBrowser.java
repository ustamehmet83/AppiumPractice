package mobile.android;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Driver;

import java.time.Duration;

public class AndAutomateBrowser {

    public static void main(String[] args) throws Exception {

        AppiumDriver driver= Driver.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://tesla.com");
        driver.findElement(By.xpath("//span[.='Menu']")).click();
        driver.findElement(By.xpath("//span[.='Model X']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//span[.='Order Now']")).click();

//        driver.findElement(By.xpath("//*[@id=\"tesla-hero-showcase-1838\"]/div/div[1]/div/div[2]/div/div[6]/a")).click();
        driver.findElement(By.xpath("//span[@data-gio-track='true']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title='Order with Card']")));

        driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
                "left", 100, "top", 100,
                "width", 600, "height", 600,
                "direction", "up"

        ));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//button[@class='tds-btn tds-btn tds-btn--blue tds-btn--large']")
        )).click();
        //    driver.findElement(By.xpath("//button[@class='tds-btn tds-btn tds-btn--blue tds-btn--large']")).click();

        WebElement element = driver.findElement(By.xpath("//*[@id=\"FIRST_NAME\"]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.sendKeys("Mehmet");
    }

}
