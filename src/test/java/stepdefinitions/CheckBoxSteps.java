package stepdefinitions;

import base.Base;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.CheckBoxBar;

public class CheckBoxSteps extends Base {

    CheckBoxBar checkBoxBarPage;

    public CheckBoxSteps() {
        driver = getDriver();  // Reuse the shared driver from Base
    }
    
    
	@After
	public void tearDown(Scenario scenario) {
		
		if(scenario.isFailed()) {
			
			Base.test.fail("test failed" + scenario.getName());
			
		}else{
			Base.test.pass("test passed:" + scenario.getName());
			
			
		}
		
	}


    @Given("the user is on the sidebar and clicks on the \"Check Box\" menu option")
    public void userClicksOnCheckboxMenu() throws InterruptedException {
    	
    	
    	
		createTest("CheckBox");

        System.out.println("here we are going to click on the checkBox Bar");
        checkBoxBarPage = new CheckBoxBar(driver);
        checkBoxBarPage.getCheckBoxBar().click();
    }

    @Then("the user clicks on all the expansion arrows present in every folder")
    public void userClicksOnExpandCaret() throws InterruptedException {
    	
    	
    	checkBoxBarPage.expandAllClosedArrows();
    }

    @Then("the user clicks on all the checkboxes present in every nested folder")
    public void userSeesAllNestedCheckboxes() throws InterruptedException {
       
    	checkBoxBarPage.checkAllCheckBoxes();
    	
    	
    }
}
