import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class WindowPopUp {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:/Users/167557/Documents/chromedriver-win64/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com");
        driver.findElement(By.linkText("Basic Auth")).click();
    }
}
