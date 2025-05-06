package testCases;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import testBase.baseTest;
import testBase.constantsData;

import java.net.MalformedURLException;
import java.time.Duration;

public class learningTC extends baseTest{

    @Test
    public void validLoginTC() throws MalformedURLException {


        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField"))
                .sendKeys(constantsData.clientName);
        driver.hideKeyboard();
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/radioFemale"))
                .click();


        driver.findElement(AppiumBy.id("android:id/text1")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Egypt\"))"));
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Egypt\"]")).click();

        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop"))
                .click();
        final By ProductsPage =By.id("com.androidsample.generalstore:id/toolbar_title");
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.attributeContains(ProductsPage,"text","Products"));

    }

    @Test
    public void invalidLoginTC_EmptyName() throws MalformedURLException {

        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/radioFemale"))
                .click();


        driver.findElement(AppiumBy.id("android:id/text1")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Egypt\"))"));
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Egypt\"]")).click();

        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop"))
                .click();

        String message= driver.findElement(AppiumBy.xpath("(//android.widget.Toast)[1]")).getDomAttribute("name");
        Assert.assertEquals(message,"Please enter your name");

    }
    @Test
    public void addProductsToCart()
    {

        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Nike Blazer Mid '77\"))"));
        int productCount=driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
        System.out.println(productCount);

        for(int i=0;i<productCount;i++)
        {
            String productName=driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
            System.out.println(productName);

            if(productName.equalsIgnoreCase("Nike Blazer Mid '77"))

            {
                driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
            }


        }

    }

}
