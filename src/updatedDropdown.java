

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class updatedDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:/Users/167557/Documents/chromedriver-win64/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.spicejet.com/");
		//System.out.println(driver.findElement(By.cssSelector("div[data-testid='return-date-dropdown-label-test-id']")).isEnabled());
		driver.findElement(By.cssSelector("div[data-testid='round-trip-radio-button'] svg circle")).click();
		Thread.sleep(2000);
		//System.out.println(driver.findElement(By.cssSelector("div[data-testid='return-date-dropdown-label-test-id']")).getDomAttribute("style"));
//		if (driver.findElement(By.cssSelector("div[data-testid='return-date-dropdown-label-test-id']")).getDomAttribute("style").contains("background-color: rgb(238, 238, 238);")) {
//			System.out.println("True");
//			Assert.assertTrue(true);
//		} else {
//			System.out.println("False");
//			Assert.assertTrue(false);
//		}
		driver.findElement(By.cssSelector(".css-1dbjc4n.r-1awozwy.r-z2wwpe.r-1loqt21.r-18u37iz.r-1777fci.r-d9fdf6.r-1w50u8q.r-ah5dr5.r-1otgn73")).click();
		//System.out.println(driver.findElement(By.cssSelector("div[data-testid='return-date-dropdown-label-test-id']")).isEnabled());
		
		//driver.findElement(By.xpath("//div[text()='Family & Friends']")).click();
		//System.out.println(driver.findElement(By.xpath("//div[text()='Family & Friends']")).isSelected());
		//driver.findElement(By.xpath("//div[@data-testid='to-testID-origin']")).click();
		//driver.findElement(By.xpath("//div[text()='Bengaluru']")).click();
		//Thread.sleep(2000);
		//driver.findElement(By.xpath("//div[contains(text(),'Kochi')]")).click();
		//Thread.sleep(2000);
		//driver.findElement(By.cssSelector("div[class='css-1dbjc4n r-1loqt21 r-19bllq0 r-u8s1d r-1v2oles r-1otgn73 r-16zfatd r-eafdt9 r-1i6wzkk r-lrvibr r-184en5c'] svg")).click();
		//driver.findElement(By.cssSelector(".css-1dbjc4n.r-1awozwy.r-19m6qjp.r-156aje7.r-y47klf.r-1phboty.r-1d6rzhh.r-1pi2tsx.r-1777fci.r-13qz1uu")).click();	
		//int i=1;
		//while (i<5) {
			//driver.findElement((By.cssSelector("div[class='css-1dbjc4n r-k8qxaj r-d9fdf6'] div:nth-child(1) div:nth-child(2) div:nth-child(3)"))).click();
			//i++;
		//}
		//driver.findElement(By.cssSelector("div[class='css-1dbjc4n'] div[class='css-1dbjc4n r-1awozwy r-19m6qjp r-z2wwpe r-1loqt21 r-18u37iz r-1777fci r-d9fdf6 r-1w50u8q r-ah5dr5 r-1otgn73']")).click();
		//System.out.println(driver.findElement(By.cssSelector("div[class='css-1dbjc4n'] div div[class='css-1dbjc4n r-14lw9ot r-11u4nky r-z2wwpe r-1phboty r-rs99b7 r-1loqt21 r-13awgt0 r-ymttw5 r-5njf8e r-1otgn73'] div[class='css-76zvg2 css-bfa6kz r-homxoj r-ubezar']")).getText());

	}

}
