package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TextBox {
	WebDriver driver;

	public TextBox(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(className = "text")

	WebElement textBoxField;

	public WebElement getTextBoxField() {

		return textBoxField;
		
	}

	@FindBy(id = "userName")

	WebElement fullName;

	public WebElement getFullName() {

		return fullName;
	}

	@FindBy(id = "userEmail")

	WebElement email;;

	public WebElement getEmail() {

		return email;
	}

	@FindBy(id = "currentAddress")

	WebElement currentAddress;

	public WebElement getAddress() {

		return currentAddress;
	}

	@FindBy(id = "permanentAddress")

	WebElement permanentAddress;

	public WebElement getPermAddress() {

		return permanentAddress;
	}

	@FindBy( xpath = "//button[text()='Submit']")

	WebElement submit;

	public WebElement getSubmit() {

		return submit;
	}

}
