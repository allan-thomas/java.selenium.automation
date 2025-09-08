import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v139.network.Network;
import org.testng.Assert;

import com.google.common.collect.ImmutableList;

public class BlockNetworkRequestsWithCDP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		System.setProperty("webdriver.chrome.driver", "C:/Users/167557/Documents/chromedriver-win64/chromedriver.exe");

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\allan\\OneDrive\\Documents\\chromedriver-win64\\chromedriver.exe");

		ChromeDriver driver = new ChromeDriver();

		// log file >>
		DevTools devTools = driver.getDevTools();

		devTools.createSession();

		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty()));

		//devTools.send(Network.setBlockedURLs(ImmutableList.of("*.jpg", "*.css")));
		
		long startTime = System.currentTimeMillis();

		driver.get("https://rahulshettyacademy.com/angularAppdemo/");

		driver.findElement(By.linkText("Browse Products")).click();
		
		driver.findElement(By.linkText("Selenium")).click();
		
		driver.findElement(By.cssSelector(".add-to-cart")).click();
		
		System.out.println(driver.findElement(By.cssSelector(".sp")).getText());
		
		Assert.assertTrue(driver.findElement(By.cssSelector(".sp")).getText().equalsIgnoreCase("THIS PRODUCT IS ALREADY ADDED TO CART"));
		
		driver.quit();
		
		long endTime = System.currentTimeMillis();
		
		System.out.println(endTime -  startTime);
		
		//822
		
		

	}

}
