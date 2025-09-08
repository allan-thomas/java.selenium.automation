import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v139.network.Network;
import org.openqa.selenium.devtools.v139.network.model.ConnectionType;

public class NetworkSpeedWithCDP {

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
		
		devTools.send(Network.emulateNetworkConditions(false, 3000, 20000, 50000, Optional.of(ConnectionType.ETHERNET), Optional.empty(), Optional.empty(), Optional.empty()));
		
		long startTime = System.currentTimeMillis();
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");

		driver.findElement(By.cssSelector(".btn.btn-primary")).click();
		
		long endTime = System.currentTimeMillis();
		
		System.out.println(endTime -  startTime);
		
		driver.quit();
	}

}
