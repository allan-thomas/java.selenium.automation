

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Assignment7 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:/Users/167557/Documents/chromedriver-win64/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(5000);
		int count = 0;
		List<WebElement> rowValues = driver.findElements(By.xpath("//table[@class='table-display']/tbody/tr"));
		System.out.println(rowValues.size());
		List<WebElement> coloumnValues = driver.findElements(By.xpath("//table[@class='table-display']/tbody/tr/th"));
		System.out.println(coloumnValues.size());
		System.out.println(rowValues.get(2).getText());
	}

}
