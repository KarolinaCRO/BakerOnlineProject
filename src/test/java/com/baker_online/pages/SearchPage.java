package com.baker_online.pages;

import com.baker_online.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchPage {

    public SearchPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@class='search-bar-container']//*[@name='query']")
    public WebElement searchBoxInput;

    @FindBy(xpath = "//*[@class='products block']//h1")
    public List<WebElement> productHeaders;

    @FindBy(xpath = "(//footer[@class='product']//div[@class='price'])[2]")
    public WebElement productPrice;

    @FindBy(css = "#productssection p")
    public WebElement searchNoResultsMessage;

    @FindBy(css = ".plus")
    public WebElement addQuantityButton;
}
