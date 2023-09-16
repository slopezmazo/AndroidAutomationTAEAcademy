package com.globant.screens;

import com.globant.util.screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class DragScreen extends BaseScreen {
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Drag-drop-screen\"]/android.view.ViewGroup[1]/android.widget.TextView")
    private AndroidElement dragTitle;
    public DragScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }
    public String getDragTitle(){
        return dragTitle.getText();
    }
}
