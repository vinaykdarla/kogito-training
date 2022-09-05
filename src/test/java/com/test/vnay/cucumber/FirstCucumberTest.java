package com.test.vnay.cucumber;


import io.cucumber.junit.CucumberOptions;
import io.quarkiverse.cucumber.CucumberQuarkusTest;

@CucumberOptions(features = "classpath:features",glue="com.test.vnay.cucumber",monochrome = true, dryRun=true, plugin = {"pretty","html:target/report/Report.html"})
public class FirstCucumberTest extends CucumberQuarkusTest{

}
