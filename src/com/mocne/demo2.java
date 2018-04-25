package com.mocne;

import org.testng.annotations.*;
import com.google.common.base.Function;
import static org.testng.Assert.*;
import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class demo2 {
  private WebDriver driver;
  private String baseUrl;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
	ChromeOptions chromeOptions = new ChromeOptions();
	chromeOptions.addArguments("--start-maximized", "disable-infobars");
	driver = new ChromeDriver(chromeOptions);
    baseUrl = "http://cnaidai.com/";
    baseUrl = "http://cnaidai.com/";
    
  }

  @Test
  public static void getdatas() throws IOException {
	  Map<String , Object> dataNeeded = com.mocne.getdatas.exportDataFromExcel();
	  System.out.println(dataNeeded);
}
  @Test
  public void testLogIn() throws Exception {
    driver.get(baseUrl + "/");
    Thread.sleep(2000);
    /**
     * document.readyState
     */
    waitForPageLoad(driver);
    driver.findElement(By.linkText("��¼")).click();
    Thread.sleep(1000);
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("18244440002");
    Thread.sleep(1000);
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("a111111");
    Thread.sleep(1000);
    driver.findElement(By.name("valicode")).clear();
    driver.findElement(By.name("valicode")).sendKeys("1111");
    Thread.sleep(1000);
    driver.findElement(By.id("J-loginBtn")).click();
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("a1111111");
    Thread.sleep(1000);
    driver.findElement(By.id("J-loginBtn")).click();
    Thread.sleep(10000);
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }
  
  public static void waitForPageLoad(WebDriver driver){
		Function<WebDriver,Boolean> waitFn = new Function<WebDriver,Boolean>(){
			public Boolean apply(WebDriver driver){
				return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
			}
		};
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(waitFn);
	}
}
