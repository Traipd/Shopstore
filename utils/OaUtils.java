package com.xmx.oa.model.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * 实现与数据库建立连接和关闭连接
 */
public class OaUtils {
  static String driver="com.mysql.jdbc.Driver";
  static Connection conn;
  static String url="jdbc:mysql://localhost:3306/oa";
  static String user="root";
  static String password="root";
	public  static Connection getConnection(){
		//1.拷jar包到lib下面
		//2.加载驱动
		try {
			Class.forName(driver);
		//3.建立连接
			conn=DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("驱动加载失败");
		}
		return conn;
		
	}
	public static void close(Connection conn){
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
