package stepdefinitions;

import org.openqa.selenium.WebDriver;

import base.Base;

public class GetLinksTitile  extends Base{
	
	WebDriver driver;
	
	
 public GetLinksTitile() {
	 
	 this.driver  = getDriver();
	 
 }
 
 
 public void getAllLinksTitle() {
	 
	 
	 driver.get("");
 }
	

}
