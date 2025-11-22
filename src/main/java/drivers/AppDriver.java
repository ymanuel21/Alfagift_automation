package drivers;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class AppDriver {

    private static AndroidDriver driver;

    // Change this to switch target
    public static AppTarget TARGET = AppTarget.SAUCE_EMULATOR; 
    // public static AppTarget TARGET = AppTarget.ALFAGIFT_REAL;

    public static void start() throws Exception {
        if (driver != null) return;

        DesiredCapabilities caps = new DesiredCapabilities();

        /// -----------------------------------------------------------
        /// CASE 1 — EMULATOR (Sauce Demo)
        /// -----------------------------------------------------------
        if (TARGET == AppTarget.SAUCE_EMULATOR) {
            caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            caps.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
            caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

            // APK
            caps.setCapability(MobileCapabilityType.APP,
                    "C:/Users/USER/Downloads/Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");

            caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.swaglabsmobileapp");
            caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,
                    "com.swaglabsmobileapp.MainActivity");

            caps.setCapability(MobileCapabilityType.NO_RESET, false);
        }

        /// -----------------------------------------------------------
        /// CASE 2 — REAL DEVICE (Alfagift)
        /// -----------------------------------------------------------
        else if (TARGET == AppTarget.ALFAGIFT_REAL) {

            caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

            // Your real device ID
            caps.setCapability(MobileCapabilityType.DEVICE_NAME, "RR8M50FZMMR");
            caps.setCapability(MobileCapabilityType.UDID, "RR8M50FZMMR");

            // Installed from Play Store → DO NOT set APP
            caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.alfamart.alfagift");
            caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,
                    "com.alfamart.alfagift.screen.splash.SplashActivityDefault");

            caps.setCapability(MobileCapabilityType.NO_RESET, true);
            caps.setCapability("autoGrantPermissions", true);
        }

        /// -----------------------------------------------------------

        caps.setCapability("newCommandTimeout", 300);

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), caps);
    }

    public static AndroidDriver getDriver() {
        return driver;
    }

    public static void quit() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
