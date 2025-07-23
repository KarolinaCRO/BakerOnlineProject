package com.baker_online.pages;

import com.baker_online.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

    public RegisterPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "[name='email']")
    public WebElement emailInputBox;

    @FindBy(css = "[name='firstname']")
    public WebElement firstNameInputBox;

    @FindBy(css = "[name='password']")
    public WebElement passwordInputBox;

    @FindBy(css = "[name='lastname']")
    public WebElement lastNameInputBox;

    @FindBy(css = "[name='password-repeat']")
    public WebElement repeatPasswordInputBox;

    @FindBy(css = "[name='telephone']")
    public WebElement phoneInputBox;

    @FindBy(css = "*[class='button fill main']")
    public WebElement createAccountButton;

    @FindBy(xpath = "//*[text()='I read and accept these terms']")
    public WebElement acceptTermsButton;

    @FindBy(xpath = "//*[text()='I took notice of the privacy policy']")
    public WebElement acceptPrivacyPolicyButton;

    @FindBy(xpath = "//*[text()='Hurray! Your account has been created.']")
    public WebElement registrationSuccessMessage; //TODO: change the locator

    @FindBy(css = ".error li")
    public WebElement emailAlreadyInUseMessage;
}
