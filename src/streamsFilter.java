import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class streamsFilter {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C://Users//allan//OneDrive//Documents//chromedriver-win64//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String val = "Rice";
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.cssSelector("#search-field")).sendKeys(val);
		List<WebElement> elements = driver.findElements(By.xpath("//td[1]"));
		List<WebElement> originalNames = elements.stream().filter(f->f.getText().contains(val)).collect(Collectors.toList());
		Assert.assertEquals(originalNames.size(),elements.size());
		List<String> filValues = originalNames.stream().map(m->m.getText()).collect(Collectors.toList());
		filValues.forEach(f->System.out.println(f));
	}

}
