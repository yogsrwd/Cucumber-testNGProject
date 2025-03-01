package pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckBoxBar {

	public WebDriver driver;

	public CheckBoxBar(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[normalize-space()='Check Box']")
	WebElement checkBoxBar;

	public WebElement getCheckBoxBar() {
		return checkBoxBar;
	}

	public void expandAllClosedArrows() throws InterruptedException {
		WebElement closedArrow;

		// Loop to click arrows one by one as they become visible
		while (true) {
			try {
				// Find the first visible closed arrow
				closedArrow = driver.findElement(By.xpath("//*[@class='rct-icon rct-icon-expand-close']"));

				// If an arrow is found and displayed, click it
				if (closedArrow.isDisplayed()) {
					closedArrow.click(); // Click to expand the arrow
					Thread.sleep(500); // Optional wait for the UI to load more arrows
				}
			} catch (Exception e) {
				// Break the loop if no more closed arrows are found (no element found
				// exception)
				System.out.println("All arrows have been expanded.");
				break;
			}
		}
	}

	public void checkAllCheckBoxes() {
		WebElement uncheckedBox;
		while (true) {
			try {
				uncheckedBox = driver.findElement(By.xpath("//*[@class='rct-icon rct-icon-uncheck']"));
				if (uncheckedBox.isDisplayed()) {
					uncheckedBox.click();
					Thread.sleep(500);
				}
			} catch (Exception e) {
				System.out.println(" all boxes have been checked");
				break;
			}

		}

	}

}
