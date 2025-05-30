import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class BrokenLinks {

	public static void main(String[] args) throws IOException  {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/allan/OneDrive/Documents/chromedriver-win64/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://rahulshettyacademy.com/AutomationPractice/");
		List<WebElement> footerurls = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		int count = 0;
		for (int i = 1; i < footerurls.size(); i++) {
			String urls = footerurls.get(i).getDomAttribute("href");
			 URL url = URI.create(urls).toURL();
			 HttpURLConnection conn = (HttpURLConnection) url.openConnection();
             conn.setRequestMethod("HEAD");
             conn.connect();
             count++;
			if (conn.getResponseCode() > 400) {
				System.out.println(footerurls.get(i).getText() + " is broken with code " + conn.getResponseCode());
				/* Assert.fail(); */
			}
		}
		System.out.println(count);  
	}

}
