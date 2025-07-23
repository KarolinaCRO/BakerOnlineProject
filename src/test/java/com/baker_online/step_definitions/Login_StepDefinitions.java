package com.baker_online.step_definitions;

import com.baker_online.pages.HomePage;
import com.baker_online.pages.LoginPage;
import com.baker_online.utilities.ConfigurationReader;
import com.baker_online.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.baker_online.utilities.BrowserUtils.isElementVisible;
import static com.baker_online.utilities.BrowserUtils.waitForVisibility;
import static org.junit.Assert.*;

public class Login_StepDefinitions {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    String registeredUserEmail = ConfigurationReader.getProperty("registered_user_email");
    String registeredUserPassword = ConfigurationReader.getProperty("registered_user_password");

    @Given("user is on the home page")
    public void user_is_on_the_home_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("environment"));
        if (isElementVisible(homePage.acceptCookies)) {
            homePage.acceptCookies.click();
        }
    }

    @When("user clicks the LOG IN link")
    public void user_clicks_the_log_in_link() {
        homePage.loginLink.click();
    }

    @When("user enters a valid email in the email field")
    public void user_enters_a_valid_email_in_the_email_field() {
        loginPage.emailInputBox.sendKeys(registeredUserEmail);
    }

    @When("user enters a valid password in the password field")
    public void user_enters_a_valid_password_in_the_password_field() {
        loginPage.passwordInputBox.sendKeys(registeredUserPassword);
    }

    @When("user clicks the LOGIN button in the login form")
    public void user_clicks_the_login_button_in_the_login_form() {
        loginPage.loginButton.click();
    }

    @Then("user is logged in and user account menu displays the user's name")
    public void user_is_logged_in_and_user_account_menu_displays_the_user_s_name() {
        waitForVisibility(homePage.accountMenu, 15);
        assertEquals(ConfigurationReader.getProperty("registered_user_firstname").toUpperCase(), homePage.accountMenu.getText());
    }

    @When("user enters {string} in the email field")
    public void user_enters_in_the_email_field(String email) {
        switch (email) {
            case "valid" -> loginPage.emailInputBox.sendKeys(registeredUserEmail);
            case "invalid" -> loginPage.emailInputBox.sendKeys("invalid@email.com");
        }
    }

    @When("user enters {string} in the password field")
    public void user_enters_in_the_password_field(String password) {
        switch (password) {
            case "valid" -> loginPage.passwordInputBox.sendKeys(registeredUserPassword);
            case "invalid" -> loginPage.passwordInputBox.sendKeys("invalid123");
        }
    }

    @Then("an error message {string} should be displayed")
    public void an_error_message_should_be_displayed(String errorMessage) {
        assertTrue(loginPage.errorMessage.isDisplayed());
        assertEquals(errorMessage, loginPage.errorMessage.getText());
    }

    @Then("user is not logged in")
    public void user_is_not_logged_in() {
        assertEquals(false, isElementVisible(homePage.accountMenu));
    }

    @When("user leaves the email field empty")
    public void user_leaves_the_email_field_empty() {
        loginPage.emailInputBox.sendKeys("");
    }

    @Then("the {string} field should display the validation message {string}")
    public void the_field_should_display_the_validation_message(String fieldName, String expectedMessage) {
        switch (fieldName) {
            case "email" -> {
                assertTrue(loginPage.emailInputBox.getAttribute("value").isEmpty());
                assertEquals(expectedMessage, loginPage.emailInputBox.getAttribute("validationMessage"));
            }
            case "password" -> {
                assertTrue(loginPage.passwordInputBox.getAttribute("value").isEmpty());
                assertEquals(expectedMessage, loginPage.passwordInputBox.getAttribute("validationMessage"));
            }
        }
    }

    @When("user leaves the password field empty")
    public void user_leaves_the_password_field_empty() {
        loginPage.passwordInputBox.sendKeys("");
    }
}
