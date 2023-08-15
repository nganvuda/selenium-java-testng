package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_06_Web_Element {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	
	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Mac OS")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver");
			} else {
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
			}
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Test
	public void TC_01_Element() {
		WebElement element = driver.findElement(By.className(""));
		
		//Dung cho textbox/ text area/ dropdown (Editable)
		//Clear date before entering 
		element.clear();
		
		//Dung cho textbox/ text area/ dropdown (Editable)
		//Nhap lieu
		element.sendKeys();
		
		//Click
		element.click();
		
		String searchAttribute = element.getAttribute("placeholder");
		String emailTextboxAttribute = element.getAttribute("value");
		//results in: Search store
		
		//GUI: font/size/colour/Location/ Position...
		element.getCssValue("background-color");
		//#25c8e0
		
		//Get vi tri cua element so voi web (outside)
		element.getLocation();
		
		//Get size cua element (inside)
		element.getSize();
		
		//Get Location + size
		element.getRect();
		
		//Screenshot evidence when test case failed
		element.getScreenshotAs(OutputType.FILE);
		element.getScreenshotAs(OutputType.BYTES);
		element.getScreenshotAs(OutputType.BASE64);
		
		//Lay ten the cua 1 element, truyen cho 1 locator khac
		driver.findElement(By.id("Email")).getTagName();
		driver.findElement(By.name("Email")).getTagName();
		
		String emailTextboxTagName = driver.findElement(By.cssSelector("#Email")).getTagName();
		driver.findElement(By.xpath("//" + emailTextboxTagName + "[@id=Email]"));
		
		//Lat text tu error msg/success msg/labeel/header...
		element.getText();
		
		//getText or getAttritube?
		//Khi value nam ngoai -> GetText
		//Khi value nam trong -> GetAttribute.
		
		//Verify an element displayed ornot
		//Pham vi: all elements.
		Assert.assertTrue(element.isDisplayed());
		Assert.assertFalse(element.isDisplayed());
		
		
		//Verify element co thao tac duoc hay ko
		//Pham vi: all elements
		Assert.assertTrue(element.isEnabled());
		Assert.assertFalse(element.isEnabled());
		
		//Verify element duoc chon hay chua
		//Pham vi: checkbox/ radio
		Assert.assertTrue(element.isSelected());
		Assert.assertFalse(element.isSelected());
		
		//Cacs element trong the form
		//tuong ung voi Enter
		element.submit();		


	}

	
	
	@AfterClass
	public void afterClass() {
		driver.quit();
}
	
	
}
