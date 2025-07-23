package com.baker_online.pages;

import com.baker_online.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ArtisanResultsPage {

    public ArtisanResultsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = ".button.fill.main")
    public WebElement shopNowButton;
}
