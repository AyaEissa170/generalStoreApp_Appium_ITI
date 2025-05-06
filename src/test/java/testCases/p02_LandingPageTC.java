package testCases;

import Pages.P03_cartPage;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import testBase.baseTest;
import testBase.constantsData;

import java.time.Duration;

public class p02_LandingPageTC extends baseTest {

@Test
    public void addOneProductToCart()
    {
        login.enterUserName(constantsData.clientName).clickGenderFemale()
                .clickCountryDropDown().scrollDownUntilViewYourCountry().clickCountryDropDown().clickLetsShop()
                .scrollUntilView(constantsData.locationOfProduct1)
                .addToCart(constantsData.NameOFProduct1)
                .clickCartIcon();
       //  final By CartPage=By.id("com.androidsample.generalstore:id/toolbar_title");
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.attributeContains(P03_cartPage.CartPage,"text","Cart"));

    }
    @Test
    public void addTWoProductsToCart()
    {
        login.enterUserName(constantsData.clientName).clickGenderFemale()
                .clickCountryDropDown().scrollDownUntilViewYourCountry().selectCountry()
                .clickLetsShop()
                .scrollUntilView(constantsData.locationOfProduct1)
                .addToCart(constantsData.NameOFProduct1)
                .scrollUntilView(constantsData.locationOfProduct2)
                .addToCart(constantsData.NameOFProduct2);

        //assert number on Cart Icon equals number of selected products
        //final By counterNumber =By.id(constantsData.Counter);
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.attributeContains(Cart.counterNumber,"text","2"));



    }

    @Test
    public void addThreeProductsToCart()
    {
        login.enterUserName(constantsData.clientName).clickGenderFemale()
                .clickCountryDropDown().scrollDownUntilViewYourCountry().selectCountry()
                .clickLetsShop()
                .scrollUntilView(constantsData.locationOfProduct1)
                .addToCart(constantsData.NameOFProduct1)
                .scrollUntilView(constantsData.locationOfProduct2)
                .addToCart(constantsData.NameOFProduct2)
                .scrollUntilView(constantsData.locationOfProduct3)
                .addToCart(constantsData.NameOFProduct3);

        //assert number on Cart Icon equals number of selected products
        //final By counterNumber =By.id(constantsData.Counter);
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.attributeContains(Cart.counterNumber,"text","3"));


    }
    @Test
    public void emptyCartTC()
    {
        login.enterUserName(constantsData.clientName).clickGenderFemale()
                .clickCountryDropDown().scrollDownUntilViewYourCountry().clickCountryDropDown().clickLetsShop()
                .clickCartIcon();

        String message= driver.findElement(AppiumBy.xpath("(//android.widget.Toast)[1]")).getDomAttribute("name");
        Assert.assertEquals(message,"Please add some product at first");

    }

}
