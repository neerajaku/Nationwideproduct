Feature: Find a mortgage rate
  As a new customer
  I want to find the mortgage rates available
  So that I can decide whether to switch my mortgage to Nationwide

  @Pending
  Scenario Outline: Find mortgage rates
  Given I open the url "https://www.nationwide.co.uk"
  When User navigates to Mortgages-New mortgae customer-Mortgage rates
  When User not Nationwide customer changing lender check property value <property> mortgage amount <mortgage> term <term>
  Then Check results
  Then verify next page heading
  And Close Browser
  
 Examples:
 |property        |mortgage      |term  |
 |300,000         |150,000       |30    |
 
