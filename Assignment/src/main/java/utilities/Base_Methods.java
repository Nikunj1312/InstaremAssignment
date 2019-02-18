package utilities;

import org.testng.Assert;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base_Methods {
	
	public static WebDriver driver;
	public static FileInputStream propsFile;
	public static Properties p;
	
	public static void LoadPropertyFile(String Filename) {
		p = new Properties();
		try {
			propsFile = new FileInputStream("src\\main\\java\\config\\"+Filename);
			p.load(propsFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//This method Initiates the browser maximizes it navigates to the given URL and Verifies the Page title
	public static void OpenBrowser(String browserName, String url, String ExpectedPageTitle) throws Exception {
		
			switch(browserName) {
			case "Chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
			
			//can add other browsers in different cases.
			
			default:
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}
			
			driver.manage().window().maximize();
			driver.get(url);
			
			VerifyPageTitle(ExpectedPageTitle);
	}
	
	public static void VerifyPageTitle(String expectedTitle) {
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	}

	public static void tearDown() {
		driver.close();
	}
	
}
