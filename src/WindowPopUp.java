import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowPopUp {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:/Users/167557/Documents/chromedriver-win64/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://admin:admin@the-internet.herokuapp.com");
        driver.findElement(By.linkText("Basic Auth")).click(); // i click on the link which opens the pop up

    }
}
