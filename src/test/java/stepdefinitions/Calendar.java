package stepdefinitions;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import base.Base;

public class Calendar extends Base {

	WebDriver driver;

	public Calendar() {
		this.driver = getDriver();
	}

	@AfterMethod
	public void tearDown1(ITestResult result) {
		Base base = new Base();
		base.tearDown(result);
	}

	@Test(priority = 8)
	public void getFormsGiantBar() throws InterruptedException, Exception {

		Base.createTest("Forms calendar test");

		driver.findElement(By.xpath("(//div[@class='header-wrapper'])[1]")).click();
		Thread.sleep(2000);
		System.out.println("We are about to click on the giant bar which is Forms");

		WebElement formsbar = driver.findElement(By.xpath("(//div[@class='header-right'])[2]"));
		formsbar.click();

		driver.findElement(By.xpath("//span[@class='text' and text()='Practice Form']")).click();

		WebElement calendar = driver.findElement(By.xpath("//input[@id='dateOfBirthInput']"));
		calendar.click();

		WebElement monthPicker = driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']"));
		
		// monthPicker.click();

		// select month
		Select select = new Select(monthPicker);
		Thread.sleep(2000);
		select.selectByVisibleText("August");

		WebElement yearPick = driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']"));

		// yearPick.click(); 
		// select year
		Select select2 = new Select(yearPick);
		select2.selectByVisibleText("1997");

		//looping for 17 times 
		for (int i = 1; i <= 17; i++) {
			// Find the date element using the day number in the XPath
			WebElement dateElement = driver.findElement(By.xpath("//div[contains(@class, 'react-datepicker__day react-datepicker__day--0" + (i < 10 ? "0" + i : i) + "')]"));
			Actions actions = new Actions(driver);
			actions.moveToElement(dateElement).perform(); // Hover over the date
			System.out.println("Hovered over date: " + i);
			Thread.sleep(100);

			// this will click on the  date if its 17
			if (i == 17) {
				dateElement.click();
				System.out.println("Clicked on date 17.");
			}
		}

		Thread.sleep(2000);

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\yoges\\remote_workspace2\\ToolsQA\\src\\formDetails.properties");
		prop.load(fis);

		String firstName = prop.getProperty("firstName");
		String lastName = prop.getProperty("lastName");
		String email = prop.getProperty("email");
		String gender = prop.getProperty("gender");
		String mobile = prop.getProperty("mobile");
		String subject = prop.getProperty("subject");
		String currentAddress = prop.getProperty("currentAddress");

		driver.findElement(By.id("firstName")).sendKeys(firstName);
		driver.findElement(By.id("lastName")).sendKeys(lastName);
		driver.findElement(By.id("userEmail")).sendKeys(email);

		// select gender
		if ("male".equalsIgnoreCase(gender)) {
			WebElement male = driver.findElement(By.xpath("(//label[@class='custom-control-label'])[1]"));
			male.click();
		} else if ("female".equalsIgnoreCase(gender)) {
			WebElement female = driver.findElement(By.xpath("(//label[@class='custom-control-label'])[2]"));
			female.click();
		} else if ("other".equalsIgnoreCase(gender)) {
			WebElement other = driver.findElement(By.xpath("(//label[@class='custom-control-label'])[3]"));
			other.click();
		}

		/*
		 * WebElement subjectField = driver.findElement(By.
		 * xpath("(//div[@class='subjects-auto-complete__value-container subjects-auto-complete__value-container--is-multi css-1hwfws3'])[1]"
		 * )); subjectField.click(); subjectField.sendKeys(subject);
		 * 
		 * driver.findElement(By.id("userNumber")).sendKeys(mobile);
		 * driver.findElement(By.id("currentAddress")).sendKeys(currentAddress);
		 * 
		 * // select hobbies
		 * driver.findElement(By.xpath("//input[@id='hobbies-checkbox-1']")).click();
		 * Thread.sleep(300);
		 * driver.findElement(By.xpath("//input[@id='hobbies-checkbox-2']")).click();
		 * Thread.sleep(300);
		 * driver.findElement(By.xpath("//input[@id='hobbies-checkbox-3']")).click();
		 * Thread.sleep(300);
		 * 
		 * WebElement state =
		 * driver.findElement(By.xpath("(//div[@class=' css-1hwfws3'])[1]")); WebElement
		 * city = driver.findElement(By.xpath("(//div[@class=' css-1hwfws3'])[2]"));
		 * 
		 * // select state Select selectState = new Select(state);
		 * selectState.selectByVisibleText("Haryana"); Thread.sleep(300);
		 * 
		 * // Select city Select selectCity = new Select(city);
		 * selectCity.selectByVisibleText("Panipat"); Thread.sleep(300);
		 */

		formsbar.click();
	}
}
