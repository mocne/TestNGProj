package com.mocne;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;


public class myTestNGDemo {
	public WebDriver webDriver;
	String baseUrl = "https://www.baidu.com";
	
	@Test
	public void f1() {
		webDriver.get(baseUrl + '/');
		webDriver.findElement(By.id("kw")).sendKeys("pengkaifeng");
		webDriver.findElement(By.id("su")).click();
	}
	
	@Test
	public void f2() {
		webDriver.get(baseUrl + '/');
		webDriver.findElement(By.id("kw")).sendKeys("helili");
		webDriver.findElement(By.id("su")).click();
	}
  
	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chromedriver.bin", "C:\\Users\\aidai_TEC_QA\\AppData\\Local\\Google\\Chrome\\Application\\chrome.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--start-maximized", "disable-infobars");
		webDriver = new ChromeDriver(chromeOptions);

	}

	@AfterMethod
	public void afterMethod() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		webDriver.quit();
	}
	
	/**
	 * 显示等待方法

		WebDriverWait()
		
		就是明确的要等到某个元素的出现或者是某个元素的可点击等条件,等不到,就一直等,除非在规定的时间之内都没找到,那么就跳出Exception
		
		1、每500毫秒扫描界面是否出现元素
		
		2、针对单一元素
		
		3、可以设置超时时间
		
		WebDriverWait wait=new WebDriverWait(driver, 10);
		
		WebElement wl = wait.until(new ExpectedCondition<WebElement>() {  

            @Override  

            public WebElement apply(WebDriver d) {  

                return d.findElement(By.cssSelector(".red_box"));  

            }  

        });
	 */

}

