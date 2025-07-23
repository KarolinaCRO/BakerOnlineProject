package com.baker_online.step_definitions;

import com.baker_online.pages.AccountMenuPage;
import com.baker_online.pages.HomePage;
import com.baker_online.pages.LoginPage;
import com.baker_online.utilities.ConfigurationReader;
import com.baker_online.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.baker_online.utilities.BrowserUtils.isElementVisible;
import static com.baker_online.utilities.BrowserUtils.waitForClickability;
import static org.junit.Assert.*;

public class LogOut_StepDefinitions {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    AccountMenuPage accountMenuPage = new AccountMenuPage();

    @Given("user is logged in")
    public void user_is_logged_in() {
        Driver.getDriver().get(ConfigurationReader.getProperty("login_page"));
        if (isElementVisible(homePage.acceptCookies)) {
            homePage.acceptCookies.click();
        }
        loginPage.emailInputBox.sendKeys(ConfigurationReader.getProperty("registered_user_email"));
        loginPage.passwordInputBox.sendKeys(ConfigurationReader.getProperty("registered_user_password"));
        loginPage.loginButton.click();
    }

    @When("user opens the account menu")
    public void user_opens_the_account_menu() {
        waitForClickability(homePage.accountMenu, 15);
        homePage.accountMenu.click();
    }

    @When("selects the LOG OUT option")
    public void selects_the_log_out_option() {
        accountMenuPage.logOutLink.click();
    }

    @Then("user is logged out")
    public void user_is_logged_out() {
        assertEquals(false, isElementVisible(homePage.accountMenu));
    }

    @Then("the LOG IN option is visible")
    public void the_log_in_option_is_visible() {
        assertEquals(true, isElementVisible(homePage.loginLink));
    }
}
