import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Assignment8_fromLap {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/allan/OneDrive/Documents/chromedriver-win64/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		WebElement textBox = driver.findElement(By.cssSelector(".inputs.ui-autocomplete-input"));
		textBox.sendKeys("ind");
		Thread.sleep(2000);
		textBox.sendKeys(Keys.DOWN);textBox.sendKeys(Keys.DOWN);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(2000);
		System.out.println(js.executeScript("document.getElementById('autocomplete').value;"));
//		int i =0 ;
//		while(i<2) {
//			textBox.sendKeys(Keys.DOWN);
//			i++;
//		}
	}

}
