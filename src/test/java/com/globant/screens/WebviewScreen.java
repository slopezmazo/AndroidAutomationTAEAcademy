package com.globant.screens;

import com.globant.util.screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class WebviewScreen extends BaseScreen {
    @AndroidFindBy(accessibility = "Get Stated")
    private AndroidElement getStartedButton;
    public WebviewScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    public String getGetStartedButton() {
        return getStartedButton.getText();
    }
}
