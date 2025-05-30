import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TakingScreenshots {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver",
				"C://Users//allan//OneDrive//Documents//chromedriver-win64//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		File File = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(File, new File("C:\\Users\\allan\\OneDrive\\Pictures\\Screenshots\\Screenshot.jpeg"));
//		System.out.println("GIT check cheyunne");
	}

}
