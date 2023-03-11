package WebsitePages_Library;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base_Library.BaseLibrary;

public class Buttons_Page extends BaseLibrary
{

	public void buttonspage()
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="href=\"#tab_5\"")
	private WebElement buttons;
	@FindBy(xpath="//*[@data-target=\"#elements\"]")
	private WebElement elements;
	@FindBy(xpath="//*[@ondblclick=\"doubletext()\"]")
	private WebElement doubleclick;
	@FindBy(xpath="//*[@oncontextmenu=\"righttext()\"]")
	private WebElement rightclick;
	
	public void clickonelements()
	{
		clickme(elements);
	}
	public void clickonbuttons()
	{
		buttons.click();
	}
	public void clickondouble_rightclick()
	{
		doubleclick(doubleclick);
		rightclick(rightclick);
		getscreenshot("passed", "clickonpassed_doubleclick");
	}
	
	
	
	
	
}
