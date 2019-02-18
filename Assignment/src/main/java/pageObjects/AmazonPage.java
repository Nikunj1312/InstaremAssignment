package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonPage {
	
	WebDriver driver;

	public AmazonPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="div.a-section.feed-carousel.first-carousel > div > ul")
	WebElement productsUL;
	public WebElement get_productsUL() {
		return productsUL;
	}
}
