package com.mocne;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class testPC {
	
	private WebDriver driver;
	private String baseUrl;
	
	@BeforeClass
	public void beforeClass() {
		ChromeOptions chromeOptions = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver","/Users/mocne/webDriver/chromedriver");
		chromeOptions.addArguments("--start-maximized", "disable-infobars");
		driver = new ChromeDriver(chromeOptions);
		baseUrl = "http://www.cnaidai.com";
	}
	
	@Test(dataProvider = "dpPC")
	public void login(String username, String password, String valicode, String checkInfo) throws InterruptedException {
		driver.get(baseUrl);
		try{
//			driver.switchTo().activeElement().isDisplayed();
			driver.navigate().refresh();
		} catch (Exception e){
			System.out.println(e.toString());
		} finally {
			driver.findElement(By.name("username")).sendKeys(username);
			driver.findElement(By.name("password")).sendKeys(password);
			driver.findElement(By.name("valicode")).sendKeys();
		}
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("body > header > div > div.logo-container > div > div.loginBox > a:nth-child(3)")).click();
		System.out.println(username + "+" + password + "+" + valicode);
		Thread.sleep(2000);
	}
	
	@BeforeMethod
	public void beforeMethod() {
	}

	@AfterMethod
	public void afterMethod() {
	}
	  
	@DataProvider
	public Object[][] dpPC() {
		return new Object[][] {
			new Object[] { "182671753360", "a1111111", "1111", ""},
			new Object[] { "182671753361", "a1111111", "1111", ""},
			new Object[] { "182671753362", "a1111111", "1111", ""},
			new Object[] { "182671753363", "a1111111", "1111", ""},
			new Object[] { "182671753364", "a1111111", "1111", ""},
			new Object[] { "182671753365", "a1111111", "1111", ""},
	    		new Object[] { "182671753366", "a1111111", "1111", ""},
	    		new Object[] { "182671753367", "a1111111", "1111", ""},
	    };
	}

	  
	@AfterClass
	public void afterClass() {
	}

  @BeforeTest
  public void beforeTest() {
  }
  

  @AfterTest
  public void afterTest() {
  }

  
  @BeforeSuite
  public void beforeSuite() {
  }

  
  @AfterSuite
  public void afterSuite() {
  }

}
