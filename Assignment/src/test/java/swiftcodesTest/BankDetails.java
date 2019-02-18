package swiftcodesTest;

import org.testng.annotations.Test;

import pageObjects.SwiftCode;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BankDetails extends utilities.Base_Methods{
	SwiftCode page;
  @Test(priority=2)
  public void getBankDetails() {
	//get the ul of all products using PageFactory
	  WebDriverWait wait = new WebDriverWait(driver, 15);
	  WebElement tbl = wait.until(ExpectedConditions.visibilityOf(page.get_table()));
	  
	  //Getting list of all rows inside the table list
	  List<WebElement> rows = tbl.findElements(By.tagName("tr"));
	  
	  int i=1;
	  //Loop through each anchor element
	  for(WebElement ele : rows) {
		  //check it the row is header? First tr will be header.
		  if(i==1) {
			  i++;
			  continue;
		  }
		  
		  //Get all td inside the tr
		  List<WebElement> row_td = ele.findElements(By.tagName("td"));
		  
		  //Check if row has advertisement. Row with Ad has only one td.
		  if(row_td.size()<=1)
			  continue;
		  
		  //if above two conditions fail then we need to get details of the bank and print
		  for(WebElement td : row_td) {
			  System.out.print(td.getText()+"\t");
		  }
		  System.out.println("");
		  i++;
	  }
  }
  
  @BeforeClass
  public void beforeClass() {
	  LoadPropertyFile("configuration.properties");
	  try {
		OpenBrowser(p.getProperty("test2_browser"), p.getProperty("test2_url"), p.getProperty("test2_title"));
	  } catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	  }
	  page = new SwiftCode(driver);
  }
  
  @AfterClass
  public void stopClass() {
	  tearDown();
  }

}
