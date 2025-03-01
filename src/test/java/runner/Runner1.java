package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/features/CheckBox.feature",

		glue  = "stepdefinitions"
		 )


public class Runner1  extends AbstractTestNGCucumberTests{
	
	
	
	

}