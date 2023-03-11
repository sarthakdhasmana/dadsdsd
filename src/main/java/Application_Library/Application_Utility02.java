package Application_Library;

import org.openqa.selenium.WebElement;

public interface Application_Utility02 
{

	public void doubleclick(WebElement ele);
	
	public void rightclick(WebElement ele);
	public void changewindow(int tabno);
	public void clickme(WebElement ele, int time);
	public String getdata();
	public void fileuploading(String path);
	public void dropdownbyvalue(WebElement ele, String value);
	public void mousehover(WebElement ele);
	public void mousehoverclick(WebElement ele, String value);
}
