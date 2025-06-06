import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Assignment_fromLap {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/allan/OneDrive/Documents/chromedriver-win64/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(2));
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		loginPage(w,driver,"rahulshettyacademy","learning");
		afterlogin( w, driver);
		

	}
	
	public static void loginPage (WebDriverWait w,WebDriver driver, String userName, String password) {
		driver.findElement(By.cssSelector("input#username")).sendKeys(userName);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.xpath("(//span[@class='checkmark'])[2]")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/button[2]")));
		driver.findElement(By.xpath("//div/button[2]")).click();
		Select dropDown = new Select(driver.findElement(By.cssSelector("select.form-control")));
		dropDown.selectByIndex(2);
		driver.findElement(By.id("terms")).click();
		driver.findElement(By.id("signInBtn")).click();
		
	}
	
	public static void afterlogin(WebDriverWait w, WebDriver driver) {
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-info']")));
		List<WebElement> elementList = driver.findElements(By.xpath("//button[@class='btn btn-info']"));
		for (int i=0; i<elementList.size();i++) {
			driver.findElements(By.xpath("//button[@class='btn btn-info']")).get(i).click();
		}
		driver.findElement(By.className("nav-link")).click();
		driver.quit();
	}

}
