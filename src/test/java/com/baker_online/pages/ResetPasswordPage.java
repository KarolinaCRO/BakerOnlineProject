package com.baker_online.pages;

import com.baker_online.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResetPasswordPage {

    public ResetPasswordPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "input#page-password, input[name='password']")
    public WebElement newPasswordInputBox;

    @FindBy(css = "input[name='retype-password']")
    public WebElement confirmPasswordInputBox;

    @FindBy(css = "button.button.fill.main[type='submit']")
    public WebElement resetPasswordButton;
}
