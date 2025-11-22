package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class LoginPage {
    AndroidDriver driver;

    By username = By.xpath("//android.widget.EditText[@content-desc='test-Username']");
    By password = By.xpath("//android.widget.EditText[@content-desc='test-Password']");
    By loginBtn = By.xpath("//android.widget.TextView[@text='LOGIN']");


    public LoginPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public void login(String user, String pass) {
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(loginBtn).click();
    }

}
