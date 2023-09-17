package com.globant.util.screens;

import com.globant.Reporter;
import com.globant.util.CustomWait;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.appium.java_client.touch.offset.ElementOption;

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
	public void swipeHorizontal(AndroidElement element, int x, int y) {
		TouchAction touchAction = new TouchAction(driver);
		PointOption swipe = new PointOption();
		swipe.withCoordinates(x,0);

		touchAction.press(ElementOption.element(element))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
				.moveTo(swipe)
				.release()
				.perform();
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
