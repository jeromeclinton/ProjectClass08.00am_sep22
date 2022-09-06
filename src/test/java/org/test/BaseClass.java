package org.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	//browser launch
	public static WebDriver browserLanch(String browsername) {
		if(browsername.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browsername.equalsIgnoreCase("fireFox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(browsername.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		return driver;
		
	}
	//urlLaunch
	public static void urlLanch(String e) {
		driver.get(e);
	}
	//timeImplycity and maximize
	public static void timeImplycity(long sec) {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
	}
	//currentUrl
	public static String currentUrl() {
		return driver.getCurrentUrl();
	}
	//getTitle
	public static String getTitle() {
		return driver.getTitle();
	}
	//sendKeys
	public static String sendKeys(WebElement text,String value) {
		text.sendKeys(value);
		return value; 
	}
	//click
	public static void click(WebElement e) {
		e.click();
	}
	//clear
	public static void clear(WebElement e) {
		e.clear();
	}
	//get attribute
	public static String getAttribute(WebElement e) {
		return  e.getAttribute("value");
	}
	//get text
	public static String getText(WebElement e) {
		return e.getText();
	}
	//moveToElement
	public static void moveToElement(WebElement target) {
		Actions a=new Actions(driver);
		a.moveToElement(target).perform();
	}
	//actionClick
	public static void actionClick(WebElement target) {
		Actions a=new Actions(driver);
		a.click(target).perform();
	}
	//takeScreenshot
	public static void takeScreenshot() throws IOException {
		TakesScreenshot tk=(TakesScreenshot)driver;
		File scr = tk.getScreenshotAs(OutputType.FILE);
		File des=new File("D:\\Eclipse\\Maven\\src\\test\\resources\\screenshot"+System.currentTimeMillis() +"tk.png");
		FileUtils.copyFile(scr, des);			
	}
	//threadSleep
	public static void threadSleep(long e) throws InterruptedException {
		Thread.sleep(e);
	}
	//jsSetAttribut
	public static void jsSetAttribut(WebElement e,String value) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('value','"+value+"')",e);
	}
	//jsGetAttribute
	public static Object jsGetAttribute(WebElement e) {
		JavascriptExecutor js=(JavascriptExecutor)driver; 
		return js.executeScript("return arguments[0].getAttribute('value')",e);
	}
	public static void scrollDown(WebElement e) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scorllIntoView(false)",e);
	}
	public static void scrollUp(WebElement e) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scorllIntoView(ture)",e);
	}
	// WindowHandlie
	public static WebDriver windowsHandile() {
		String parentId = driver.getWindowHandle();
		WebDriver parentid = driver.switchTo().window(parentId);
		return parentid;
	}
	//list of  WindowHandlies
	public static void WindowHandliesss(long windowNumber) {
		 Set<String> allId = driver.getWindowHandles();
		 int count=0;
		 for (String eachId : allId) {
			if(count==windowNumber) {
				driver.switchTo().window(eachId);
			}
			count++;
		}

	}
	//close
	public static void close() {
		driver.close();
	}
	//quit
	public static void quit() {
		driver.quit();
	}
	//selectByIndex
	public static void selectByIndex(WebElement e,int a) {
		Select s=new Select(e);
		s.selectByIndex(a);
	}
	//selectByValue
	public static void selectByValue(WebElement e,String value) {
		Select s=new Select(e);
		s.selectByValue(value);	
	}
	public static void alertAccept() {
		Alert a = driver.switchTo().alert();
		a.accept();
	}
	public static void alertDismiss() {
		Alert a = driver.switchTo().alert();
		a.dismiss();
	}	
	public static String getExcel(String fileName,String sheet,int row,int cel) throws IOException {
		File f=new File("D:\\Eclipse\\Testng\\src\\test\\resources\\"+fileName+".xlsx");
		FileInputStream fi=new FileInputStream(f);
		Workbook w=new XSSFWorkbook(fi);
		Sheet s = w.getSheet(sheet);
		Row r = s.getRow(row); 
		Cell cell = r.getCell(cel);
		int Type = cell.getCellType();
		String value=null;
		if(Type==1) {
			 value = cell.getStringCellValue();
		}
		else {
			if(DateUtil.isCellDateFormatted(cell)) {
				 value = new SimpleDateFormat("dd/MM/yyyy").format(cell.getDateCellValue());
			}
			else {
				value = String.valueOf((long)cell.getNumericCellValue());
			}
		}
		return value;
		
	}
	
	public static boolean isSelected(WebElement e) {
		return e.isSelected();
	}
	
	
	
	

}
