package cn.lixing.stat.db.uilts;

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static cn.lixing.stat.db.uilts.ConnectDataBase.*;
import static cn.lixing.stat.File.uilts.CloseUilt.*;

import static cn.lixing.connection.linux.uilts.LoginLinuxImportData.*;
import static cn.lixing.stat.File.uilts.PropertiesFileUilt.*;

public class ImportData {
	private static Connection connection;
	private static PreparedStatement pmt;
	private static String sql;
//	private static Process process;
//	private static InputStream in;
//	private static BufferedReader read;	
//	
//	private static String rootPath;
	private final static String sep=System.getProperty("file.separator");
	private static String FileName;
	
	private static String hostname;
	private static String username;
	private static String password;
	private static int port;
	
	public static void delete(String dbType) {
		connection=getConnect(dbType);
		sql="delete from zq_bug_info";
		try {
			pmt=connection.prepareStatement(sql);
			pmt.executeUpdate();
		} catch (SQLException e) {
			closePreparedStatement(pmt);
			closeConnection(connection);
			e.printStackTrace();
		}
		closePreparedStatement(pmt);
		closeConnection(connection);
	}
	
	public static void importData(String dbType) {
		FileName=getData("csvfile", sep+"configFile"+sep+"db");
		if(dbType.equals("mysql")) {
			connection=getConnect(dbType);
			sql="LOAD DATA LOCAL INFILE '"+FileName+"' INTO TABLE `zq_bug_info` CHARACTER\r\n" + 
					"SET utf8 FIELDS TERMINATED BY ',' OPTIONALLY ENCLOSED BY '\"' ESCAPED BY '\"' LINES TERMINATED BY '\\n' IGNORE 1 LINES (\r\n" + 
					"	module,\r\n" + 
					"	bugtitle,\r\n" + 
					"	slevel,\r\n" + 
					"	priority,\r\n" + 
					"	bugstatus,\r\n" + 
					"	activatecount,\r\n" + 
					"	creator,\r\n" + 
					"	creatortime,\r\n" + 
					"	designate,\r\n" + 
					"	designatetime,\r\n" + 
					"	solver,\r\n" + 
					"	solution,\r\n" + 
					"	solvertime,\r\n" + 
					"	closetime\r\n" + 
					");";
			try {
				pmt=connection.prepareStatement(sql);
				pmt.executeUpdate();
			} catch (SQLException e) {
				closePreparedStatement(pmt);
				closeConnection(connection);
				e.printStackTrace();
			}
		}else if(dbType.equals("oracle")) {
			hostname=getData("hostname", sep+"configFile"+sep+"db");
			username=getData("username", sep+"configFile"+sep+"db");
			password=getData("password", sep+"configFile"+sep+"db");
			port=Integer.parseInt((getData("port", sep+"configFile"+sep+"db")));;
			
			exce(login(hostname, port, username, password),"./import.sh");
//			rootPath=System.getProperty("user.dir");
//			sep = System.getProperty("file.separator");
//			try {
//				 String cmds=rootPath+sep+"testData"+sep+"import.sh";
//		         process = Runtime.getRuntime().exec(cmds);
//		         process.waitFor();
//		         in = process.getInputStream();
//		         read = new BufferedReader(new InputStreamReader(in));
//		         String line = null;
//		         while((line = read.readLine())!=null){
//		             System.out.println(line);
//		         }

//			} catch (IOException e) {
//				e.printStackTrace();
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
			
		}
//		closeFile(in);
		closePreparedStatement(pmt);
		closeConnection(connection);
	}
	public static void main(String[] args) {
		importData("mysql");
//		delete("mysql");
	}
}
