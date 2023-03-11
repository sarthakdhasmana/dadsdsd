package WebsiteTest_Library;
import Base_Library.BaseLibrary;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import WebsitePages_Library.SelectMenu_Page;

public class SelectMenu_test extends BaseLibrary 
{
	SelectMenu_Page ob;
	@BeforeTest
	public void getlaunch()
	{
		getlaunch(getreaddata("url"));
		ob=new SelectMenu_Page();
	}
	@Test(priority=1)
	public void clickonwidgets()
	{
		ob.widgets();
	}
	
	public void clickonmenu()
	{
		ob.selectmenu();
	}
	
	public void clickonvalue()
	{
		ob.selectvalue();
	}
}
