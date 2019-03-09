package stepDefinition;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import cucumber.api.java.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import pageObjects.homePage;
import pageObjects.mortgageResults;
import pageObjects.reMortgagePage;
import pageObjects.searchMortgage;
import resources.base;


public class stepDefinition extends base{
	
	public static Logger log =LogManager.getLogger(stepDefinition.class.getName());
	
		
	@Given("^I open the url \"([^\"]*)\"$")
	public void i_open_the_url(String arg1) throws Throwable 
	{
		
		driver =initializeDriver();
		log.info("Driver Initialized");
		
		driver.get(arg1);
		log.info("Navigated to Nationwide HomePage");
		
	 }

	@When("^User navigates to Mortgages-New mortgae customer-Mortgage rates$")
	public void user_navigates_to_Mortgages_New_mortgae_customer_Mortgage_rates() throws Throwable {
	    
		Actions a=new Actions(driver);
		homePage hp=new homePage(driver);
		a.moveToElement(hp.getMortgage()).build().perform();
		Thread.sleep(2000);
		a.moveToElement(hp.getMortgagerate()).build().perform();
		Thread.sleep(2000);
		hp.getMortgagerate().click(); 
		log.info("Successfully navigated to New Customer Mortgage rates");
		
	}
	
	

	 @When("^User not Nationwide customer changing lender check property value (.+) mortgage amount (.+) term (.+)$")
	    public void user_not_nationwide_customer_changing_lender_check_property_value_mortgage_amount_term(String property, String mortgage, String term) throws Throwable 
	 {
	        
		    searchMortgage sm=new searchMortgage(driver);
			sm.getNoMortgage().click();
			sm.change_Lenger().click();
			sm.getPropVal().sendKeys(property);
			sm.getMortgageAmt().sendKeys(mortgage);
			sm.getTerm().sendKeys(term);
			sm.getFindMortgage().click();
			log.info("Successfully entered the property check values");
	 }
	 

	@Then("^Check results$")
	public void check_results() throws Throwable 
	{
		mortgageResults mr=new mortgageResults(driver);
		int table_row_count=mr.getRowCount();
		System.out.println("row count"+table_row_count);
		int two_year_fixed=0;
		int three_year_fixed=0;
		int five_year_fixed=0;
		int ten_year_fixed=0;
		int j=0;
		for(int i=1;i<=table_row_count;i++)
		{
			if(mr.getMortgageTable().findElement(By.xpath("//*[@id='NewMortgageRateTables']/div["+i+"]/div/table/tbody/tr[1]/th[2]")).getText().equalsIgnoreCase("2 yr Fixed"))
		       {
			      two_year_fixed=two_year_fixed+1;
		       }
		   else if(mr.getMortgageTable().findElement(By.xpath("//*[@id='NewMortgageRateTables']/div["+i+"]/div/table/tbody/tr[1]/th[2]")).getText().equalsIgnoreCase("3 yr Fixed"))
		      {
		         three_year_fixed=three_year_fixed+1;
		      }
		   else if (mr.getMortgageTable().findElement(By.xpath("//*[@id='NewMortgageRateTables']/div["+i+"]/div/table/tbody/tr[1]/th[2]")).getText().equalsIgnoreCase("5 yr Fixed"))
		      {
			     five_year_fixed=five_year_fixed+1;
			
			      j=i;
		      }
	      else if(mr.getMortgageTable().findElement(By.xpath("//*[@id='NewMortgageRateTables']/div["+i+"]/div/table/tbody/tr[1]/th[2]")).getText().equalsIgnoreCase("10 yr Fixed"))
		     {
		    	ten_year_fixed=ten_year_fixed+1;
		     }
			
		}
	    
	   
	    Assert.assertTrue(two_year_fixed>0);
		Assert.assertTrue(three_year_fixed>0);
		Assert.assertTrue(five_year_fixed>0);
		Assert.assertTrue(ten_year_fixed>0);
		
		mr.getMortgageTable().findElement(By.xpath("//*[@id='NewMortgageRateTables']/div["+j+"]/div/table/tbody/tr[1]/th[8]/a/span[1]")).click();
		mr.getApply().click();
		log.info("Successfully filtered results and verifying more info for 5 yr Fixed");
	}

	@Then("^verify next page heading$")
	public void verify_next_page_heading() throws Throwable 
	{
		reMortgagePage rmp=new reMortgagePage(driver);
		//System.out.println(rmp.getPageHead().getText());
		Assert.assertTrue(rmp.getPageHead().getText().equalsIgnoreCase("Start your remortgage application"));
	    log.info("Successfully verified page heading");
	}

    

    @And("^Close Browser$")
    public void close_browser() throws Throwable 
    {
    	      
        driver.quit();
       	driver=null;
        
    }

}
