package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.BeforeClass;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import pages.LoginPage;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by shebbar on 06/03/17.
 */
public class DriverFactory {


    public static AppiumDriver driver;

    @BeforeClass
    public static void initialiseAppiumDriverAndroid() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        setupDevice(capabilities);
    }

    private static void setupDevice(DesiredCapabilities capabilities) throws MalformedURLException {

        capabilities.setCapability("automationName","Appium");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("platformVersion","6.0.1");
        capabilities.setCapability("deviceName", "Nexus 5");
        capabilities.setCapability("appPackage","com.aconex.field.mobile.ota");
        capabilities.setCapability("appActivity","com.aconex.field.mobile.ota.FieldActivity");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        PageFactory.initElements(new AppiumFieldDecorator(driver), new LoginPage());
    }

//    public static AppiumDriver getDriver() throws Exception {
//        if (driver == null) {
//            return initialiseAppiumDriverAndroid();
//        } else
//            return driver;
//    }

}