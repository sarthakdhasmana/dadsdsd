package WebsiteTest_Library;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Base_Library.BaseLibrary;
import WebsitePages_Library.LoginPage;
public class LoginTest extends BaseLibrary
{
	LoginPage ob;
	@BeforeTest
	public void getlaunch()
	{
		getlaunch("https://testingbaba.com/old/");
		ob=new LoginPage();
	}
	@Test
	public void gettitle()
	{
		ob.getWebsiteTitle();
	}
}
