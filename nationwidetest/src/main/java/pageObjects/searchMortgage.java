package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class searchMortgage {

	public WebDriver driver;
	By nomortgage=By.xpath("//label[@id='selectorItemHaveNationwideMortgage1']");
	By change_lender=By.xpath("//label[@id='selectorItemNationwideMortgageTypeNo2']");
	By prop_val=By.id("SearchPropertyValue");
	By mortage_amt=By.id("SearchMortgageAmount");
	By term=By.id("SearchMortgageTerm");
	By find_mortgage=By.id("myButton");
	
	
	public searchMortgage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement getNoMortgage()
	{
		return driver.findElement(nomortgage);
	}
	
	public WebElement change_Lenger()
	{
		return driver.findElement(change_lender);
	}
	
	public WebElement getPropVal()
	{
	    return driver.findElement(prop_val);   
	}
	
	public WebElement getMortgageAmt()
	{
		return driver.findElement(mortage_amt);
	}
	
	public WebElement getTerm()
	{
		return driver.findElement(term);
	}
	
	public WebElement getFindMortgage()
	{
		return driver.findElement(find_mortgage);
	}
}
