package com.baker_online.step_definitions;

import com.baker_online.utilities.Driver;
import com.baker_online.utilities.MailSlurpUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before("@mailslurp")
    public void setupMailSlurp() {
        System.out.println("Setting up MailSlurp for email testing");
        MailSlurpUtils.setup();
        MailSlurpUtils.cleanupInbox(); // Clean up any existing emails
    }

    @After("@mailslurp")
    public void cleanupMailSlurp() {
        System.out.println("Cleaning up MailSlurp inbox");
        MailSlurpUtils.cleanupInbox();
    }

    @After
    public void teardownScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        Driver.closeDriver();
    }
}
