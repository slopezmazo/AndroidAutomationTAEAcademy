package com.globant.screens;

import com.globant.util.screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FormsScreen extends BaseScreen {
    @AndroidFindBy(xpath = "//android.widget.ScrollView[@content-desc=\"Forms-screen\"]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView")
    private AndroidElement formsTitle;

    public FormsScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
//        WebDriverWait wait = new WebDriverWait(driver,30);
//        wait.until(ExpectedConditions.visibilityOf(formsTitle));
    }
    public String getFormsTitle(){
        return formsTitle.getText();
    }
}
