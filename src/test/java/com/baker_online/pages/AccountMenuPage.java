package com.baker_online.pages;

import com.baker_online.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountMenuPage {

    public AccountMenuPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@class='menu']//a[text()='Log out']")
    public WebElement logOutLink;
}
