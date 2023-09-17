package com.globant.tests;

import com.globant.screens.HomeScreen;
import com.globant.screens.SwipeScreen;
import com.globant.util.tests.BaseMobileTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SwipeCardTest extends BaseMobileTest {
    @Test
    public void SwipeCardTest(){
        String HOMESCREEN_TITLE = "WEBDRIVER";
        String SWIPESCREEN_TITLE = "Swipe horizontal";


        // Home screen loading
        HomeScreen home =  new HomeScreen(driver);
        Assert.assertEquals(home.getHomeTitle(),HOMESCREEN_TITLE);
        logInfo("Home screen instantiated correctly");
        home.clickBottomMenuOption("swipe");
        logInfo("Redirecting to swipe screen");

        // Swipe screen loading
        SwipeScreen swipeScreen = new SwipeScreen(driver);
        Assert.assertEquals(swipeScreen.getSwipeTitle (),SWIPESCREEN_TITLE);
        logInfo("Swipe screen loaded successfully");

        // Right Swipe
        swipeScreen.swipeRight();
        Assert.assertTrue(swipeScreen.getCardSize()[0].height < swipeScreen.getCardSize()[1].height);
        Assert.assertTrue (swipeScreen.getDotsSize ()[0].height < swipeScreen.getDotsSize ()[1].height);
        logInfo ("Right swipe successful performed");

        // Left Swipe
        swipeScreen.swipeLeft ();
        Assert.assertTrue(swipeScreen.getCardSize()[0].height > swipeScreen.getCardSize()[1].height);
        Assert.assertTrue (swipeScreen.getDotsSize ()[0].height > swipeScreen.getDotsSize ()[1].height);
        logInfo ("Left swipe successful performed");

        //End of test
        logInfo ("End of test");

    }
}
