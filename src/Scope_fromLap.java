

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scope_fromLap {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:/Users/167557/Documents/chromedriver-win64/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println( driver.findElements(By.tagName("a")).size());
		WebElement footerdriver = driver.findElement(By.id("gf-BIG"));
		System.out.println(footerdriver.findElements(By.tagName("a")).size());
		WebElement footerdriver1 = footerdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println(footerdriver1.findElements(By.tagName("a")).size());
		for (int i=1; i<=footerdriver1.findElements(By.tagName("a")).size();i++) {
			footerdriver1.findElements(By.tagName("a")).get(i).click();
			
		}
	}

}
