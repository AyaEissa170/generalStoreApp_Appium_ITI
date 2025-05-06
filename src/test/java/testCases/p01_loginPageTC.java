package testCases;

import Pages.P02_landingPage;
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

public class p01_loginPageTC extends baseTest {

    @Test
public void validLogin()
{
    login.enterUserName(constantsData.clientName).clickGenderFemale()
      .clickCountryDropDown().scrollDownUntilViewYourCountry().selectCountry().clickLetsShop();


    //assert next page Products view
    WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
    wait.until(ExpectedConditions.attributeContains(selectProducts.ProductsPage,"text","Products"));
}
@Test
    public void invalidLoginEmptyNameTC()
    {
        login.clickGenderFemale().clickCountryDropDown().scrollDownUntilViewYourCountry().selectCountry()
                .clickLetsShop();

        String message= driver.findElement(AppiumBy.xpath("(//android.widget.Toast)[1]")).getDomAttribute("name");
        Assert.assertEquals(message,"Please enter your name");


    }

}

