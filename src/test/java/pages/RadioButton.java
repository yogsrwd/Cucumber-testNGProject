package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RadioButton {

	WebDriver driver;

	public RadioButton(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	
	@FindBy (xpath  = "//span[@class='text' and text()='Radio Button']")
	
	WebElement radioButtonBar;
	
	public WebElement getRadioButtonBar() {
		
		return radioButtonBar;
	}
	
	
@FindBy (xpath  = "//label[@class='custom-control-label' and @for='yesRadio']")
	
	WebElement yesRadio;
	
	public WebElement getYesRadio() {
		
		return yesRadio;
	}


}
