package com.xmx.oa.model.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * ʵ�������ݿ⽨�����Ӻ͹ر�����
 */
public class OaUtils {
  static String driver="com.mysql.jdbc.Driver";
  static Connection conn;
  static String url="jdbc:mysql://localhost:3306/oa";
  static String user="root";
  static String password="root";
	public  static Connection getConnection(){
		//1.��jar����lib����
		//2.��������
		try {
			Class.forName(driver);
		//3.��������
			conn=DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("��������ʧ��");
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
