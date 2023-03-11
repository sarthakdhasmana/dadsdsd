package WebsitePages_Library;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import Base_Library.BaseLibrary;
import ExcelUtility_Library.Excel_Utility;

public class TextBox_Page extends BaseLibrary implements Excel_Utility
{

	public TextBox_Page()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="data-target=\"#elements\"")
	private WebElement elements;
	@FindBy(xpath="//*[text()=\"text box\"]")
	private WebElement textbox;
	@FindBy(xpath="id=\"fullname1\"")
	private WebElement name;
	@FindBy(xpath="//*[@id=\"fullemail1\"]")
	private WebElement email;
	@FindBy(xpath="//*[@id=\"fulladdresh1\"]")
	private WebElement currentaddress;
	@FindBy(xpath="//*[@id=\"paddresh1\"]")
	private WebElement permanentaddress;
	@FindBy(xpath="//*[@value=\"Submit\"]")
	private WebElement submit;
	
	
	public void clickonelements()
	{
		elementtobeclickable(elements, 3);
		elements.click();
	}
	public void clickontextbox()
	{
		textbox.click();
	}
	public void clickonname()
	{
		name.click();
	}
	public void clickonemail()
	{
		email.click();
	}
	public void clickoncurrentaddress()
	{
		currentaddress.click();
	}
	public void clickonpermanentaddress()
	{
		permanentaddress.click();
	}
	public void clickonsubmit()
	{
		submit.click();
	}
	public void filldetails()
	{
		name.sendKeys("Vaibhav");
		email.sendKeys(getreaddata(0,1,1));
		currentaddress.sendKeys(getreaddata(0,2,1));
		permanentaddress.sendKeys(getreaddata(0,3,1));
		submit.click();
		String text=driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
//		Assert.assertEquals("Please Enter Valid Email Address");
		System.out.println(text);
		
	}
	
}
