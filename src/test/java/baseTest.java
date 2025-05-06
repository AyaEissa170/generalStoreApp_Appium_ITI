import Pages.cartPage;
import Pages.landingPage;
import Pages.loginPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class baseTest {
    public AppiumDriverLocalService service;
    public  AndroidDriver driver;

    public loginPage login ;
    public landingPage selectProducts;
    public cartPage Cart;
@BeforeClass
    public void configureAppium () throws MalformedURLException {
         service = new AppiumServiceBuilder()
                .withAppiumJS(new File("C://Users//FLASH//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
                .withIPAddress("127.0.0.1").usingPort(4723).build();
        service.start();

        // Desired Capabilities
        UiAutomator2Options  options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName("Aya_Pixel 3a");
        options.setAutomationName("UiAutomator2");

        // Set the APK path
        options.setApp("G:\\software testing iti\\AppuimProject1\\General-Store.apk");

        // Important: Wait for any activity
        options.setAppWaitActivity("*");
        options.setAppWaitDuration(Duration.ofSeconds(30)); // You can also use: .setAppWaitDuration(30000);
        options.setNewCommandTimeout(Duration.ofSeconds(120));

        // Initialize driver
         driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);

        // Add a small wait to stabilize the app
        try {
            Thread.sleep(5000); // Let the app load before any interaction
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        login=new loginPage (driver);
    selectProducts=new landingPage(driver);
    Cart=new cartPage(driver);

    }
@AfterClass
    public void tearDown()
    {
        //driver.quit();
        //service.stop();
    }
}
