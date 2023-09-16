package com.globant.util.tests;

import com.globant.Reporter;
import com.globant.util.ConfigCapabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.net.MalformedURLException;
import java.net.URL;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class BaseMobileTest extends Reporter {

	public static AndroidDriver<AndroidElement> driver;

	@BeforeMethod(alwaysRun = true)
	public void environmentSetUp() {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		ConfigCapabilities.deviceSetUp(capabilities);
		ConfigCapabilities.applicationSetUp(capabilities);
		try {
			driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723"), capabilities);
		} catch (MalformedURLException exception) {
			exception.printStackTrace();
		}
		setUpStartApp();
	}

	private void setUpStartApp() {
	}

	@AfterMethod(alwaysRun = true)
	public void mobileApplicationEnd() {
		// driver.quit();
	}
	public AndroidDriver<AndroidElement> getDriver() {
		return driver;
	}
}
