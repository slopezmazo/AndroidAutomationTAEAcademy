package com.globant.screens;

import static io.appium.java_client.pagefactory.LocatorGroupStrategy.ALL_POSSIBLE;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import com.globant.util.screens.BaseScreen;

// TODO: Auto-generated Javadoc
/**
 * DashBoard screen.
 * 
 * @author Hans.Marquez
 *
 */
public class LoginScreen extends BaseScreen {
	public LoginScreen(AndroidDriver<AndroidElement> driver) {
		super(driver);
	}

	@AndroidFindBy(xpath = "//android.widget.ScrollView[@content-desc=\"Login-screen\"]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView")
    private AndroidElement loginTitle;
	@AndroidFindBy(xpath ="//android.view.ViewGroup[@content-desc=\"button-sign-up-container\"]/android.view.ViewGroup/android.widget.TextView")
	private AndroidElement signUpOption;
	@AndroidFindBy(xpath ="//android.view.ViewGroup[@content-desc=\"button-login-container\"]/android.view.ViewGroup/android.widget.TextView")
	private AndroidElement loginOption;
	@AndroidFindBy(accessibility = "input-email")
    private AndroidElement loginMailInput;
	@AndroidFindBy(accessibility = "input-password")
    private AndroidElement loginPasswordInput;
	@AndroidFindBy(accessibility = "input-repeat-password")
    private AndroidElement loginRepeatPasswordInput;
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"button-LOGIN\"]/android.view.ViewGroup")
    private AndroidElement loginLoginButton;
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"button-SIGN UP\"]/android.view.ViewGroup")
    private AndroidElement loginSignUpButton;
	@AndroidFindBy(id = "android:id/message")
	private AndroidElement signUpPopUpMessage;
	@AndroidFindBy(id = "android:id/button1")
	private AndroidElement signUpPopUpOkButton;


	public void fillInLoginData(String mail, String password) {
		sendKeys(loginMailInput, mail);
		sendKeys(loginPasswordInput, password);
		click(loginLoginButton);
	}
	public void fillInSignUpData(String mail, String password,String repeatPassword) {
		sendKeys(loginMailInput, mail);
		sendKeys(loginPasswordInput, password);
		sendKeys(loginRepeatPasswordInput, repeatPassword);
		click(loginSignUpButton);
	}
	public String getLoginTitle(){
		return loginTitle.getText();
	}

	public void clickSingUpOption(){
		click(signUpOption);
	}
	public String getSignUpPopUpMessage(){
		return signUpPopUpMessage.getText();
	}
	public void clickSignUpPopUpButton(){
		click(signUpPopUpOkButton);
	}
}
