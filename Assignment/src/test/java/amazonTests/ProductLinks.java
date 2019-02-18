package amazonTests;

import org.testng.annotations.Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pageObjects.AmazonPage;

public class ProductLinks extends utilities.Base_Methods{
	
	AmazonPage page;
	
  @Test(priority=1)
  public void get_HREF() {
	  //get the ul of all products using PageFactory
	  WebDriverWait wait = new WebDriverWait(driver, 15);
	  WebElement ul = wait.until(ExpectedConditions.visibilityOf(page.get_productsUL()));
	  
	  //Getting list of all anchor tags inside the ul list
	  List<WebElement> refList = ul.findElements(By.tagName("a"));
	  
	  int i=1;
	  //Loop through each anchor element
	  for(WebElement ele : refList) {
		  //print href to console
		  System.out.println("Product "+i+" HREF: "+ele.getAttribute("href"));
		  i++;
	  }
	  
  }
  @BeforeClass
  public void beforeClass() {
	  LoadPropertyFile("configuration.properties");
	  try {
		OpenBrowser(p.getProperty("test1_browser"), p.getProperty("test1_url"), p.getProperty("test1_title"));
	  } catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	  }
	  page = new AmazonPage(driver);
  }
  
  @AfterClass
  public void stopClass() {
	  tearDown();
  }
}
