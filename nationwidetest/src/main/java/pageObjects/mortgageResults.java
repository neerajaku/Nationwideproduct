package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class mortgageResults {

	public WebDriver driver;
	
	By mortgagetable=By.id("NewMortgageRateTables");
	By table_rows_count=By.cssSelector("*[class*='ratesTableWrapper']");
	By apply=By.xpath("//a[contains(@data-nbs-analytics-options,'5 yr Fixed |Apply|2')]");
	
	public mortgageResults(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement getMortgageTable()
	{
		return driver.findElement(mortgagetable);
	}
	
	public int getRowCount()
	{
		return driver.findElements(table_rows_count).size();
	}
	
	public WebElement getApply()
	{
		return driver.findElement(apply);
	}
}
