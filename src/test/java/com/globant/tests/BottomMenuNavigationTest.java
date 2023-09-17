package com.globant.tests;


import com.globant.screens.*;
import com.globant.util.tests.BaseMobileTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BottomMenuNavigationTest extends BaseMobileTest {
    @Test
    public void bottomMenuNavigationTest(){
        String  HOMESCREEN_TITLE = "WEBDRIVER";
        String  WEBVIEWSCREEN_TEXT = "Next-gen browser and mobile automation test framework for Node.js";
        String  LOGINSCREEN_TITLE = "Login / Sign up Form";
        String  FORMSSCREEN_TITLE = "Form components";
        String  SWIPESCREEN_TITLE = "Swipe horizontal";
        String  DRAGSCREEN_TITLE = "Drag and Drop";

        //Home screen accessing
        HomeScreen home =  new HomeScreen(driver);
        Assert.assertEquals(home.getHomeTitle(),HOMESCREEN_TITLE);
        logInfo("Home screen instantiated correctly");
        home.clickBottomMenuOption("webview");
        logInfo("Redirecting to webview screen");

        //webview screen accessing
        WebviewScreen webview = new WebviewScreen(driver);
        Assert.assertEquals(webview.getWebviewText(),WEBVIEWSCREEN_TEXT);
        logInfo("webview screen loaded successfully");
        webview.clickBottomMenuOption("login");
        logInfo("Redirecting to login screen");

        //login screen accessing
        LoginScreen login = new LoginScreen(driver);
        Assert.assertEquals(login.getLoginTitle(),LOGINSCREEN_TITLE);
        logInfo("login screen loaded successfully");
        webview.clickBottomMenuOption("forms");
        logInfo("Redirecting to forms screen");

        //forms screen accessing
        FormsScreen forms = new FormsScreen(driver);
        Assert.assertEquals(forms.getFormsTitle(),FORMSSCREEN_TITLE);
        logInfo("forms screen loaded successfully");
        webview.clickBottomMenuOption("swipe");
        logInfo("Redirecting to swipe screen");

        //swipe screen accessing
        SwipeScreen swipe = new SwipeScreen(driver);
        Assert.assertEquals(swipe.getSwipeTitle(),SWIPESCREEN_TITLE);
        logInfo("swipe screen loaded successfully");
        webview.clickBottomMenuOption("drag");
        logInfo("Redirecting to drag screen");

        //drag screen accessing
        DragScreen drag = new DragScreen(driver);
        Assert.assertEquals(drag.getDragTitle(),DRAGSCREEN_TITLE);
        logInfo("drag screen loaded successfully");
        logInfo("End of testing");
    }
}
