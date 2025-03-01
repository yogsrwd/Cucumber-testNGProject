package stepdefinitions;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import base.Base;

public class AlertFrameWindowws extends Base {

	WebDriver driver;

	public AlertFrameWindowws() {

		driver = getDriver();

	}

	
	
	@AfterMethod
	public void tearDown1(ITestResult result) {
		
		
		Base base = new Base();

		base.tearDown(result);
		
	}

	@Test(priority = 9)

	public void browserWindow() throws InterruptedException {

		Base.createTest("browser new tab test");

		System.out.println("first we will close the element giant bar");

		// driver.findElement(By.xpath("(//div[@class='header-wrapper'])[1]")).click();

		Thread.sleep(2000);

		System.out.println("we are about to click on alert window frame giant bar");

		WebElement AlertGiantBar = driver.findElement(By.xpath("(//div[@class='header-text'])[3]"));

		AlertGiantBar.click();

		System.out.println("we are about to click on the window bar");

		WebElement browserWindow = driver.findElement(By.xpath("//span[@class='text' and text()='Browser Windows']"));

		browserWindow.click();

		String parentWindow = driver.getWindowHandle();

		/*
		 * WebElement newTabButton =
		 * driver.findElement(By.xpath("//button[@id='tabButton']"));
		 * 
		 * newTabButton.click();
		 * 
		 * Thread.sleep(2000);
		 * 
		 * driver.switchTo().window(parentWidow);
		 */

		System.out.println("clicking on new window");

		Thread.sleep(2000);

		WebElement newWindow = driver.findElement(By.xpath("//button[@id='windowButton']"));

		newWindow.click();

		Thread.sleep(2000);

		Set<String> allWindowHandles = driver.getWindowHandles();
		// Check if the window handle count has increased
		if (allWindowHandles.size() > 1) {
			for (String windowHandle1 : allWindowHandles) {
				if (!windowHandle1.equals(parentWindow)) {
					driver.switchTo().window(windowHandle1);
					break;
				}
			}
		} else {
			System.out.println("New window did not open!");
		}

		WebElement bodyElement = driver.findElement(By.tagName("body"));
		String popupText = bodyElement.getText(); // This will get the full visible text from the popup

		System.out.println("Popup Text: " + popupText);

		Thread.sleep(2000);

		driver.close();

		driver.switchTo().window(parentWindow);

		Thread.sleep(2000);

	}

	@Test(priority = 10)
	public void alertBar() throws InterruptedException {

		Base.createTest("alerts  test");

		Thread.sleep(2000);

		WebElement AlertGiantBar = driver.findElement(By.xpath("(//div[@class='header-text'])[3]"));
		AlertGiantBar.click();

		driver.findElement(By.xpath("(//div[@class='header-text'])[3]")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//span[@class='text' and text()='Alerts']")).click();

		WebElement firstAlert = driver.findElement(By.xpath("//button[@id='alertButton']"));
		firstAlert.click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		WebElement fiveSecondsAlert = driver.findElement(By.xpath("//button[@id='timerAlertButton']"));
		fiveSecondsAlert.click();
		Thread.sleep(6000);
		driver.switchTo().alert().accept();

		Thread.sleep(500);
		driver.findElement(By.xpath("//button[@id='confirmButton']")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().dismiss();
	}

	@Test(priority = 11)

	public void frames() throws InterruptedException {

		Base.createTest("iframes test");

		driver.findElement(By.xpath("//span[@class='text' and text()='Frames']")).click();

		Thread.sleep(2000);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(0, 300);");

		WebElement firstFrame = driver.findElement(By.xpath("//iframe[@id='frame2']"));

		driver.switchTo().frame(firstFrame);

		long duration = 5000;
		long endTime = System.currentTimeMillis() + duration;

		while (System.currentTimeMillis() < endTime) {
			js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
			Thread.sleep(500);

			js.executeScript("window.scrollTo(-document.body.scrollWidth, 0);");
			Thread.sleep(500);

			js.executeScript("window.scrollTo(0, 0);");
			Thread.sleep(500);

			js.executeScript("window.scrollTo(document.body.scrollWidth, 0);");
			Thread.sleep(500);
		}

		driver.switchTo().defaultContent();
	}

	@Test(priority = 12)
	public void nestedFrame() {

		Base.createTest("nested iframes test");

		driver.findElement(By.xpath("//span[@class='text' and text()='Nested Frames']")).click();

		try {

			WebElement iframe1 = driver.findElement(By.id("frame1"));

			driver.switchTo().frame(iframe1);

			WebElement iframe2 = driver.findElement(By.xpath("//p[text()='Child Iframe']"));

			driver.switchTo().frame(iframe2);

			WebElement frame2Text = driver.findElement(By.id("//p[text()='Child Iframe']"));

			System.out.println(frame2Text.getText());
		} catch (Exception e) {

			System.out.println(" frame test failed  ");

			driver.switchTo().defaultContent();

			WebElement AlertGiantBar = driver.findElement(By.xpath("(//div[@class='header-text'])[3]"));

			AlertGiantBar.click();

		}

	}

}
