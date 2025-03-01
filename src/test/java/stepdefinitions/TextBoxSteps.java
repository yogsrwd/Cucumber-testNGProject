package stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import base.Base;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.TextBox;

public class TextBoxSteps extends Base {

	
	TextBox textBox;

	String name = "rana daggupati";
	String email = "rana@bana.com";
	String currentAddress = "chowpatty";
	String permanentAddress = "browpatty";
	
	

	public TextBoxSteps() {
		driver = getDriver();

	}
	
	@After
	public void tearDown(Scenario scenario) {
		
		if(scenario.isFailed()) {
			
			Base.test.fail("test failed" + scenario.getName());
			
		}else{
			Base.test.pass("test passed:" + scenario.getName());
			
			
		}
		
	}

	@Given("user is already on the website")
	public void userIsAlreadyOnWebsite() {

		createTest("TextBox test");
		textBox = new TextBox(driver);
	}

	@When("he clicks on TextBox button on the sidebar")
	public void clickOnTextBoxButton() {
		textBox.getTextBoxField().click();

		test.pass("User successfully navigated to the TextBox page.");

	}

	@When("he enters all required details in the form")
	public void enterAllDetailsInForm() {

		try {
			textBox.getFullName().sendKeys(name, Keys.ENTER);
			textBox.getEmail().sendKeys(email);
			textBox.getAddress().sendKeys(currentAddress);
			textBox.getPermAddress().sendKeys(permanentAddress);

			test.pass("user succesfully entered the name, email,current Address and permanent Address");

		} catch (Exception e) {

			test.fail("failed to enter the name, email, address, permanent address" + e.getMessage());
		}

	}

	@When("user clicks on the submit button")
	public void clickOnSubmitButton() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", textBox.getSubmit());
	}

	@Then("he should be able to see the entered details below the form")
	public void verifyEnteredDetails() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement nameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));
		String actualName = nameElement.getText();
		Assert.assertTrue(actualName.contains(name), "Name did not match!");

		// For Email
		WebElement emailElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
		String actualEmail = emailElement.getText();
		Assert.assertTrue(actualEmail.contains(email), "Email did not match!");

	}
}
