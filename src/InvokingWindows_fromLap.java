import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class InvokingWindows_fromLap {  

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:/Users/167557/Documents/chromedriver-win64/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.navigate().to("https://rahulshettyacademy.com/angularpractice/");
		driver.switchTo().newWindow(WindowType.TAB);
		
		// now we need to give access to the new window using getwindowhandles()
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String initalWin = it.next();
		String finalWin = it.next();
		driver.switchTo().window(finalWin);
		driver.navigate().to("https://rahulshettyacademy.com/");
		String nameValue = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']")).get(1).getText();
		driver.switchTo().window(initalWin);
		driver.findElement(By.cssSelector("form input[name='name']")).sendKeys(nameValue);
		driver.manage().window().maximize();
		
	}

}
