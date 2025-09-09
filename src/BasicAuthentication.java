import java.net.URI;
import java.util.function.Predicate;

import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

public class BasicAuthentication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		System.setProperty("webdriver.chrome.driver", "C:/Users/167557/Documents/chromedriver-win64/chromedriver.exe");

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\allan\\OneDrive\\Documents\\chromedriver-win64\\chromedriver.exe");

		ChromeDriver driver = new ChromeDriver();
		

		Predicate<URI> uriPredicate =uri -> uri.getHost().contains("netflix.com");
		
		((HasAuthentication)driver).register(uriPredicate,UsernameAndPassword.of("username", "password"));
	
		driver.get("www.netflix.com");
		
		//the pgm wont work as i dont have any credential popup website
		
	}

}
