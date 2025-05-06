import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class cartPageTC extends baseTest {

    @Test
    public void checkProductPriceOnCart_01TC() {
        login.enterUserName("Aya Eissa").clickGenderFemale()
                .clickCountryDropDown().scrollDownUntilViewYourCountry().selectCountry().clickLetsShop()
                .scrollUntilView(constantsData.locationOfProduct1).addToCart(constantsData.NameOFProduct1)
                .clickCartIcon().emailVerificationCheckBox();

        //Assertions
        // Assert.assertTrue(Cart.ComparingPrices());
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.attributeContains(Cart.emailCheckBox,"text","Send me e-mails on discounts related to selected products in future"));

    }
    @Test
    public void checkProductPriceOnCart_02TC() {
        login.enterUserName("Aya Eissa").clickGenderFemale().clickLetsShop();
        selectProducts.scrollUntilView(constantsData.locationOfProduct1).addToCart(constantsData.NameOFProduct1)
                      .scrollUntilView(constantsData.locationOfProduct2).addToCart(constantsData.NameOFProduct2)
                      .clickCartIcon().emailVerificationCheckBox();


        //Assertions
        Assert.assertTrue(Cart.ComparingPrices());
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.attributeContains(Cart.emailCheckBox,"text","Send me e-mails on discounts related to selected products in future"));


    }

    @Test
    public void checkProductPriceOnCart_03TC() {
        login.enterUserName("Aya Eissa").clickGenderFemale().clickCountryDropDown()
                        .scrollDownUntilViewYourCountry().selectCountry().clickLetsShop();

        selectProducts.scrollUntilView(constantsData.locationOfProduct1).addToCart(constantsData.NameOFProduct1)
                      .scrollUntilView(constantsData.locationOfProduct2).addToCart(constantsData.NameOFProduct2)
                      .scrollUntilView(constantsData.locationOfProduct3).addToCart(constantsData.NameOFProduct3)
                       .clickCartIcon().emailVerificationCheckBox();



        //Assert comparing prices;
        Assert.assertTrue(Cart.ComparingPrices());

        //assert added to cart
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.attributeContains(Cart.emailCheckBox,"text","Send me e-mails on discounts related to selected products in future"));

    }

    @Test
    public void checkProductPriceOnCart_04TC() {
        login.enterUserName("Aya Eissa").clickGenderFemale()
                .clickCountryDropDown().scrollDownUntilViewYourCountry().selectCountry().clickLetsShop()
                .scrollUntilView(constantsData.locationOfProduct1).addToCart(constantsData.NameOFProduct1)
                .clickCartIcon().emailVerificationCheckBox().CompletePurchase();

    }


}
