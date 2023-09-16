package com.globant.util.screens;

import com.globant.Reporter;
import com.globant.util.CustomWait;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;
import com.globant.screens.AlertHandler;

import static java.lang.String.format;

import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BaseScreen extends Reporter{
	
	/** The custom wait. */
	protected CustomWait customWait = new CustomWait();
	
	/** The driver. */
	protected final AndroidDriver<AndroidElement> driver;

	@AndroidFindBy(accessibility = "Home")
	protected AndroidElement homeButton;
	@AndroidFindBy(accessibility = "Webview")
	protected AndroidElement webviewButton;
	@AndroidFindBy(accessibility = "Login")
	protected AndroidElement loginButton;
	@AndroidFindBy(accessibility = "Forms")
	protected AndroidElement formsButton;
	@AndroidFindBy(accessibility = "Swipe")
	protected AndroidElement swipeButton;
	@AndroidFindBy(accessibility = "Drag")
	protected AndroidElement dragButton;

	public BaseScreen(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(15)), this);
	}

	/**
	 * Tab on back button.
	 * 
	 * @author Arley.Bolivar
	 */
	public void tapBack() {
		// driver.pressKeyCode(AndroidKeyCode.BACK);
		driver.navigate()
		.back();
	}

	public void scrollDown(int swipes) {
		String locator = "new UiScrollable(new UiSelector().resourceIdMatches(\".*ontainer.*\")).flingToEnd(1)";
		scroll(locator, swipes);
	}

	public void scrollUp(int swipes) {
		String locator = "new UiScrollable(new UiSelector().resourceIdMatches(\".*ontainer.*\")).flingToBeginning(1)";
		scroll(locator, swipes);
	}

	public void scroll(String locator, int swipes) {
		int swipesAmount = 0;
		while (swipesAmount < swipes) {
			try {
				driver.findElementByAndroidUIAutomator(locator);
				swipesAmount++;
			} catch (Exception e) {
				swipesAmount++;
			}
		}
	}

	@SuppressWarnings({ "rawtypes", "unused" })
	public void swipeVertical (float percentage) {
		Dimension windowSize = driver.manage().window().getSize();
		TouchAction ta = new TouchAction(driver);
		ta.press(PointOption.point(207, 582)).moveTo(PointOption.point(8, 
				-360)).release().perform();
	}

	public void scrollToText(String text) {
		String automator = "new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().textContains(\"%s\"))";
		AndroidElement textOnElement = driver.findElementByAndroidUIAutomator(format(automator, text));
		logInfo(textOnElement.getText());
	}

	public void click(AndroidElement element, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver,timeout);
		wait.until(ExpectedConditions.visibilityOf(element));
		element.click();
	}

	public void click(AndroidElement element) {
		WebDriverWait wait = new WebDriverWait(driver,15);
		wait.until(ExpectedConditions.visibilityOf(element));
		element.click();
	}

	public void sendKeys(AndroidElement element, String sequence) {
		WebDriverWait wait = new WebDriverWait(driver,15);
		wait.until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(sequence);
	}

	public boolean isElementAvailable(AndroidElement element) {
		WebDriverWait wait = new WebDriverWait(driver,15);
		wait.until(ExpectedConditions.visibilityOf(element));
		return true;
	}

	public void clickBottomMenuOption(String button){
		switch (button){
			case "home":
				click(homeButton);
				break;
			case "webview":
				click(webviewButton);
				break;
			case "login":
				click(loginButton);
				break;
			case "forms":
				click(formsButton);
				break;
			case "swipe":
				click(swipeButton);
				break;
			case "drag":
				click(dragButton);
				break;
			default:
				logWarning("ïnvalid bottom menu option");
		}

	}
	
}
