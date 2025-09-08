import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v139.network.Network;
import org.openqa.selenium.devtools.v139.network.model.Request;
import org.openqa.selenium.devtools.v139.network.model.Response;

public class CDPNetworkLogActivity {

	public static void main(String[] args) {
		
//		System.setProperty("webdriver.chrome.driver", "C:/Users/167557/Documents/chromedriver-win64/chromedriver.exe");
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\allan\\OneDrive\\Documents\\chromedriver-win64\\chromedriver.exe");

		ChromeDriver driver = new ChromeDriver();
		
		//log file >>
		DevTools devTools=  driver.getDevTools();
		
		devTools.createSession();
		
		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty()));
		
		devTools.addListener(Network.requestWillBeSent(), request ->
		{
			Request req = request.getRequest();
			System.out.println(req.getUrl());
		});
		
		//event will be triggered
		devTools.addListener(Network.responseReceived(), response -> {
			Response resp = response.getResponse();
			//System.out.println(resp.getUrl());
//			System.out.println(resp.getStatus());
			if(resp.getStatus().toString().startsWith("4"))
				System.out.println(resp.getUrl() + ">> is failing with status code :" + resp.getStatus());
		});
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		
		driver.findElement(By.cssSelector(".btn.btn-primary")).click();
		

	}

}
