package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwiftCode {
	
	WebDriver driver;

	public SwiftCode(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="table.swift")
	WebElement table;
	public WebElement get_table() {
		return table;
	}
}
