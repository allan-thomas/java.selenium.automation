

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ExcelUploadDownload {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:/Users/167557/Documents/chromedriver-win64/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		Actions a = new Actions(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();

		// download
		driver.get("https://rahulshettyacademy.com/upload-download-test/");
		a.click(driver.findElement(By.id("downloadButton"))).build().perform(); // Kazapp
		Thread.sleep(3000);
		// driver.findElement(By.id("downloadButton")).click();

		// edit the excel

		String fileName = "C:\\Users\\167557\\Downloads\\download.xlsx";

		String fruitName = "Apple";
		String newPrice = "599";

		int rowno = getRowNumber(fileName, fruitName);
		int colno = getColoumnNumber(fileName, "price");

		Assert.assertTrue(updateCell(fileName, rowno, colno, newPrice));

		// upload the excel
		WebElement upldButton = driver.findElement(By.cssSelector("input[type='file']"));
		upldButton.sendKeys("C:\\Users\\167557\\Downloads\\download.xlsx");

		// wait for success message to show up and wait for disappear
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		By toastLocator = By.xpath("//div[contains(@class,'Toastify__toast--close-on-click')]");
		wait.until(ExpectedConditions.visibilityOfElementLocated(toastLocator));
		String toastMsg = driver.findElement(toastLocator).getText();
		// System.out.println(toastMsg);
		Assert.assertEquals("Updated Excel Data Successfully.", toastMsg);
		wait.until(ExpectedConditions
				.invisibilityOfElementLocated(By.xpath("//div[contains(@class,'Toastify__toast--close-on-click')]")));

		// traversing through the table for getting the apple price
		String priceColumn = driver.findElement(By.xpath("//div[text()='Price']")).getDomAttribute("data-column-id");
		String actualPrice = driver.findElement(By.xpath("//div[text()='" + fruitName
				+ "']/parent::div/parent::div/div[@id='cell-" + priceColumn + "-undefined']")).getText();

		// verify updated excel data showing in the web table
		Assert.assertEquals(newPrice, actualPrice);
		driver.close();
		System.out.println("Set");

	}

	private static int getRowNumber(String fileName, String fruitName) throws IOException {
		FileInputStream file = new FileInputStream(fileName);
		XSSFWorkbook wb = new XSSFWorkbook(file);

		XSSFSheet sheet = wb.getSheetAt(0);
		int k = 0, rowCount = 0;
		Iterator<Row> row = sheet.iterator();
		while (row.hasNext()) {
			Row rows = row.next();
			Iterator<Cell> cell = rows.cellIterator();
			while (cell.hasNext()) {
				Cell cells = cell.next();
				if (cells.getCellType() == CellType.STRING && cells.getStringCellValue().equalsIgnoreCase(fruitName))
					rowCount = k;
			}
			k++;
		}

		return rowCount;

		// hard coding to get Apple price >>
//		while (row.hasNext()) {
//			Row rows = row.next();
//			Iterator<Cell> cell = rows.cellIterator();
//			while (cell.hasNext()) {
//				Cell cells = cell.next();
//				if (cells.getCellType() == CellType.STRING) {
//					if (cells.getStringCellValue().equalsIgnoreCase("Apple")) {
//						System.out.println(cells.getStringCellValue());
//						while (cell.hasNext()) {
//							Cell cellApple = cell.next();
//							if (cellApple.getCellType() == CellType.NUMERIC) {
//								if (cellApple.getNumericCellValue() == 345) {
//									System.out.println(cellApple.getNumericCellValue());
//									cellApple.setCellValue(400);
//									System.out.println(cellApple.getNumericCellValue());

	}

	private static int getColoumnNumber(String fileName, String string) throws IOException {
		FileInputStream file = new FileInputStream(fileName);
		XSSFWorkbook wb = new XSSFWorkbook(file);

		XSSFSheet sheet = wb.getSheetAt(0);
		int k = 0, colCount = 0;
		Iterator<Row> row = sheet.rowIterator();
		Row firstRow = row.next();
		Iterator<Cell> cells = firstRow.cellIterator();
		while (cells.hasNext()) {
			Cell cell = cells.next();
			if (cell.getCellType() == CellType.STRING && cell.getStringCellValue().equalsIgnoreCase(string))
				colCount = k;
			k++;
		}
		return colCount;
	}

	private static boolean updateCell(String fileName, int rowno, int colno, String string) throws IOException {
		FileInputStream file = new FileInputStream(fileName);
		XSSFWorkbook wb = new XSSFWorkbook(file);
		XSSFSheet sheet = wb.getSheetAt(0);
		XSSFRow row = sheet.getRow(rowno);
		XSSFCell cell = row.getCell(colno);
		cell.setCellValue(string);
		FileOutputStream fos = new FileOutputStream(fileName);
		wb.write(fos);
		wb.close();
		fos.close();
		file.close();
		return true;

	}
}
