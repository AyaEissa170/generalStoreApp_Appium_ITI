package Pages;

import Utilities.Utilities;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.CommandExecutionHelper;
import io.appium.java_client.MobileCommand;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.UnsupportedCommandException;
import org.openqa.selenium.UnsupportedCommandException;
import org.openqa.selenium.support.ui.WebDriverWait;

public class P01_loginPage {
    public AndroidDriver driver;
    //locator
   private final  By nameField=AppiumBy.id("com.androidsample.generalstore:id/nameField");
   private final By genderMale=By.id("com.androidsample.generalstore:id/radioMale");
    private final By genderFemale=By.id("com.androidsample.generalstore:id/radioFemale");
    private  final By ShopButton=By.id("com.androidsample.generalstore:id/btnLetsShop");
    private  final By countryDropDown=By.id("android:id/text1");
    private  final By selectCountry=By.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Egypt\"]");

   // private  final By country=By.id("com.androidsample.generalstore:id/spinnerCountry");

    //constructor
    public P01_loginPage(AndroidDriver driver)
    {
        this.driver=driver;
    }


    //actions
    public P01_loginPage enterUserName(String usernameText)
    {
        Utilities.SendData(driver,nameField,usernameText);
        return this;


    }
    public P02_landingPage clickLetsShop()
    {
        Utilities.clickElement(driver,ShopButton);
        return new P02_landingPage(driver);

    }
    public P01_loginPage clickGenderFemale()
    {
        Utilities.clickElement(driver,genderFemale);
        return this;
    }
    public P01_loginPage clickGenderMale()
    {
        Utilities.clickElement(driver,genderMale);
        return this;

    }
    public P01_loginPage clickCountryDropDown()
    {
        Utilities.clickElement(driver,countryDropDown);

        return this;
    }

    public P01_loginPage scrollDownUntilViewYourCountry()
    {

        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Egypt\"))"));
        return this;
    }
 public P01_loginPage selectCountry()
 {
     Utilities.clickElement(driver,selectCountry);
     return this;
 }

}


//Actions