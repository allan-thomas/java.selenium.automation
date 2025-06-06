import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class actionsDemo {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:/Users/167557/Documents/chromedriver-win64/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		Actions a = new Actions(driver);
		WebElement move = driver.findElement(By.xpath("//a[@href='/account/login?ret=/']"));
		a.moveToElement(move).build().perform();
		a.moveToElement(driver.findElement(By.cssSelector("input.Pke_EE"))).click().keyDown(Keys.SHIFT)
				.sendKeys("Jersy").doubleClick().contextClick().build().perform();
		System.out.println("Hello");

	}

}

