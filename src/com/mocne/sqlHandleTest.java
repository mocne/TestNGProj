package com.mocne;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import java.sql.*;

public class sqlHandleTest {
	
	// JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost:3306/pkf_useful";
 
    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "mocne";
    static final String PASS = "111111";
    Connection conn = null;
    Statement stmt = null;
    ResultSet Irs;
    ResultSet Srs;
    
	@BeforeClass
	public void beforeClass() {
	  
      try{
          // 注册 JDBC 驱动
          Class.forName("com.mysql.jdbc.Driver");
      
          // 打开链接
          System.out.println("连接数据库...");
          conn = DriverManager.getConnection(DB_URL,USER,PASS);
          
      }catch(SQLException se){
          // 处理 JDBC 错误
          se.printStackTrace();
      }catch(Exception e){
          // 处理 Class.forName 错误
          e.printStackTrace();
      }finally{
          
      }
      System.out.println("Goodbye!");
  }
	
	@Test(enabled=false, dataProvider="dpInsert")
	public void testInsert(String sqlInsert) throws SQLException {
		//执行数据插入
		System.out.println(" 实例化Statement对...");
		stmt = conn.createStatement();
		ResultSet Irs = stmt.executeQuery(sqlInsert);
		System.out.println(Irs.toString());
		
    }
  
	@Test(enabled=true, dataProvider="dpSelector")
	public void testSelect(String sqlSelect) throws SQLException {
		// 执行查询
	    System.out.println(" 实例化Statement对...");
	    stmt = conn.createStatement();
	    ResultSet Srs = stmt.executeQuery(sqlSelect);
	    
	    // 展开结果集数据库
	    while(Srs.next()){
	        // 通过字段检索
	        int id  = Srs.getInt("id");
	        String name = Srs.getString("name");
	        String address = Srs.getString("address");

	        // 输出数据
	        System.out.print("ID: " + id);
	        System.out.print(", 名称: " + name);
	        System.out.print(", 地址: " + address);
	        System.out.print("\n");
	    }
	}
  
	@BeforeMethod
	public void beforeMethod() {
	}

	@AfterMethod
	public void afterMethod() {
	}


	@DataProvider(name="testInsert")
	public Object[][] dpInsert() {
		return new Object[][] {
		new Object[] { "INSERT INTO test(name, age, sex, phone, address, QQ, wechat) VALUES('test3',11,0,'18244440002','杭州市西湖区华星路96号互联网金融大厦12层','917500002','52113142');" },
//		new Object[] { "b" },
		};
	}
  	
	@DataProvider(name="testSelector")
	public Object[][] dpSelector() {
		return new Object[][] {
			new Object[] { "SELECT * FROM pkf_useful.`test` WHERE id = '1000';" },
			new Object[] { "SELECT * FROM pkf_useful.`test` WHERE id = '1000';" },
			new Object[] { "SELECT * FROM pkf_useful.`test` WHERE id = '1000';" },
			new Object[] { "SELECT * FROM pkf_useful.`test` WHERE id = '1000';" },
			new Object[] { "SELECT * FROM pkf_useful.`test` WHERE id = '1000';" },
			new Object[] { "SELECT * FROM pkf_useful.`test` WHERE id = '1000';" },
			new Object[] { "SELECT * FROM pkf_useful.`test` WHERE id = '1000';" },
			new Object[] { "SELECT * FROM pkf_useful.`test` WHERE id = '1000';" },
			new Object[] { "SELECT * FROM pkf_useful.`test` WHERE id = '1000';" },
			new Object[] { "SELECT * FROM pkf_useful.`test` WHERE id = '1000';" },
			new Object[] { "SELECT * FROM pkf_useful.`test` WHERE id = '1000';" },
			new Object[] { "SELECT * FROM pkf_useful.`test` WHERE id = '1000';" },
			new Object[] { "SELECT * FROM pkf_useful.`test` WHERE id = '1000';" },
			new Object[] { "SELECT * FROM pkf_useful.`test` WHERE id = '1000';" },
			new Object[] { "SELECT * FROM pkf_useful.`test` WHERE id = '1000';" },
			new Object[] { "SELECT * FROM pkf_useful.`test` WHERE id = '1000';" },
			new Object[] { "SELECT * FROM pkf_useful.`test` WHERE id = '1000';" },
			new Object[] { "SELECT * FROM pkf_useful.`test` WHERE id = '1000';" },
			new Object[] { "SELECT * FROM pkf_useful.`test` WHERE id = '1000';" },
			new Object[] { "SELECT * FROM pkf_useful.`test` WHERE id = '1000';" },
			new Object[] { "SELECT * FROM pkf_useful.`test` WHERE id = '1000';" },
			new Object[] { "SELECT * FROM pkf_useful.`test` WHERE id = '1000';" },
		};
	}

	@AfterClass
	public void afterClass() throws SQLException {
		// 完成后关闭
//		Irs.close();
//	    Srs.close();
		
	}

	@BeforeTest
	public void beforeTest() {	
	}

	@AfterTest
	public void afterTest() throws SQLException {
		stmt.close();
		conn.close();
		// 关闭资源
		try{
			if(stmt!=null) stmt.close();
		}catch(SQLException se2){
		}// 什么都不做
		try{
			if(conn!=null) conn.close();
		}catch(SQLException se){
			se.printStackTrace();
		}
	}

	@BeforeSuite
	public void beforeSuite() {
	}

	@AfterSuite
	public void afterSuite() {
	}

}
