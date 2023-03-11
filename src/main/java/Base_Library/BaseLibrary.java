package Base_Library;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import Application_Library.Application_Utility02;
import ExcelUtility_Library.Excel_Utility;
import Property_Library.Property_Utility;
import ScreenShot_Library.ScreenShot_Utility;
import WaitUtility_Library.Wait_Utility;

public class BaseLibrary implements Wait_Utility, ScreenShot_Utility, Property_Utility, Excel_Utility, Application_Utility02
{
	String excel_loc="C:\\Users\\Sarthak Dhasmana\\eclipse-workspace\\FrameWorks_Vaibhav\\TestData\\Book1.xlsx";
	String path="C:\\\\Users\\\\Sarthak Dhasmana\\\\eclipse-workspace\\\\FrameWorks_Vaibhav\\\\Drivers\\\\chromedriver.exe	";
	static public WebDriver driver;
	public void getlaunch(String url)
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sarthak Dhasmana\\eclipse-workspace\\FrameWorks_Vaibhav\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(getreaddata("url"));
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[text()='×']")).click();
		driver.findElement(By.xpath("//*[text()='Practice']")).click();
	}
	@AfterTest
	public void teardown()
	{
		driver.quit();
	}
	@Override
	public String getreaddata(String key)
	{
		String value="";
		try
		{
			FileInputStream fis=new FileInputStream(path);
			Properties prop=new Properties();
			prop.load(fis);
			value=prop.getProperty(key); 
		}
		catch(Exception o)
		{
			System.out.println("Issue in getread data"+o);
		}
		return value;
		
	}
	@AfterMethod
	public void getresultanalysis(ITestResult result)
	{
		String methodname= result.getMethod().getMethodName();
		methodname=methodname+getdata();
		try 
		{
			if(result.isSuccess())
			{
				getscreenshot("Passed", methodname);
			}
			else if(result.getStatus()==ITestResult.FAILURE)
			{
				getscreenshot("Failed", methodname);
			}
		} 
		catch (Exception e) 
		{
		System.out.println("Error Detected"+e);	
		}
		
	}
	@Override
	public String getreaddata(int sheetno, int colno, int rowno) 
	{
		String value="";
		try {
			FileInputStream fis=new FileInputStream(excel_loc);
			XSSFWorkbook wb=new XSSFWorkbook(fis);
			XSSFSheet sheet=wb.getSheetAt(sheetno);
			value=sheet.getRow(rowno).getCell(colno).getStringCellValue();
			
		} 
		catch (Exception e) 
		{
		System.out.println("Issue in Read Data");
		}
		
		return value;
	}
	

	@Override
	public void doubleclick(WebElement ele) 
	{
		Actions act=new Actions(driver);
		act.doubleClick(ele);
	}
	@Override
	public void rightclick(WebElement ele) 
	{
				Actions act=new Actions(driver);
		act.contextClick(ele).perform();
	}
	@Override
	public void changewindow(int tabno) 
	{
		Set<String> set=driver.getWindowHandles();	
		ArrayList<String> fr=new ArrayList<String>(set);
		driver.switchTo().window(fr.get(tabno));
	}
	@Override
	public void elementtobeclickable(WebElement ele, int time) 
	{
		WebDriverWait wait=	new WebDriverWait(driver,time);	
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
	@Override
	public void clickme(WebElement ele, int time) 
	{
		WebDriverWait wait=	new WebDriverWait(driver, time);	
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		ele.click();
	}
//	@Override
//	public void fluentwaittobeclickable(WebElement ele, int time, int poolingtime) 
//	{
//		FluentWait<WebDriver> wait=new FluentWait<WebDriver>(driver);
//		pollingEvery(poolingtime, TimeUnit.SECONDS);
//	}
	@Override
	public void getscreenshot(String foldername, String filename) 
	{
		String location=System.getProperty("user.dir");
		try 
		{
		String path= location+"\\screenshot\\"+foldername+"\\"+filename+".png";
		EventFiringWebDriver efw= new EventFiringWebDriver(driver);
		File src= efw.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File(path));
		
		} 
		catch (Exception e) 
		{
		System.out.println("Issue in getting Screenshot"+e);	
		}
	}
	@Override
	public String getdata() 
	{
		String date="";
		SimpleDateFormat fr= new SimpleDateFormat("dd_MM_yyyy hh_mm_sec a");
		Date fb=new Date();
		date=fr.format(fb);
		return date;
	}
	@Override
	public void fileuploading(String path) 
	{
		try 
		{
		 StringSelection sel=new StringSelection(path);
		 Clipboard tool=Toolkit.getDefaultToolkit().getSystemClipboard();
		 tool.setContents(sel, null);
		 
		 Robot robot=new Robot();
		 robot.keyPress(KeyEvent.VK_ENTER);
		 robot.keyRelease(KeyEvent.VK_ENTER);
		 robot.keyPress(KeyEvent.VK_CONTROL);
		 robot.keyPress(KeyEvent.VK_V);
		 robot.keyRelease(KeyEvent.VK_CONTROL);
		 robot.keyRelease(KeyEvent.VK_V);
		 robot.keyPress(KeyEvent.VK_ENTER);
		 robot.delay(250);
		 robot.keyRelease(KeyEvent.VK_ENTER);
		 
		} 
		catch (Exception e) 
		{
			
		}
	}
	@Override
	public void dropdownbyvalue(WebElement ele, String value) 
	{
		Select sel=new Select(ele);
		sel.selectByVisibleText(value);
	}
	@Override
	public void mousehover(WebElement ele) 
	{
		Actions act=new Actions(driver);
		act.moveToElement(ele).perform();
	}
	@Override
	public void mousehoverclick(WebElement ele, String value) 
	{
		Actions act=new Actions(driver);
		act.moveToElement(ele).build().perform();
		driver.findElement(By.linkText(value)).click();
	}
}
