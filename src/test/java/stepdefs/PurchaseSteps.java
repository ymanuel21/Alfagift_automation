package stepdefs;

import drivers.AppDriver;
import io.cucumber.java.en.*;
import pages.LoginPage;
import pages.ProductsPage;
import pages.CheckoutPage;
import org.openqa.selenium.By;

public class PurchaseSteps {

    @Given("the user launches the app Sauce")
    public void launchApp() throws Exception {
        AppDriver.start();
    }

    @When("the user logs in with {string} and {string}")
    public void login(String user, String pass) {
        new LoginPage(AppDriver.getDriver()).login(user, pass);
    }

    @When("the user adds {string} to the cart")
    public void addToCart(String item) {
        new ProductsPage(AppDriver.getDriver()).addToCart(item);
    }

    @When("the user proceeds to checkout")
    public void goToCheckout() {
        new CheckoutPage(AppDriver.getDriver()).goToCheckout();
    }

    @Then("both items should appear on the checkout page")
    public void verifyCheckout() {
        AppDriver.getDriver().findElement(By.xpath("//*[@text='Sauce Labs Backpack']")).isDisplayed();
        AppDriver.getDriver().findElement(By.xpath("//*[@text='Sauce Labs Bike Light']")).isDisplayed();
    }
}
