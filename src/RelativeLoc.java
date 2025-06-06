import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class RelativeLoc {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:/Users/167557/Documents/chromedriver-win64/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://rahulshettyacademy.com/angularpractice/");
		WebElement checkBoxContent = driver.findElement(By.xpath("(//label[@class='form-check-label'])[1]"));
		driver.findElement(with(By.tagName("input")).toLeftOf(checkBoxContent)).click();
		}

}
