package WebsiteTest_Library;

import Base_Library.BaseLibrary;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import WebsitePages_Library.Upload_DownloadPage;

public class Upload_DownloadTest extends BaseLibrary
{
	String path="C:\\Users\\Sarthak Dhasmana\\eclipse-workspace\\FrameWorks_Vaibhav\\TestData\\Book1.xlsx";
	Upload_DownloadPage ob;
	@BeforeTest
	public void getlaunch()
	{
		getlaunch(getreaddata("url"));
		ob=new Upload_DownloadPage();
	}
	
	@Test(priority=0)
	public void clickonelements()
	{
		ob.clickonelements();
	}
	
	@Test(priority=1)
	public void clickonuploaddownload()
	{
		ob.clickonUploadDownload();;
	}
	
	@Test(priority=2)
	public void clickonselectfile()
	{
	try 
	{
		ob.clickonSelectFile();
		Thread.sleep(5000);
		fileuploading(path);
	}
	catch (Exception e) 
	{
	System.out.println("Issue in File Uploading");
	}
	}
}
