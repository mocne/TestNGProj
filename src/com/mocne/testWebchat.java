package com.mocne;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class testWebchat {
	
	private WebDriver driver;
	private String baseUrl;
	
	@BeforeSuite
	public void beforeSuite() {
	}

	@BeforeTest
	public void beforeTest() {
	}
	
	@BeforeClass
	public void beforeClass() throws InterruptedException {

//        System.setProperty("webdriver.chrome.driver","/Users/mocne/webDriver/chromedriver");
        final ChromeOptions chromeOptions = new ChromeOptions();
        // 设置user agent的参数为iPhone 6
        chromeOptions.addArguments("--start-maximized", "disable-infobars", "--user-agent=iPhone 6");
        driver = new ChromeDriver(chromeOptions);
		baseUrl = "https://wechat.cnaidai.com/webchat/index.html";
		Actions action=new Actions(driver);
		WebElement element=driver.findElement(By.xpath("/html/body/footer/a[1]"));
		action.sendKeys(element, Keys.CONTROL).keyDown(Keys.SHIFT).sendKeys("i").keyUp(Keys.SHIFT).keyUp(Keys.CONTROL).perform();
//		action.keyDown(Keys.CONTROL).keyDown(Keys.SHIFT).sendKeys("i").keyUp(Keys.SHIFT).keyUp(Keys.CONTROL).perform();
//		Thread.sleep(3000);
//		action.keyDown(Keys.CONTROL).keyDown(Keys.SHIFT).sendKeys("m").keyUp(Keys.SHIFT).keyUp(Keys.CONTROL).perform();
		Thread.sleep(2000);
	}
	
	@BeforeMethod
	public void beforeMethod() {
	}
	
	@Test(dataProvider = "dpPC")
	public void login(String username, String password, String valicode, String checkInfo) throws InterruptedException {
		
		driver.manage().deleteAllCookies();
		driver.get(baseUrl);
		Thread.sleep(2000);
//		Thread.sleep(2000000);
//		driver.findElement(By.xpath("/html/body/footer/a[3]")).click();
//		try{
//			driver.navigate().refresh();
//		} catch (Exception e){
//			System.out.println(e.toString());
//		} finally {
//			driver.findElement(By.name("username")).sendKeys(username);
//			driver.findElement(By.name("password")).sendKeys(password);
//			Thread.sleep(1000);
//			driver.findElement(By.cssSelector("body > div > div:nth-child(2) > div.m-login > a")).click();
//		}
//		Thread.sleep(2000);
		System.out.println(username + "+" + password + "+" + valicode);
	}
	
	@Test(enabled = false, dependsOnMethods = { "login" })
	public void logout() throws InterruptedException {
		System.out.println("");
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/footer/a[4]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/main/div[3]/a[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/a[5]/div/p")).click();
		Thread.sleep(2000);
	}

	@AfterMethod
	public void afterMethod() {
		
	}
	  
	@DataProvider
	public Object[][] dpPC() {
		return new Object[][] {
			new Object[] { "18244440000", "a1111111", "1111", ""},
			new Object[] { "18244440001", "a1111111", "1111", ""},
			new Object[] { "18244440002", "a1111111", "1111", ""},
			new Object[] { "18244440003", "a1111111", "1111", ""},
			new Object[] { "18244440004", "a1111111", "1111", ""},
			new Object[] { "18244440005", "a1111111", "1111", ""},
    		new Object[] { "18244440006", "a1111111", "1111", ""},
    		new Object[] { "18244440007", "a1111111", "1111", ""},
	    };
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	@AfterTest
	public void afterTest() {
	}

	@AfterSuite
	public void afterSuite() {
	}

}
