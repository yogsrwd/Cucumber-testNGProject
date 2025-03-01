package stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import base.Base;

public class Widgets extends Base {

	WebDriver driver;

	Widgets() {

		this.driver = getDriver();
	}

	@AfterMethod
	public void tearDown1(ITestResult result) {

		Base base = new Base();

		base.tearDown(result);

	}

	@Test(priority = 13)
	public void slider() throws InterruptedException {

		Base.createTest("slider test");

		Thread.sleep(500);

		WebElement GiantWdgetBar = driver.findElement(By.xpath("(//div[@class='header-wrapper'])[4]"));

		Thread.sleep(500);

		GiantWdgetBar.click();

		Thread.sleep(500);

		WebElement sliderBar = driver.findElement(By.xpath("//span[@class='text' and text()='Slider']"));
		sliderBar.click();

		WebElement slider = driver.findElement(By.xpath("//input[@class='range-slider range-slider--primary']"));

		Thread.sleep(2000);

		Actions action = new Actions(driver);

		action.clickAndHold(slider).moveByOffset(50, 0).release().perform();

		Thread.sleep(2000);

	}

	@Test(priority = 14)
	public void progressBar() throws InterruptedException {Base.createTest("progress bar Start stop test");

Thread.sleep(300);

// Move to Progress Bar menu and click
Actions actions = new Actions(driver);
actions.moveToElement(driver.findElement(By.xpath("//span[@class='text' and text()='Progress Bar']"))).perform();
driver.findElement(By.xpath("//span[@class='text' and text()='Progress Bar']")).click();
Thread.sleep(599);

// Wait for the start button to be visible and clickable
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
WebElement startButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='startStopButton']")));

// Click the start button
startButton.click();

while (true) {
    WebElement progressBar = driver.findElement(By.xpath("//div[@class='progress-bar bg-info']"));
    String progressValue = progressBar.getDomAttribute("aria-valuenow");
    int progress = Integer.parseInt(progressValue);

    System.out.println("current Progress : " + progress + "%");

    if (progress >= 60) {
        ((JavascriptExecutor) driver).executeScript("alert('Progress Bar reached 60%!');");
        Thread.sleep(3000);

        Alert alert = driver.switchTo().alert();
        Thread.sleep(400);
        alert.accept();

        startButton.click();
        Thread.sleep(400);
        break;
    }
}
}

	@Test(priority = 15)
	public void hoverMenu() throws InterruptedException {

		Base.createTest("hover on the menu options");

		/*
		 * driver.findElement(By.xpath("(//div[@class='header-wrapper'])[1]")).click();
		 * 
		 * Thread.sleep(500);
		 * 
		 * WebElement GiantWdgetBar =
		 * driver.findElement(By.xpath("(//div[@class='header-wrapper'])[4]"));
		 * 
		 * GiantWdgetBar.click();
		 */

		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 200);");

		Thread.sleep(200);
		driver.findElement(By.xpath("//span[@class='text' and text()='Menu']")).click();

		WebElement mainMenu2 = driver.findElement(By.xpath("//a[@href='#' and text()='Main Item 2']"));

		WebElement subSubList = driver.findElement(By.xpath("//a[@href='#' and text()='SUB SUB LIST »']"));

		WebElement subSubItem2 = driver.findElement(By.xpath("//a[@href='#' and text()='Sub Sub Item 2']"));

		Actions action = new Actions(driver);

		Thread.sleep(500);

		action.moveToElement(mainMenu2).perform();

		Thread.sleep(500);

		action.moveToElement(subSubList).perform();

		Thread.sleep(500);

		action.moveToElement(subSubItem2);

		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 399);");

	}

	@Test(priority = 16)
	public void selectMenu() throws InterruptedException {

		Base.createTest("select dropdown test");

		Thread.sleep(200);

		WebElement progressBarSidebar = driver.findElement(By.xpath("//span[@class='text' and text()='Progress Bar']"));

		Actions actions = new Actions(driver);
		actions.moveToElement(progressBarSidebar).perform();
		progressBarSidebar.click();
		Thread.sleep(200);
		WebElement dropDown1 = driver.findElement(By.xpath("(//div[@class=' css-yk16xz-control'])[1]"));
		dropDown1.click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement group2Option1 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Group 2, option 1']")));
		group2Option1.click();

		WebElement dropDown2 = driver.findElement(By.xpath("(//div[@class=' css-2b097c-container'])[2]"));
		dropDown2.click();

		WebElement dropDownMsOption = driver.findElement(By.xpath("//div[text()='Ms.']"));
		dropDownMsOption.click();

		WebElement dropDown3 = driver.findElement(By.xpath("//select[@id='oldSelectMenu']"));
		Select select = new Select(dropDown3);
		select.selectByIndex(2);

		WebElement dropDown4 = driver.findElement(By.xpath("(//div[@class=' css-2b097c-container'])[3]"));
		dropDown4.click();

		WebElement greenOption = driver.findElement(By.xpath("//div[text()='Green']"));

		System.out.println(greenOption.getText());
	}

}
