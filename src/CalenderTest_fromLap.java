import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CalenderTest_fromLap {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/allan/OneDrive/Documents/chromedriver-win64/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		String monthNumber = "6";
		String date = "15";
		String year = "2027";
		String[] expectedDate = {monthNumber,date,year};
		int i = 0;
		driver.findElement(
				By.cssSelector("svg.react-date-picker__calendar-button__icon.react-date-picker__button__icon")).click();
		while (i < 2) {
			driver.findElement(By.cssSelector("button.react-calendar__navigation__label")).click();
			i++;
		}
		driver.findElement(
				By.cssSelector("button.react-calendar__tile.react-calendar__decade-view__years__year:nth-child(7)"))
				.click();
		driver.findElement(
				By.cssSelector("button.react-calendar__tile.react-calendar__year-view__months__month:nth-child(6)"))
				.click();
		driver.findElement(By.cssSelector("button:nth-child(16)")).click();
		List<WebElement> actualList = driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));
		for (i = 0; i < actualList.size(); i++) {
			System.out.println(actualList.get(i).getDomAttribute("value"));
			Assert.assertEquals(actualList.get(i).getDomAttribute("value"),expectedDate[i],"Test Passed");
		}
		// Assert.assertEquals(driver.findElement(By.cssSelector(".react-date-picker__inputGroup")).getText(),
		// monthNumber+"/"+date+"/"+year);
	}
}
