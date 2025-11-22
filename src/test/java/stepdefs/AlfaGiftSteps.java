package stepdefs;

import drivers.AppDriver;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AlfaGiftSteps {

    String originalName;

    @Given("the user launches the app")
    public void launchApp() throws Exception {
        AppDriver.start();
    }

    @When("the user already logged in, open the profile menu")
    public void openProfileMenu() {
        // Open side menu
        AppDriver.getDriver().findElement(By.xpath("//android.view.View[@resource-id=\"com.alfamart.alfagift:id/clickable_account\"]")).click();
    }

    @And("the user click its profile")
    public void clickProfile() {
        AppDriver.getDriver().findElement(By.xpath("//android.widget.ImageView[@resource-id=\"com.alfamart.alfagift:id/iv_edit\"]")).click();
    }

    @And("the user click Changes profile info")
    public void clickChangeProfileInfo() {
        // Save the current name BEFORE editing
        originalName = AppDriver.getDriver()
                .findElement(By.xpath("//android.widget.TextView[@text=\"Yusack Manuel\"]"))
                .getText();

        AppDriver.getDriver().findElement(By.xpath("(//android.widget.TextView[@text=\"Ubah\"])[1]")).click();
    }

    @And("the user click back")
    public void clickBack() {
        AndroidDriver driver = AppDriver.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);

        // Back button #1
        String back1 = "//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View[1]/android.widget.Button";

        // Back button #2
        String back2 = "//android.view.ViewGroup/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[2]/android.widget.Button";

        try {
            // CLICK BACK #1
            WebElement backBtn1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(back1)));
            backBtn1.click();
            System.out.println("Clicked BACK #1");
        } catch (Exception e) {
            throw new RuntimeException("Back button #1 not found!");
        }

        // Wait for the second screen to load (Compose transitions need time)
        try {
            Thread.sleep(1000); // Optional small wait to let screen animate
        } catch (InterruptedException ignored) {}

        try {
            // CLICK BACK #2
            WebElement backBtn2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(back2)));
            backBtn2.click();
            System.out.println("Clicked BACK #2");
        } catch (Exception e) {
            throw new RuntimeException("Back button #2 not found!");
        }
    }

    @Then("the name should be still the same")
    public void verifyNameUnchanged() {
        String currentName = AppDriver.getDriver()
                .findElement(By.xpath("//android.widget.TextView[@text=\"Yusack Manuel\"]"))
                .getText();

        Assert.assertEquals(currentName, originalName,
                "Name changed even though user pressed Back!");
    }
}
