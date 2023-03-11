package WebsitePages_Library;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base_Library.BaseLibrary;

public class SelectMenu_Page extends BaseLibrary
{
	public void Selectmenu()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@data-target=\"#widget\"]")
	private WebElement widgets;
	
	@FindBy(xpath="//*[@href=\"#tab_24\"]")
	private WebElement selectmenu;
	
	@FindBy(xpath="//*[@id=\"tab_24\"]/form/div/div[1]/select")
	private WebElement selectvalue;
	
	public void widgets()
	{
		widgets.click();
	}
	
	public void selectmenu()
	{
		selectmenu.click();
	}
	
	public void selectvalue()
	{
		dropdownbyvalue(selectvalue, "Group 2, Option 2");	
		
	}
}
