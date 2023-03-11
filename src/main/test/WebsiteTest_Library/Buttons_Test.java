package WebsiteTest_Library;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base_Library.BaseLibrary;
import WebsitePages_Library.Buttons_Page;

public class Buttons_Test extends BaseLibrary
{

	Buttons_Page ob;
	@BeforeTest
	public void getlaunchurl()
	{
		getlaunch(getreaddata("url"));
		ob=new Buttons_Page();
	}
	@Test(priority = 0)
	public void clickonelements()
	{
		ob.clickonelements();
	}
	@Test(priority =1)
	public void clickonbuttons()
	{
		ob.clickonbuttons();
	}
	@Test(priority=2)
	public void clickondouble_rightclick()
	{
		ob.clickondouble_rightclick();
	}
	
}
