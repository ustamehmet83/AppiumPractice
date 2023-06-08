package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import utils.Driver;

import java.time.Duration;

public class AndLockAndUnLockDevice {
    //lock,unlock,isDeviceLocked

    public static void main(String[] args) throws Exception {

        AppiumDriver driver= Driver.getDriver("Android");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        ((AndroidDriver)driver).lockDevice();
        System.out.println(((AndroidDriver) driver).isDeviceLocked());
        Thread.sleep(3000);
        ((AndroidDriver)driver).unlockDevice();









    }
}
