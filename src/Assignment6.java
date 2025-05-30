import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment6 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/allan/OneDrive/Documents/chromedriver-win64/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		WebElement checkboxEx = driver.findElement(By.xpath("//div[@id='checkbox-example']/fieldset"));
		List<WebElement> checkboxOptions =checkboxEx.findElements(By.tagName("label"));
		checkboxEx.findElements(By.tagName("input")).get(2).click();
		String selectedOption = checkboxEx.findElements(By.tagName("label")).get(2).getText();
		System.out.println(selectedOption);
		Select sc = new Select(driver.findElement(By.cssSelector("#dropdown-class-example")));
		sc.selectByContainsVisibleText(selectedOption);
		driver.findElement(By.cssSelector("#name")).sendKeys(selectedOption);
		driver.findElement(By.id("alertbtn")).click();
		String alertMsg = driver.switchTo().alert().getText();
		if (alertMsg.contains(selectedOption)) {
			System.out.println("yes");
		}
	}

}
