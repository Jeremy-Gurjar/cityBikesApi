package org.example;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import static org.assertj.core.api.BDDAssertions.and;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/features", tags= "@frankfurt or @londonbikes", plugin = { "pretty", "html:target/cucumber-reports/report.html"}, publish = true)

public class RunCuke {

}