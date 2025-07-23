package com.baker_online.pages;

import com.baker_online.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OrderPage {

    public OrderPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//*[@data-tms-product-list='product list']//button)[4]") //(//*[text()='Order'])[2]
    public WebElement orderButton;

    @FindBy(xpath = "//*[contains(@href, 'checkout')]")
    public WebElement orderButtonInTheCart;

    @FindBy(id = "test-next")
    public WebElement continueButton;

    @FindBy(id = "test-calendar-date")
    public WebElement pickupDateBox;

    @FindBy(css = "[class='days'] [class='available']")
    public List<WebElement> availableDates;

    @FindBy(css = "[class='test-hours'] [class='available']")
    public List<WebElement> availableHours;

    @FindBy(css = "[class='test-minutes'] [class='available']")
    public List<WebElement> availableMinutes;

    @FindBy(id = "test-payment-method-0")
    public WebElement paymentAtPickupMethod;

    @FindBy(id = "test-pay-submit")
    public WebElement placeOrderButton;
}
