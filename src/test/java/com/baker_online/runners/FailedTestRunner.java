package com.baker_online.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "com/baker_online/step_definitions",
        features = "@target/rerun.txt"
)
public class FailedTestRunner {
}
