import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;

public class FileUploadWithAutoIT {
    public static void main(String[] args) throws InterruptedException, IOException {
//        System.setProperty("webdriver.chrome.driver", "C:/Users/167557/Documents/chromedriver-win64/chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://www.canva.com/features/pdf-to-jpg-converter/");
//        driver.findElement(By.cssSelector("button[class*='_5KtATA LQzFZw VgvqkQ _8ERLTg MCgm0w Z3nT2A LQzFZw VgvqkQ _4_iekA j34Zww aqbYPg _3FvZZg']")).click();
//        Thread.sleep(3000);
//        ProcessBuilder pb = new ProcessBuilder("C:/Users/167557/Documents/AutoIT/your_script.exe");
//        pb.start();

        //for downloading the file, but via another site
        System.setProperty("webdriver.chrome.driver", "C:/Users/167557/Documents/chromedriver-win64/chromedriver.exe");
        String downloadPath = System.getProperty("user.dir");
        System.out.println(downloadPath);
        ChromeOptions options = new ChromeOptions();
        HashMap<String, Object> chromePrefs = new HashMap<>();
        //chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", downloadPath + "\\downloads");
        options.setExperimentalOption("prefs", chromePrefs);
        WebDriver driver1 = new ChromeDriver(options);
        driver1.get("https://freetestdata.com/document-files/doc/");
        WebDriverWait wait = new WebDriverWait(driver1, Duration.ofSeconds(3000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href*='100KB_DOC.doc']")));
        driver1.findElement(By.cssSelector("a[href*='100KB_DOC.doc']")).click();
        File file = new File(downloadPath + "/downloads/Free_Test_Data_100KB_DOC.doc");
        Thread.sleep(3000);
        if (file.exists()) {
            System.out.println("File downloaded successfully");
            Assert.assertTrue(file.exists());
            if(file.delete()) //deletes the file
                System.out.println("File deleted successfully");
        } else {
            System.out.println("File not downloaded");
        }
        driver1.quit();
    }
}
