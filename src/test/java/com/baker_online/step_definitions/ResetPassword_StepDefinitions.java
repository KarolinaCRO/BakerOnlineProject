package com.baker_online.step_definitions;

import com.baker_online.pages.ForgotPasswordPage;
import com.baker_online.pages.HomePage;
import com.baker_online.pages.LoginPage;
import com.baker_online.pages.ResetPasswordPage;
import com.baker_online.utilities.ConfigurationReader;
import com.baker_online.utilities.Driver;
import com.baker_online.utilities.MailSlurpUtils;
import com.mailslurp.models.Email;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.baker_online.utilities.BrowserUtils.isElementVisible;
import static com.baker_online.utilities.BrowserUtils.waitForVisibility;
import static org.junit.Assert.assertTrue;

public class ResetPassword_StepDefinitions {

    private HomePage homePage = new HomePage();
    private LoginPage loginPage = new LoginPage();
    private ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();
    private ResetPasswordPage resetPasswordPage = new ResetPasswordPage();
    private Email resetEmail;
    private String newPassword = "NewPassword123*";

    @When("user clicks on the Forgot password? link")
    public void user_clicks_on_the_forgot_password_link() {
        forgotPasswordPage.forgotPasswordLink.click();
    }

    @And("user enters the registered email address in the forgot password form")
    public void userEntersTheRegisteredEmailAddressInTheForgotPasswordForm() {
        forgotPasswordPage.emailInputBox.sendKeys(ConfigurationReader.getProperty("mailslurp.email"));
    }

    @And("user clicks the send button")
    public void userClicksTheSendButton() {
        forgotPasswordPage.sendButton.click();
    }

    @Then("user should see a confirmation message")
    public void userShouldSeeAConfirmationMessage() {
        assertTrue(isElementVisible(forgotPasswordPage.confirmationMessage));
    }

    @When("user receives a password reset email")
    public void userReceivesAPasswordResetEmail() {
        resetEmail = MailSlurpUtils.waitForPasswordResetEmail();
        Assert.assertNotNull("No password reset email received", resetEmail);
    }

    @And("user clicks on the reset password link in the email")
    public void userClicksOnTheResetPasswordLinkInTheEmail() {
        String resetLink = MailSlurpUtils.extractResetLink(resetEmail);
        Driver.getDriver().get(resetLink);
    }

    @And("user enters a new password and confirms it")
    public void userEntersANewPasswordAndConfirmsIt() {
        resetPasswordPage.newPasswordInputBox.sendKeys(newPassword);
        resetPasswordPage.confirmPasswordInputBox.sendKeys(newPassword);
    }

    @And("user clicks the reset password button")
    public void userClicksTheResetPasswordButton() {
        resetPasswordPage.resetPasswordButton.click();
    }

    @Then("user is logged in again")
    public void user_is_logged_in_again() {
        waitForVisibility(homePage.accountMenu, 20);
        assertTrue(homePage.accountMenu.isDisplayed());
    }
}
