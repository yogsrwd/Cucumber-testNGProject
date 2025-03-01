package stepdefinitions;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import base.Base;
import pages.RadioButton;
import pages.WebTable;

public class ElementBar {

	private WebTable webTable;
	private RadioButton radioButton;

	private WebDriver driver;

	public ElementBar() {

		this.driver = Base.getDriver();
		this.radioButton = new RadioButton(driver);

		this.webTable = new WebTable(driver);
	}

	@AfterMethod
	public void tearDown1(ITestResult result) {

		Base base = new Base();

		base.tearDown(result);

	}

	@Test(priority = 1)
	public void RadioButton() throws InterruptedException {

		Base.createTest("RadioButton Test");

		radioButton.getRadioButtonBar().click();

		Thread.sleep(500);

		radioButton.getYesRadio().click();

	}

	@Test(priority = 2)
	public void WebTables() throws InterruptedException {

		Base.createTest("WebTable Test");

		System.out.println("starting to add elemetns into the webtable");

		webTable.getWebTableBar().click();

		webTable.getAddRowButton().click();

		webTable.getfirstNameField().sendKeys("rana");
		Thread.sleep(500);

		webTable.getlastNameField().sendKeys("dagupatty");
		Thread.sleep(500);

		webTable.getAgefield().sendKeys("222");
		Thread.sleep(500);

		webTable.getEmailField().sendKeys("ranaDaggu@gmail.com");
		Thread.sleep(500);

		webTable.getSalaryField().sendKeys("3333333");
		Thread.sleep(500);

		webTable.getDepartmentField().sendKeys("IT");
		Thread.sleep(500);

		webTable.getSubmitButton().click();
		Thread.sleep(3000);

	}

	@Test(priority = 3)
	public void ButtonsBar() throws InterruptedException {

		Base.createTest("ButtonBar test");

		System.out.println("About to click on the Buttons Bar");
		driver.findElement(By.xpath("//span[@class='text' and text()='Buttons']")).click();

		WebElement doubleClickElement = driver.findElement(By.xpath("//button[@id='doubleClickBtn']"));

		Actions a = new Actions(driver);

		a.doubleClick(doubleClickElement).perform();

	}

	@Test(priority = 4)
	public void linksBar() throws InterruptedException {

		Base.createTest("linkBar test");

		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='text' and text()='Links']")).click();

		driver.findElement(By.xpath("//a[@id='simpleLink']")).click();

		Thread.sleep(2000);

		String originalWindow = driver.getWindowHandle();

		// Get all window handles
		Set<String> allWindows = driver.getWindowHandles();

		for (String windowHandle : allWindows) {
			if (!windowHandle.equals(originalWindow)) {
				// Switch to the new tab
				driver.switchTo().window(windowHandle);

				// Perform any actions in the new tab...

				// Close the new tab
				driver.close();

				// Break out of the loop after closing the new tab
				break;
			}
		}

		// Switch back to the original window if needed
		driver.switchTo().window(originalWindow);
	}

	@Test(priority = 5)
	public void brokenImage() throws InterruptedException {

		Base.createTest("broken Images test");

		driver.findElement(By.xpath("//span[@class='text' and text()='Broken Links - Images']")).click();

		Thread.sleep(2000);

		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		WebElement brokenImage = driver.findElement(By.xpath("//img[@src='/images/Toolsqa_1.jpg']"));

		Boolean imageLoaded = (Boolean) jsExecutor.executeScript("return arguments[0].naturalWidth>0;", brokenImage);

		System.out.println("image is not loaded" + imageLoaded);

	}

	@Test(priority = 6)
	public void UploadDownload() {

		Base.createTest("uploading file test");

		driver.findElement(By.xpath("//span[@class='text' and text()='Upload and Download']")).click();

		WebElement uploadButton = driver.findElement(By.xpath("//input[@id='uploadFile']"));

		uploadButton.sendKeys("C:\\Users\\yoges\\remote_workspace2\\ToolsQA\\test-output\\bullet_point.png");

	}

	@Test(priority = 7)
	public void dynamicProperty() throws InterruptedException {

		Base.createTest("dyanic Button appear  test");

		Thread.sleep(2000);

		System.out.println("we are about to click on the button which will appear in 5 seconds ");

		driver.findElement(By.xpath("//span[@class='text' and text()='Dynamic Properties']")).click();

		Thread.sleep(6000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement button = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='enableAfter']")));

		button.click();

	}

}
