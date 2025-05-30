import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class streamsDemo {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C://Users//allan//OneDrive//Documents//chromedriver-win64//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.xpath("//tr/th[1]")).click();
		List<WebElement> elements = driver.findElements(By.xpath("//td[1]"));
		List<String> originalNames = elements.stream().map(m->m.getText()).collect(Collectors.toList());
		System.out.println(originalNames);
		List<String> sortedNames =  elements.stream().map(m->m.getText()).sorted().collect(Collectors.toList());
		Assert.assertTrue(originalNames.equals(sortedNames)); 
		List<String> priceofBeans;
		
		//scan the the row, get the price of the "Beans"
		do {
			List<WebElement> nameRows = driver.findElements(By.xpath("//td[1]"));
		priceofBeans = nameRows.stream().filter(s->s.getText().contains("Pineapple")).map(s->veggiePrice(s)).collect(Collectors.toList());
//		System.out.println(priceofBeans);
		priceofBeans.forEach(a->System.out.println(a));
		
		if(priceofBeans.size()<1)  {
			driver.findElement(By.cssSelector("[aria-label='Next']")).click();
			Thread.sleep(2000);
		}
		}while(priceofBeans.size()<1);
	}

	private static String veggiePrice(WebElement m) {
		String pricevalue = m.findElement(By.xpath("following-sibling::td[1]")).getText();
		return pricevalue;
	}

}
