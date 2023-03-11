package WebsitePages_Library;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base_Library.BaseLibrary;

public class Upload_DownloadPage extends BaseLibrary 
{
	public void Upload_DownloadPage()
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//*[@data-target=\"#elements\"]")
	private WebElement elements;
	
	@FindBy(xpath="//*[text()= \"upload and download\"]")
	private WebElement Upload_Download;
	
	@FindBy(xpath="//*[@class=\"form-control-file\"]")
	private WebElement SelectFile;
	
	public void clickonelements()
	{
		clickme(elements, 0);
	}
	
	public void clickonUploadDownload()
	{
		clickme(Upload_Download, 0);
	}
	
	public void clickonSelectFile()
	{
		clickme(SelectFile, 0);
	}
}
