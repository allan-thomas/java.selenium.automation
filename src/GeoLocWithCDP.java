import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v139.emulation.Emulation;

public class GeoLocWithCDP {

	public static void main(String[] args) throws InterruptedException {

//		System.setProperty("webdriver.chrome.driver", "C:/Users/167557/Documents/chromedriver-win64/chromedriver.exe");
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\allan\\OneDrive\\Documents\\chromedriver-win64\\chromedriver.exe");

		ChromeDriver driver = new ChromeDriver();

		DevTools devTools = driver.getDevTools();

		devTools.createSession();

//		Map<String, Object> geoLoc = new HashMap<String, Object>();
//
//		geoLoc.put("latitude", 40.2616);
//		geoLoc.put("longitude", 3.4046);
//		geoLoc.put("accuracy", 90);

		devTools.send(Emulation.setGeolocationOverride(Optional.of(40.2616), Optional.of(3.4046), Optional.of(90),
				Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty()));

//		driver.executeCdpCommand("Emulation.setGeolocationOverride", geoLoc);

		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("Netflix", Keys.ENTER);
	}

}
