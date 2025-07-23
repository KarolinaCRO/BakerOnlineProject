package com.baker_online.pages;

import com.baker_online.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage {

    public ForgotPasswordPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "[name='email']")
    public WebElement emailInputBox;

    @FindBy(css = "[type='submit']")
    public WebElement sendButton;

    @FindBy(css = "a.button[href*='forgot-password']")
    public WebElement forgotPasswordLink;
    
    @FindBy(css = "ul[class='success']")
    public WebElement confirmationMessage;
}
