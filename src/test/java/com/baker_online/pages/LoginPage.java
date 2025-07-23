package com.baker_online.pages;

import com.baker_online.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "[name='username'], [name='email'], [type='email'], [placeholder*='email'], [id*='email']")
    public WebElement emailInputBox;

    @FindBy(css = "[name='password']")
    public WebElement passwordInputBox;

    @FindBy(css = "[type='submit']")
    public WebElement loginButton;

    @FindBy(css = "header .error")
    public WebElement errorMessage;
}
