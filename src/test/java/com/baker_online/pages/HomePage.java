package com.baker_online.pages;

import com.baker_online.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public HomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@class='visible']//a[text()='Log in']")
    public WebElement loginLink;

    @FindBy(xpath = "//*[@class='visible']//a[text()='Register']")
    public WebElement registerLink;

    @FindBy(css = ".visible .cart-item")
    public WebElement cartLink;

    @FindBy(css = "#test-accept-cookies")
    public WebElement acceptCookies;

    @FindBy(css = ".visible .menu-button.user.arrow")
    public WebElement accountMenu;

    @FindBy(css = "[placeholder='Search by zip code, city or artisan']")
    public WebElement searchBoxInput;
}
