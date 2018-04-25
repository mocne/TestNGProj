package com.mocne;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

@Test
public class testJre {
	
	@SuppressWarnings("rawtypes")
	private AppiumDriver  driver;
	
    public void f() throws InterruptedException {
    	Thread.sleep(5000);
    	/**
    	 * 1080 * 1920
    	 */
    	int sWidth = driver.manage().window().getSize().width;
    	int sHight = driver.manage().window().getSize().height;
    	//获取1
        driver.tap(1, 485 / 1080 * sWidth, 510 / 1920 * sHight, 100);
        driver.tap(1, 500, 300, 100);
        Thread.sleep(5000);
        WebElement elemElement = driver.findElement(By.id("awardStylebox1"));
        System.out.println(elemElement.getText());
        Thread.sleep(500000);
        //获取+
        driver.findElementById("").click();
        //获取2
        driver.findElementById("").click();
        //获取=
        driver.findElementById("").click();
    }
    
    
    @SuppressWarnings("rawtypes")
	@BeforeClass
    public void beforeClass() throws MalformedURLException {
    	DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(CapabilityType.BROWSER_NAME, ""); 
        cap.setCapability("platformName", "Android"); //指定测试平台
        cap.setCapability("deviceName", "9fd407a3"); //指定测试机的ID,通过adb命令`adb devices`获取
        cap.setCapability("platformVersion", "6.0.1"); 

        //将上面获取到的包名和Activity名设置为值
        cap.setCapability("appPackage", "com.rd.zdbao.adw");
        cap.setCapability("appActivity", "com.aidai.adw.activity.StartPageActivity");

        //A new session could not be created的解决方法
        cap.setCapability("appWaitActivity","com.aidai.adw.activity.StartPageActivity");
        //每次启动时覆盖session，否则第二次后运行会报错不能新建session
        cap.setCapability("sessionOverride", true);
        cap.setCapability("noReset", true);

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);

    }

    @AfterClass
    public void afterClass() {
    	driver.quit();
    }

}
