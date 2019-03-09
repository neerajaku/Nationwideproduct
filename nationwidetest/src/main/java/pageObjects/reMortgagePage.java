package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class reMortgagePage {

	public WebDriver driver;
	By page_heading=By.xpath("//*[@id='content_2_contentheader_0_GridContainer']/div/div/section/h1");
	
	public reMortgagePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement getPageHead()
	{
		return driver.findElement(page_heading);
	}
}
