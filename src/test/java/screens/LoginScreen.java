package screens;

import static io.appium.java_client.pagefactory.LocatorGroupStrategy.ALL_POSSIBLE;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import util.screens.BaseScreen;

// TODO: Auto-generated Javadoc
/**
 * DashBoard screen.
 * 
 * @author Hans.Marquez
 *
 */
public class LoginScreen extends BaseScreen {

	/**
	 * Constructor method.
	 *
	 * @author Hans.Marquez
	 * @param driver the driver
	 */
	public LoginScreen(AndroidDriver<AndroidElement> driver) {
		super(driver);
	}

	
	/** The sign in button. */
	@HowToUseLocators(androidAutomation = ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*:id/btn_login\")")
	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.Button\").textContains(\"Sign\")")
    private AndroidElement signInButton;
	
	/** The user text box. */
	@HowToUseLocators(androidAutomation = ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*:id/email_id\")")
    private AndroidElement userTextBox;
	
	/** The password text box. */
	@HowToUseLocators(androidAutomation = ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*:id/password_id\")")
    private AndroidElement passwordTextBox;
	
	

	/**
	 * Fill in login data.
	 *
	 * @param user     :String
	 * @param password :String
	 */
	public void fillInLoginData(String user, String password) {
		sendKeys(userTextBox, user);
		sendKeys(passwordTextBox, password);
		click(signInButton);
	}


	/**
	 * Alert control.
	 */
	@Override
	public void alertControl() {
		// TODO Auto-generated method stub
		
	}

}
