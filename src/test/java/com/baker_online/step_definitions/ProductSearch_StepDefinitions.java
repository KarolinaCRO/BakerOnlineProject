package com.baker_online.step_definitions;

import com.baker_online.pages.ArtisanResultsPage;
import com.baker_online.pages.HomePage;
import com.baker_online.pages.SearchPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;


import static com.baker_online.utilities.BrowserUtils.waitForClickability;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ProductSearch_StepDefinitions {

    HomePage homePage = new HomePage();
    ArtisanResultsPage artisanResultsPage = new ArtisanResultsPage();
    SearchPage searchPage = new SearchPage();

    @When("user searches for artisan {string}")
    public void user_searches_for_artisan(String artisanName) {
        waitForClickability(homePage.searchBoxInput, 20);
        homePage.searchBoxInput.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        homePage.searchBoxInput.sendKeys(Keys.BACK_SPACE);
        homePage.searchBoxInput.sendKeys(artisanName + Keys.ENTER);
    }

    @When("user clicks SHOP NOW button")
    public void user_clicks_shop_now_button() {
        artisanResultsPage.shopNowButton.click();
    }

    @When("user searches for {string}")
    public void user_searches_for(String product) {
        waitForClickability(searchPage.searchBoxInput, 20);
        searchPage.searchBoxInput.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        searchPage.searchBoxInput.sendKeys(Keys.BACK_SPACE);
        searchPage.searchBoxInput.sendKeys(product + Keys.ENTER);
    }

    @Then("search results containing {string} in the product name are displayed")
    public void search_results_containing_in_the_product_name_are_displayed(String product) {
        for (WebElement productHeader : searchPage.productHeaders) {
            assertTrue(productHeader.getText().contains(product));
        }
    }

    @Then("only the product with the name {string} is displayed in the search results")
    public void only_the_product_with_the_name_is_displayed_in_the_search_results(String product) {
        for (WebElement productHeader : searchPage.productHeaders) {
            assertTrue(productHeader.getText().equalsIgnoreCase(product));
        }
    }

    @Then("a message {string} is displayed")
    public void a_message_is_displayed(String message) {
        assertTrue(searchPage.searchNoResultsMessage.isDisplayed());
        assertEquals(message, searchPage.searchNoResultsMessage.getText());
    }
}
