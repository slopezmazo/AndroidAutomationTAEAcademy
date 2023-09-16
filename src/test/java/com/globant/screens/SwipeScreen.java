package com.globant.screens;

import com.globant.util.screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SwipeScreen extends BaseScreen {
    @AndroidFindBy(xpath = "//android.widget.ScrollView[@content-desc=\"Swipe-screen\"]/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView")
    private AndroidElement swipeTitle;
    public SwipeScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    public String getSwipeTitle(){
        return swipeTitle.getText();
    }
}
