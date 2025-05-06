package Utilities;

import Pages.loginPage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Utilities {
    public  AndroidDriver driver;


    public static void clickElement(@NotNull AndroidDriver driver, By locator)
    {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();

    }
    public static void SendData(@NotNull AndroidDriver driver, By locator, String Text)
    {
      new WebDriverWait(driver,Duration.ofSeconds(5))
              .until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).sendKeys(Text);

    }

    public static void scrollUntilView(AndroidDriver driver,String text)
    {
        new WebDriverWait(driver,Duration.ofSeconds(15));
        driver.findElement(AppiumBy.androidUIAutomator(text));

    }

    public static String getText(WebDriver driver, By locator)
    {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(locator));
        return   driver.findElement(locator).getText();

    }
}
