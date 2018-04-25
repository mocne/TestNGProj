package com.mocne;

/**
 * 设置浏览器打开网址为手机模式
 */

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;

public class NewTestH5 {
	
	private WebDriver driver;
	private String baseUrl;

	
	
	@BeforeClass
	public void beforeClass() {
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--start-maximized", "disable-infobars", "--user-agent=iPhone 6");
		driver = new ChromeDriver(chromeOptions);
		baseUrl = "https://wechat.cnaidai.com";
	}
	
	
	@Test
	public void f() throws InterruptedException {
	  driver.get(baseUrl);
	  Thread.sleep(500000);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
