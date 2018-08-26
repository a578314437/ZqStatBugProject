package cn.lixing.stat.db.uilts;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static cn.lixing.stat.db.uilts.ConnectDataBase.*;
import static cn.lixing.stat.File.uilts.PropertiesFileUilt.*;

public class SelectResultDataUilts {
	private static String dbType;
	private static String sep;
	private static String sql=null;
	private static Connection connection;
	private static List<Object>resultData;
	private static Map<Object, List<List<Object>>>resultMap;
	private static List<List<Object>>listArr;
	private static int colNum=5;
	
	/**
	 * ²éÑ¯Êý¾Ý
	 * @param TableName
	 * @return
	 */
	public static Map<Object, List<List<Object>>> select(String TableName,String conditionCol,Object condition) {
		sep = System.getProperty("file.separator");
		dbType=getData("dbType", sep+"configFile"+sep+"db");
		resultData=new ArrayList<>();
		resultMap=new HashMap<>();
		PreparedStatement pmt = null;
		ResultSet result;
		
		connection=getConnect(dbType);
		sql="select * from "+TableName+" WHERE "+conditionCol+"=?";
		try {
			pmt=connection.prepareStatement(sql);
			pmt.setObject(1, condition);
			System.out.println(sql);
			result=pmt.executeQuery();
			while(result.next()) {
				resultData.add(result.getObject("bugTitle"));
				resultData.add(result.getObject("designate"));
				resultData.add(result.getObject("designateTime"));
				resultData.add(result.getObject("slevel"));
				resultData.add(result.getObject("priority"));
				
			}
			listArr = new ArrayList<>();      
	        int arrSize = resultData.size()%colNum==0?resultData.size()/colNum:resultData.size()/colNum+1;      
	        for(int i=0;i<arrSize;i++) {      
	        	List<Object>rowListData=new ArrayList<>();      
	            for(int j=i*colNum;j<=colNum*(i+1)-1;j++) {      
	                if(j<=resultData.size()-1) {      
	                	rowListData.add(resultData.get(j));      
	                }      
	            }      
	            listArr.add(rowListData);
	        }
	        resultMap.put(condition, listArr);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for(Object obj:resultMap.keySet()) {
			System.out.println(obj+":"+resultMap.get(obj));
		}
		return resultMap;
	}
	
	

	public static void main(String[] args) {
		select("zq_bug_info","module",0);
	}
}
