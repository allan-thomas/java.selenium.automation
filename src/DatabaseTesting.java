import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatabaseTesting {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:/Users/167557/Documents/chromedriver-win64/chromedriver.exe");

//		System.setProperty("webdriver.chrome.driver",
//				"C:\\Users\\allan\\OneDrive\\Documents\\chromedriver-win64\\chromedriver.exe");

		ChromeDriver driver = new ChromeDriver();

		String host = "localhost", port = "3306";

		Connection con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/qadbt", "root", "admin");

		Statement s = con.createStatement();

		ResultSet rs = s.executeQuery("select * from Employeeinfo where name = 'sam'");

		driver.get("https://login.salesforce.com/?locale=in");

		while (rs.next()) {

			driver.findElement(By.xpath("//input[@type='email']")).sendKeys(rs.getString("location"));

			driver.findElement(By.cssSelector("#password")).sendKeys(rs.getString("age"));

			System.out.println(rs.getString("location"));

			System.out.println(rs.getString("age"));
		}
	}

}
