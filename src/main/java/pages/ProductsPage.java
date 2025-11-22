package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class ProductsPage {
    AndroidDriver driver;

    public ProductsPage(AndroidDriver driver) {
        this.driver = driver;
    }

public void addToCart(String product) {
    WebDriverWait wait = new WebDriverWait(driver, 10); 
    String xpath = "//android.widget.TextView[@content-desc='test-Item title' and @text='" + product + "']/ancestor::android.view.ViewGroup[@content-desc='test-Item']//android.view.ViewGroup[@content-desc='test-ADD TO CART']";
    By addToCartButton = By.xpath(xpath);
    wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
    }

}
