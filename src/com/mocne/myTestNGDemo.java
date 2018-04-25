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
	 * ��ʾ�ȴ�����

		WebDriverWait()
		
		������ȷ��Ҫ�ȵ�ĳ��Ԫ�صĳ��ֻ�����ĳ��Ԫ�صĿɵ��������,�Ȳ���,��һֱ��,�����ڹ涨��ʱ��֮�ڶ�û�ҵ�,��ô������Exception
		
		1��ÿ500����ɨ������Ƿ����Ԫ��
		
		2����Ե�һԪ��
		
		3���������ó�ʱʱ��
		
		WebDriverWait wait=new WebDriverWait(driver, 10);
		
		WebElement wl = wait.until(new ExpectedCondition<WebElement>() {  

            @Override  

            public WebElement apply(WebDriver d) {  

                return d.findElement(By.cssSelector(".red_box"));  

            }  

        });
	 */

}

