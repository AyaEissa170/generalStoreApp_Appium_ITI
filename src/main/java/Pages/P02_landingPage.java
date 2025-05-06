package Pages;

import Utilities.Utilities;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class P02_landingPage {
public AndroidDriver driver;
private List<WebElement> allProducts;
    //locators

private final By selectAllProducts=By.xpath("(//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productAddCart\"])");
private final By CartIcon=By.xpath("//android.widget.ImageButton[@resource-id=\"com.androidsample.generalstore:id/appbar_btn_cart\"]");
public   final By ProductsPage =By.id("com.androidsample.generalstore:id/toolbar_title");
private final By  leftArrow=By.id("com.androidsample.generalstore:id/appbar_btn_back");
private  final By productNameLocator=By.id("com.androidsample.generalstore:id/productName");
private  final By productAddCartLocator=By.id("com.androidsample.generalstore:id/productAddCart");


    //constructors
    public P02_landingPage(AndroidDriver driver)
    {
        this.driver=driver;
    }

    //actions

    public P02_landingPage addAllProductsToCart()
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

    public P02_landingPage scrollUntilView(String productLocation)
    {
        Utilities.scrollUntilView(driver,productLocation);

        return this;
    }


    public P02_landingPage addToCart(String nameOfProduct)
    {
        int productCount=driver.findElements(productNameLocator).size();

        for(int i=0;i<productCount;i++)
        {
            String productName=driver.findElements(productNameLocator).get(i).getText();
            System.out.println(productName);

            if(productName.equalsIgnoreCase(nameOfProduct))

            {
                new WebDriverWait(driver, Duration.ofSeconds(10));
               driver.findElements(productAddCartLocator).get(i).click();
            }


        }
     return this;
    }

    public P03_cartPage clickCartIcon() {
        Utilities.clickElement(driver, CartIcon);
        return new P03_cartPage(driver);
    }

    public void arrowBack()
    {
        Utilities.clickElement(driver,leftArrow);
    }

}
