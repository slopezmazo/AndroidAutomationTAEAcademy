package com.globant.screens;

import com.globant.util.screens.BaseScreen;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.Dimension;

import java.util.List;

public class SwipeScreen extends BaseScreen {
    @AndroidFindBy(xpath = "//android.widget.ScrollView[@content-desc=\"Swipe-screen\"]/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView")
    private AndroidElement swipeTitle;
    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"card\"])[1]")
    private AndroidElement cardOne;
    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"card\"])[2]")
    private AndroidElement cardTwo;
    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"card\"])[3]")
    private AndroidElement cardThree;


    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Carousel\"]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup")
    private AndroidElement dotOne;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Carousel\"]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup")
    private AndroidElement dotTwo;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Carousel\"]/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup")
    private AndroidElement dotThree;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Carousel\"]/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup")
    private AndroidElement dotFour;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Carousel\"]/android.view.ViewGroup/android.view.ViewGroup[5]/android.view.ViewGroup")
    private AndroidElement dotFive;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Carousel\"]/android.view.ViewGroup/android.view.ViewGroup[6]/android.view.ViewGroup")
    private AndroidElement dotSix;


    public SwipeScreen(AndroidDriver<AndroidElement> driver) {
        super (driver);
    }

    public String getSwipeTitle() {
        return swipeTitle.getText ();
    }

    public void swipeRight() {
        swipeHorizontal (cardOne, -100, 0);
    }

    public void swipeLeft() {
        swipeHorizontal (cardTwo, 100, 0);
    }

    public Dimension getElementSize(AndroidElement element) {
        return element.getSize ();
    }

    public Dimension[] getCardSize() {
        return new Dimension[]{
                getElementSize (cardOne),
                getElementSize (cardTwo)
        };
    }

    public Dimension[] getDotsSize() {
        return new Dimension[]{
                getElementSize (dotOne),
                getElementSize (dotTwo),
                getElementSize (dotThree),
                getElementSize (dotFour),
                getElementSize (dotFive),
                getElementSize (dotSix)
        };
    }

}
