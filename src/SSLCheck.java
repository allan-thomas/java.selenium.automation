import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SSLCheck {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/allan/OneDrive/Documents/chromedriver-win64/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String Pid = it.next();

	}

}
