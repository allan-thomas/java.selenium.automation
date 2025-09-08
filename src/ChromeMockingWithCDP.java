import java.util.Optional;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v139.fetch.Fetch;

import com.aventstack.extentreports.model.Device;

public class ChromeMockingWithCDP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		System.setProperty("webdriver.chrome.driver", "C:/Users/167557/Documents/chromedriver-win64/chromedriver.exe");
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\allan\\OneDrive\\Documents\\chromedriver-win64\\chromedriver.exe");

		ChromeDriver driver = new ChromeDriver();
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		
		devTools.send(Fetch.enable(Optional.empty(), Optional.empty()));
		
		devTools.addListener(Fetch.requestPaused(), request ->{
			if (request.getRequest().getUrl().contains("shetty"))
			{
				String mockedURL = request.getRequest().getUrl().replace("=shetty", "=BadGuy");
				System.out.println(mockedURL);
				devTools.send(Fetch.continueRequest(Fetch.continueRequest(
						request.getRequestId(),
					    Optional.ofNullable(mockedURL),             
					    Optional.ofNullable(request.getRequest().getMethod()), 
					    Optional.empty(),          
					    request.getResponseHeaders(),                  
					    Optional.of(true))));
			}
			else // for api which does not have shetty
				{
				devTools.send(Fetch.continueRequest(Fetch.continueRequest(
						request.getRequestId(),
					    Optional.empty(),             
					    Optional.ofNullable(request.getRequest().getMethod()), 
					    Optional.empty(),          
					    request.getResponseHeaders(),                  
					    Optional.of(true))));
			}
		});
	}

}
