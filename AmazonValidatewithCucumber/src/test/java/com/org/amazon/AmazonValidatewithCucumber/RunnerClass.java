package com.org.amazon.AmazonValidatewithCucumber;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="Features",glue="com.org.amazon.AmazonValidatewithCucumber",
		plugin={"pretty","html:C:/Users/ArunPrasath/Desktop/Cucumber Reports/amazonvalidation"},
		monochrome=true
		)
public class RunnerClass {

}
