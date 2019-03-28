package com.org.amazon.Amazon_Cucu_Pom;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="C:/Users/ArunPrasath/workspace/Amazon_Cucu_Pom/src/main/java/com/org/amazon/features",glue="com.org.amazon.StepDefClasses",
		plugin={"pretty","html:C:/Users/ArunPrasath/Desktop/Cucumber Reports/amazonvalidation"},
		monochrome=true,
		strict=true,
		dryRun=false
		)
public class RunnerClass {

}
