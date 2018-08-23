package cn.lixing.stat.db.uilts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static cn.lixing.stat.File.uilts.PropertiesFileUilt.*;
import static cn.lixing.stat.File.uilts.CloseUilt.*;

public class ConnectDataBase {
	private static Connection connection;
	private static String sep ;
	public static Connection getConnect(String dbType) {
		sep = System.getProperty("file.separator");
		if(dbType.equals("mysql")) {
			try {
				Class.forName(getData("mysqldriverClass", sep+"configFile"+sep+"db"));
				connection=DriverManager.getConnection(
						getData("mysqlurl", sep+"configFile"+sep+"db"), 
						getData("mysqlusername", sep+"configFile"+sep+"db"), 
						getData("mysqlpassword", sep+"configFile"+sep+"db"));
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				closeConnection(connection);
				e.printStackTrace();
			}
			return connection;
		}else if(dbType.equals("oracle")) {
			try {
				Class.forName(getData("oracledevice",sep+"configFile"+sep+"db"));
				connection=DriverManager.getConnection(
						getData("oracleurl",sep+"configFile"+sep+"db"), 
						getData("oracleusername",sep+"configFile"+sep+"db"), 
						getData("oraclepassword",sep+"configFile"+sep+"db")
						);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				try {
					connection.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				e.printStackTrace();
			}
			return connection;
		}else {
			System.out.println("数据库不再范围类型中");
			
		}
		if(connection==null) {
			return null;
		}
		return connection;
	}
	public static void main(String[] args) {
		String sep = System.getProperty("file.separator");
		System.out.println(getData("dbType", sep+"configFile"+sep+"db"));
		System.out.println(getConnect("oracle"));
	}
	
}
