package com.mocne;
/**
 * 老平台后台审核精确定位，通过标的名称精切定位到审核按钮
 */
import org.testng.annotations.*;
import com.google.common.base.Function;
import static org.testng.Assert.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import com.googlecode.jsonplugin.JSONException;
import com.googlecode.jsonplugin.JSONUtil;

public class test2audit {
	private WebDriver driver;
	private String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();

	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--start-maximized", "disable-infobars");
		driver = new ChromeDriver(chromeOptions);
		baseUrl = "http://192.168.18.226:8006/admin-web/admin/common/main.cgi";
	}
	 
	@Test(enabled=true, priority=1)
	public void testLogIn() throws Exception {
		driver.get(baseUrl);
	    Thread.sleep(1000);
	    driver.findElement(By.id("username")).sendKeys("admin");
	    driver.findElement(By.id("password")).sendKeys("admin123!@#");
	    driver.findElement(By.id("login_btn")).click();
	    Thread.sleep(2000);
	    Set<org.openqa.selenium.Cookie> cookies = driver.manage().getCookies();
	    String needCookie = cookies.toString();
	    String bidID = get("http://192.168.18.226:8006/admin-web/admin/borrow/showtrialborrow/search.cgi?page=1&pageSize10", needCookie, "企融贷20180122");
	    String auditUrl = "http://192.168.18.226:8006/admin-web/admin/borrow/detail/viewaudit.cgi?id=" + bidID;
	    driver.get(auditUrl);
	    Thread.sleep(50000);
	}
	
	
	@SuppressWarnings({ "unused", "rawtypes" })
	public static String get(String url, String cookies, String aimBidName) {
		
		BufferedReader in = null;
		try {
			URL realUrl = new URL(url);
			// 打开和URL之间的连接
			URLConnection connection = realUrl.openConnection();
			// 设置通用的请求属性
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("Cookie", cookies);
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			connection.setConnectTimeout(5000);
			connection.setReadTimeout(5000);
			// 建立实际的连接
			connection.connect();
			// 定义 BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuffer sb = new StringBuffer();
			String line;
			while ((line = in.readLine()) != null) {
				sb.append(line);
			}
			String tmp1 = sb.toString();
			try {
		        Object obj = JSONUtil.deserialize(tmp1);
				HashMap objMap = (HashMap)obj;
				Object o = objMap.get("list");
				List bidInfos = (List) o;
				for (Object bidInfos1 : bidInfos) {

					HashMap bidInfo = (HashMap) bidInfos1;
					Object ids = bidInfo.get("id");
					Object names = bidInfo.get("name");
					String name = names.toString();
					if (name.equals(aimBidName)){
						return ids.toString();
					}
				}
				HashMap bidInfo = (HashMap) bidInfos.get(0);
				System.out.println(o);			
			} catch (JSONException e) {
				e.printStackTrace();
			}
			String Result = new String(tmp1.getBytes("GBK"), "UTF-8"); 
			return sb.toString();
		} catch (Exception e) {
			System.out.printf("Exception occur when send http get request!", e);
		}
		// 使用finally块来关闭输入流
		finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return null;
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
