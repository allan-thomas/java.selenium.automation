import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

public class ConsoleLogsCapture {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		System.setProperty("webdriver.chrome.driver", "C:/Users/167557/Documents/chromedriver-win64/chromedriver.exe");

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\allan\\OneDrive\\Documents\\chromedriver-win64\\chromedriver.exe");

		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");

		driver.findElement(By.linkText("Browse Products")).click();
		
		driver.findElement(By.linkText("Selenium")).click();
		
		driver.findElement(By.cssSelector(".add-to-cart")).click();
		
		driver.findElement(By.linkText("Cart")).click();

		driver.findElement(By.cssSelector("#exampleInputEmail1")).clear();
		
		driver.findElement(By.cssSelector("#exampleInputEmail1")).sendKeys("2");
		
		LogEntries entry = driver.manage().logs().get(LogType.BROWSER); //get log entries object
		
		List<LogEntry> logs = entry.getAll(); //getall method returns all logs
		
		for (LogEntry e : logs) { //iterating through all list and printing the logs
			
			System.out.println(e.getMessage());
		}
		
		
	}

}
