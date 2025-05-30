import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class RelativeLocators {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C://Users//allan//OneDrive//Documents//chromedriver-win64//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://rahulshettyacademy.com/angularpractice/");
		WebElement nameEditBox = driver.findElement(By.cssSelector("[name='name']"));
		System.out.println( driver.findElement(with(By.tagName("label")).above(nameEditBox)).getText());
		
		WebElement dobText = driver.findElement(By.cssSelector("label[for='dateofBirth']"));
		driver.findElement(with(By.tagName("input")).below(dobText)).click();
	}

}
