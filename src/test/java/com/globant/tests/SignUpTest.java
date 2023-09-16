package com.globant.tests;

import com.globant.screens.HomeScreen;
import com.globant.screens.LoginScreen;
import com.globant.util.SignUpDataGenerator;
import com.globant.util.tests.BaseMobileTest;
import org.testng.Assert;
import org.testng.annotations.Test;
public class SignUpTest extends BaseMobileTest {

    @Test
    public void SignUpTest(){
        String  HOMESCREEN_TITLE = "WEBDRIVER";
        String  LOGINSCREEN_TITLE = "Login / Sign up Form";
        String  SIGNUP_SUCCESS_MESSAGE = "You successfully signed up!";
        String email = SignUpDataGenerator.getEmail();
        String password = SignUpDataGenerator.getPassword();


        // Home screen loading
        HomeScreen home =  new HomeScreen(driver);
        Assert.assertEquals(home.getHomeTitle(),HOMESCREEN_TITLE);
        logInfo("Home screen instantiated correctly");
        home.clickBottomMenuOption("login");
        logInfo("Redirecting to login screen");

        // Login screen loading
        LoginScreen loginScreen =  new LoginScreen(driver);
        Assert.assertEquals(loginScreen.getLoginTitle(),LOGINSCREEN_TITLE);
        logInfo("login screen loaded successfully");

        // Sign up filling
        loginScreen.clickSingUpOption();
        logInfo("filling in sign up data");
        loginScreen.fillInSignUpData(email,password,password);
        Assert.assertEquals(loginScreen.getSignUpPopUpMessage(),SIGNUP_SUCCESS_MESSAGE);
        logInfo("Successful sign Up");

        //End of testing
        loginScreen.clickSignUpPopUpButton();
        logInfo("End of test...");
    }
}

