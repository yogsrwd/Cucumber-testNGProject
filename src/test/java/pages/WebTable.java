package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebTable {
	
	
	WebDriver driver;

	public WebTable(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	
	@FindBy (xpath  = "//span[@class='text' and text()='Web Tables']")
	
	WebElement webTableBar;
	
	public WebElement getWebTableBar() {
		
		return webTableBar;
	}
	
@FindBy (xpath  = "//button[@id='addNewRecordButton']")
	
	WebElement addRowButton;
	
	public WebElement getAddRowButton() {
		
		return addRowButton;
	}
	
@FindBy (xpath  = "//input[@id='firstName' and @type='text']")
	
	WebElement firstNameField;
	
	public WebElement getfirstNameField() {
		
		return firstNameField;
	}
	
@FindBy (xpath  = "//input[@id='lastName' and @type='text']")
	
	WebElement lastNameField;
	
	public WebElement getlastNameField() {
		
		return lastNameField;
	}
	
@FindBy (xpath  = "//input[@id='userEmail' and @type='text']")
	
	WebElement emailField;
	
	public WebElement getEmailField() {
		
		return emailField;
	}
	
	
	
@FindBy (xpath  = "//input[@id='age' and @type='text']")
	
	WebElement ageField;
	
	public WebElement getAgefield() {
		
		return ageField;
	}
	
@FindBy (xpath  = "//input[@id='salary' and @type='text']")
	
	WebElement salaryField;
	
	public WebElement getSalaryField() {
		
		return salaryField;
	}
	
	
@FindBy (xpath  = "//input[@id='department' and @type='text']")
	
	WebElement departmentField;
	
	public WebElement getDepartmentField() {
		
		return departmentField;
	}
	
@FindBy (xpath  = "//button[@id='submit']")
	
	WebElement submitButton;
	
	public WebElement getSubmitButton() {
		
		return submitButton;
	}
	
	
	
}
