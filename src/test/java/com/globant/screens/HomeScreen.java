package com.globant.screens;

import com.globant.util.screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class HomeScreen extends BaseScreen {
    @AndroidFindBy(xpath = "//android.widget.ScrollView[@content-desc=\"Home-screen\"]/android.view.ViewGroup/android.widget.TextView[1]")
    private AndroidElement homeScreenTitle;

    public HomeScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    public String getHomeTitle(){
        return homeScreenTitle.getText();
    }
}
