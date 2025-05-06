package Pages;

import Utilities.Utilities;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class landingPage {
public AndroidDriver driver;
private List<WebElement> allProducts;
    //locators
private final By selectAllProducts=By.xpath("(//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productAddCart\"])");
private final By CartIcon=By.xpath("//android.widget.ImageButton[@resource-id=\"com.androidsample.generalstore:id/appbar_btn_cart\"]");

    //constructors
    public landingPage (AndroidDriver driver)
    {
        this.driver=driver;
    }

    //actions

    public landingPage addAllProductsToCart()
    {
        allProducts=driver.findElements(selectAllProducts);
        //making dynamic locator
        for(int i=1;i<=allProducts.size();i++)
        {
            try {
                By selectAllProducts=By.xpath("(//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productAddCart\"])["+i+"]");
                Utilities.clickElement(driver,selectAllProducts);

            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }
        return this;
    }

    public landingPage scrollUntilView(String productLocation)
    {
        Utilities.scrollUntilView(driver,productLocation);

        return this;
    }


    public landingPage addToCart(String nameOfProduct)
    {
        int productCount=driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();

        for(int i=0;i<productCount;i++)
        {
            String productName=driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
            System.out.println(productName);

            if(productName.equalsIgnoreCase(nameOfProduct))

            {
                new WebDriverWait(driver, Duration.ofSeconds(10));
               driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
            }


        }
     return this;
    }

    public cartPage clickCartIcon() {
        Utilities.clickElement(driver, CartIcon);
        return new cartPage(driver);
    }

}
