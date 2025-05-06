import Pages.loginPage;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.time.Duration;

public class loginPageTC extends baseTest {

    @Test
    public void validLoginTC() throws MalformedURLException {


         driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField"))
         .sendKeys("ayaMostafa");

         driver.hideKeyboard();

        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/radioFemale"))
                .click();


       driver.findElement(AppiumBy.id("android:id/text1")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Egypt\"))"));
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Egypt\"]")).click();

        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop"))
               .click();


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
public void validLogin()
{
    login.enterUserName("Aya");
    driver.hideKeyboard();
    login.clickGenderFemale().clickCountryDropDown().scrollDownUntilViewYourCountry().selectCountry()
            .clickLetsShop();

    //assert next page view
    final By ProductsPage =By.id("com.androidsample.generalstore:id/toolbar_title");
    WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
    wait.until(ExpectedConditions.attributeContains(ProductsPage,"text","Products"));
}
@Test
    public void invalidLogin()
    {
        login.clickGenderFemale().clickCountryDropDown().scrollDownUntilViewYourCountry().selectCountry()
                .clickLetsShop();

        String message= driver.findElement(AppiumBy.xpath("(//android.widget.Toast)[1]")).getDomAttribute("name");
        Assert.assertEquals(message,"Please enter your name");


    }

}

