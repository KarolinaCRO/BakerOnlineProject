package com.baker_online.step_definitions;

import com.baker_online.pages.HomePage;
import com.baker_online.pages.RegisterPage;
import com.baker_online.utilities.ConfigurationReader;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class Register_StepDefinitions {

    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();
    Faker faker = new Faker();
    String password;

    @When("user clicks the REGISTER link")
    public void user_clicks_the_register_link() {
        homePage.registerLink.click();
    }

    @When("user fills out the registration form with valid data")
    public void user_fills_out_the_registration_form_with_valid_data() {
        registerPage.emailInputBox.sendKeys(faker.internet().emailAddress());
        registerPage.firstNameInputBox.sendKeys(faker.name().firstName());
        password = faker.internet().password(6, 64, true, true, true);
        registerPage.passwordInputBox.sendKeys(password);
        registerPage.lastNameInputBox.sendKeys(faker.name().lastName());
        registerPage.repeatPasswordInputBox.sendKeys(password);
        registerPage.phoneInputBox.sendKeys(faker.numerify("0481######"));
    }

    @When("user accepts the terms and conditions")
    public void user_accepts_the_terms_and_conditions() {
        registerPage.acceptTermsButton.click();
    }

    @When("user acknowledges the privacy policy")
    public void user_acknowledges_the_privacy_policy() {
        registerPage.acceptPrivacyPolicyButton.click();
    }

    @When("user clicks the CREATE ACCOUNT button")
    public void user_clicks_the_create_account_button() {
        registerPage.createAccountButton.click();
    }

    @Then("a success message {string} should be displayed")
    public void a_success_message_should_be_displayed(String successMessage) {
        assertEquals(successMessage, registerPage.registrationSuccessMessage.getText());
    }

    @When("user fills out the registration form with already registered email")
    public void user_fills_out_the_registration_form_with_already_registered_email() {
        registerPage.emailInputBox.sendKeys(ConfigurationReader.getProperty("registered_user_email"));
        registerPage.firstNameInputBox.sendKeys(faker.name().firstName());
        password = faker.internet().password(6, 64, true, true, true);
        registerPage.passwordInputBox.sendKeys(password);
        registerPage.lastNameInputBox.sendKeys(faker.name().lastName());
        registerPage.repeatPasswordInputBox.sendKeys(password);
        registerPage.phoneInputBox.sendKeys(faker.numerify("0481######"));
    }

    @Then("email duplication error message {string} should be displayed")
    public void email_duplication_error_message_should_be_displayed(String expectedEmailDuplicationMessage) {
        assertTrue(registerPage.emailAlreadyInUseMessage.isDisplayed());
        assertEquals(expectedEmailDuplicationMessage, registerPage.emailAlreadyInUseMessage.getText());
    }
}
