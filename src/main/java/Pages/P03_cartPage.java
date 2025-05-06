package Pages;

import Utilities.Utilities;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class P03_cartPage {
    //driver
public AndroidDriver driver;
   //constants

   double totalAmount=0;
    //locators
    private final By productPriceId=By.id("com.androidsample.generalstore:id/productPrice");
    private final By totalAmountLbl=By.id("com.androidsample.generalstore:id/totalAmountLbl");
    public final By emailCheckBox=By.xpath("//android.widget.CheckBox[@text=\"Send me e-mails on discounts related to selected products in future\"]");
    private final By CompletePurchaseButton=By.id("com.androidsample.generalstore:id/btnProceed");
    public static final By CartPage=By.id("com.androidsample.generalstore:id/toolbar_title");
    public final By counterNumber =By.id("com.androidsample.generalstore:id/counterText");

    //constructor
    public P03_cartPage(AndroidDriver driver)
    {
        this.driver=driver;
    }
    public String productPriceONCart()
    {
        double sum=0;

        try {
            List<WebElement> productPrices = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
            System.out.println("ProductsList" + productPrices);

            int count = productPrices.size();
            System.out.println("count number is :" + count);


            for (int i = 0; i < count; i++) {
                System.out.println("inside for");

                String amountString = productPrices.get(i).getText();
                // System.out.println("Price as String" + amountString);

                double Price = Double.parseDouble(amountString.substring(1));
                sum = sum + Price;
                System.out.println("Price as Number" + Price);
                System.out.println(i);

            }
            System.out.println("last sum" + sum);
            return String.valueOf(sum);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public String totalAmountOnCart()
    {
        try {
            String totalPriceString =driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
            System.out.println("Total Amount AS String"+totalPriceString);

            totalAmount=Double.parseDouble(totalPriceString.substring(1));
            System.out.println("Total Amount as Number"+totalAmount);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("last total amount "+totalAmount);
        return String.valueOf(totalAmount);

    }


    public boolean ComparingPrices()
    {
     return totalAmountOnCart().equals(productPriceONCart());

    }

    public P03_cartPage emailVerificationCheckBox()
    {
        try {
            Utilities.clickElement(driver,emailCheckBox);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return  this;

    }
    public void CompletePurchase()
    {
        Utilities.clickElement(driver,CompletePurchaseButton);

    }


}
