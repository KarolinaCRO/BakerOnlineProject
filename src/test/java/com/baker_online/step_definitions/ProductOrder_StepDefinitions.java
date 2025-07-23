package com.baker_online.step_definitions;

import com.baker_online.pages.HomePage;
import com.baker_online.pages.OrderPage;
import com.baker_online.pages.SearchPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.baker_online.utilities.BrowserUtils.*;
import static org.junit.Assert.assertTrue;

public class ProductOrder_StepDefinitions {

    OrderPage orderPage = new OrderPage();
    HomePage homePage = new HomePage();
    SearchPage searchPage = new SearchPage();

    @When("user clicks ORDER button button on the product")
    public void user_clicks_order_button_button_on_the_product() {
        waitForClickability(orderPage.orderButton, 20);
        orderPage.orderButton.click();
        waitForVisibility(searchPage.productPrice, 15);
    }

    @When("user opens the cart")
    public void user_opens_the_cart() {
        homePage.cartLink.click();
    }

    @When("user clicks ORDER button in the cart")
    public void user_clicks_order_button_in_the_cart() {
        waitForClickability(orderPage.orderButtonInTheCart, 20);
        orderPage.orderButtonInTheCart.click();
    }

    @When("user clicks the + button")
    public void user_clicks_the_button() {
        searchPage.addQuantityButton.click();
    }

    @When("user clicks CONTINUE button")
    public void user_clicks_continue_button() {
        waitForClickability(orderPage.continueButton, 20);
        orderPage.continueButton.click();
    }

    @When("user selects the first available pickup date")
    public void user_selects_the_first_available_pickup_date() {
        waitForClickability(orderPage.pickupDateBox, 20);
        orderPage.pickupDateBox.click();
        waitForClickability(orderPage.availableDates.get(0), 20);
        orderPage.availableDates.get(0).click();
    }

    @When("the user selects the first available pickup time")
    public void the_user_selects_the_first_available_pickup_time() {
        waitForClickability(orderPage.availableHours.get(0), 20);
        orderPage.availableHours.get(0).click();
        waitForClickability(orderPage.availableMinutes.get(0), 20);
        orderPage.availableMinutes.get(0).click();
    }

    @When("user selects Payment at pickup as payment method")
    public void user_selects_payment_at_pickup_as_payment_method() {
        waitForClickability(orderPage.paymentAtPickupMethod, 15);
        orderPage.paymentAtPickupMethod.click();
    }

    @Then("the PLACE ORDER button should be visible")
    public void the_place_order_button_should_be_visible() {
        waitForVisibility(orderPage.placeOrderButton, 15);
        assertTrue(orderPage.placeOrderButton.isDisplayed());
    }
}
