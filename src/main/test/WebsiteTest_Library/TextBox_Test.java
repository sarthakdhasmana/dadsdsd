package WebsiteTest_Library;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Base_Library.BaseLibrary;
import WebsitePages_Library.TextBox_Page;

public class TextBox_Test extends BaseLibrary
{
	TextBox_Page ob;
//	Application_Utility ob;
	@BeforeTest
	public  void getlaunchurl()
	{
		getlaunch(getreaddata("url"));
//		ob1=new Application_Utility();
//		getlaunch(ob1.getreaddata(path, "url"));
		ob=new TextBox_Page();
	}
	@Test(priority = 1)
	public void clickonelements()
	{
		ob.clickonelements();
	}
	
	@Test(priority = 2)
	public void clickonTextBox()
	{
		ob.clickontextbox();
	}
}
