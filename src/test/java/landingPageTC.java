import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class landingPageTC extends baseTest{

    @Test
    public void selectAllProductsTC()
    {
        login.enterUserName("aya").clickGenderFemale().clickLetsShop()
                .addAllProductsToCart();
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
@Test
    public void addOneProductToCart()
    {
        login.enterUserName("aya").clickGenderFemale().clickLetsShop()
                .scrollUntilView(constantsData.locationOfProduct1)
                .addToCart(constantsData.NameOFProduct1)
                .clickCartIcon();
    }
    @Test
    public void addTWoProductsToCart()
    {
        login.enterUserName("aya").clickGenderFemale()
                .clickCountryDropDown().scrollDownUntilViewYourCountry().selectCountry()
                .clickLetsShop()
                .scrollUntilView(constantsData.locationOfProduct1)
                .addToCart(constantsData.NameOFProduct1);
        selectProducts
                .scrollUntilView(constantsData.locationOfProduct2)
                .addToCart(constantsData.NameOFProduct2);

        //assert added to cart
        final By counterNumber =By.id(constantsData.Counter);
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.attributeContains(counterNumber,"text","2"));

    }
}
