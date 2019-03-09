package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class homePage {
	
	public WebDriver driver;
	
	By mortgages=By.id("MortgagesNavItem");
	By mortgagerates=By.xpath("//*[@id='MortgagesNavItem']/div/div/div/div[1]/ul/li[1]/a");
	
	
	public homePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement getMortgage()
	{
		return driver.findElement(mortgages);
	}

	public WebElement getMortgagerate()
	{
		return driver.findElement(mortgagerates);
	}
	
	
	
}
