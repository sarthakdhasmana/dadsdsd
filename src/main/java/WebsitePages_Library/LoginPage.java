package WebsitePages_Library;

import Base_Library.BaseLibrary;

public class LoginPage extends BaseLibrary
{
	public void getWebsiteTitle()
	{
		String title= driver.getTitle();
		System.out.println("Website Title");
	}
}
