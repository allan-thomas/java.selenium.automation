
import static org.testng.Assert.fail;

import java.awt.Desktop.Action;
import java.awt.Window;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import org.apache.commons.collections4.ArrayStack;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InterviewPrep {

	public static void main(String[] args) throws IOException {

//		int n = 7,i=0,j=0;
//		
//		for(i=0;i<=n;i++) {
//			for (j=n-1;j>1;j--)
//				System.out.print(" ");
//			for(j=1;j<=2*i-1;j++)
//				System.out.print("*");
//			System.out.println("");
//			
//		}
//		
		String name ="ammaa";
		String revname = new StringBuilder(name).reverse().toString();
		if (name.equalsIgnoreCase(revname))
			System.out.println("is palindrome");

		String text = "Arun";
		String[] arr = new String[text.length()];
   	     for (int k = 0; k < text.length(); k++) {
			if (k % 2 == 0) {
				String word ="";
				char char1 = text.charAt(k);
				char char2 = text.charAt(k+1);
				word  = word + char1+ char2;
				arr[k]=word;
			}
		}
	    System.out.println(arr[0]);
		System.out.println(arr[2]);
//
//		String[] chararr = {"a","b"};
//		List<String> chaslist = Arrays.asList(chararr);
//		System.out.println(chaslist.stream().limit(2).anyMatch(s->s.contains("b")));
//	
//		String[] strarr = {"hello how are you", "broo"};
//		System.out.println(strarr[0].charAt(1));
//	
//		List<String> strList = Arrays.asList(strarr);
//		strList.stream().filter(f->f.contains("o")).limit(1).map(m->m.toUpperCase()).forEach(s->System.out.print(s));
//		Boolean b= strList.stream().anyMatch(a->a.contains("o"));
//		System.out.println(b);
//		
//		WebDriver driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
//		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className(text))));
//		
//		Actions a = new Actions(driver);
//		a.moveToElement(driver.findElement(By.cssSelector(text))).doubleClick().build().perform();
//		driver.switchTo().newWindow(WindowType.TAB);
//		
//	Set<String> window = driver.getWindowHandles();
//		Iterator<String> it = window.iterator();
//		String ParentID = it.next();
//		String childID = it.next();
//		driver.switchTo().window(childID);
//		
//		driver.switchTo().frame(driver.findElement(By.id(childID)));
//		
//		String keys = Keys.chord(Keys.CONTROL,Keys.ENTER);
//		a.moveToElement(driver.findElement(By.cssSelector(text))).sendKeys(keys).build().perform();
//		
//		ChromeOptions options = new ChromeOptions();
//		options.setAcceptInsecureCerts(true);
//		
//		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(file, new File(""));
//		
//		WebElement dobText = driver.findElement(By.cssSelector("label[for='dateofBirth']"));

//		String s = "Program";
//		char[] ch = s.toCharArray();
//		boolean[] b = new boolean[s.length()];
//
//		System.out.println("Character Occurrences:");
//		for (int i = 0; i < ch.length; i++) {
//			if (b[i])
//				continue; // Skip already counted characters
//			int c = 1;
//			for (int j = i + 1; j < ch.length; j++) {
//				if (ch[i] == ch[j]) {
//					c++;
//					b[j] = true; // Mark character as counted
//				}
//			}
//			System.out.println(ch[i] + " : " + c);
		
		String [] strings = {"Allan","Nikin","Sree","Lu"};

		List<String> arrayList = Arrays.asList(strings);
		
		ArrayList<String> listt = new ArrayList<String>(arrayList);
		
		System.out.println(listt.get(0));
		
		Stream.concat(listt.stream(), listt.stream()).forEach(s->System.out.println(s));
	}
}
