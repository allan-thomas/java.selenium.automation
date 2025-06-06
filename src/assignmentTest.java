

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class assignmentTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:/Users/167557/Documents/chromedriver-win64/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.findElement(By.xpath("(//input[@name='name'])[1]")).sendKeys("Allan Thomas");
		driver.findElement(By.xpath("//div//input[@name='email']")).sendKeys("atk@gmail.com");
		driver.findElement(By.cssSelector("#exampleInputPassword1")).sendKeys("allan123");
		driver.findElement(By.cssSelector("#exampleCheck1")).click();
		driver.findElement(By.xpath("//select[@id='exampleFormControlSelect1']")).click();
		driver.findElement(By.xpath("//select[@id='exampleFormControlSelect1']//option[text()='Female']")).click();
		driver.findElement(By.id("inlineRadio1")).click();
		driver.findElement(By.cssSelector("input[name='bday']")).sendKeys("29-09-1998");
		driver.findElement(By.className("btn")).click();
		System.out.println(driver.findElement(By.cssSelector("div[class*='alert-dismissible']")).getText());

	}

}
