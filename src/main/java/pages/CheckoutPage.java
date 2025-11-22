package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import drivers.AppDriver;

public class CheckoutPage {
    AndroidDriver driver;

    By cartBtn = By.xpath("//android.view.ViewGroup[@content-desc='test-Cart']/android.view.ViewGroup/android.widget.ImageView");


    public CheckoutPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public void goToCheckout() {
         driver.findElement(cartBtn).click();
    }

}
