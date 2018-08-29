package cn.lixing.stat.File.uilts;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import static cn.lixing.stat.File.uilts.CloseUilt.*;
import static cn.lixing.stat.File.uilts.PropertiesFileUilt.*;

public class ReadFileUilts {
	private static String ReadfilePath;
	private static String WritefilePath;
	private static BufferedReader reader;
	private static BufferedWriter writer;
	private static String tmp;
	private static Map<String, String>fileDataMap;
	private final static String sep=System.getProperty("file.separator");
	
	public static Map<String, String>getFileDataMap(){
		fileDataMap=new HashMap<>();
		fileDataMap.put("1", ".*[\\u4e00-\\u9fa5]\\(#\\d8\\)");
		fileDataMap.put("3", ".*[\\u4e00-\\u9fa5]\\(#\\d9\\)");
		fileDataMap.put("5", ".*[\\u4e00-\\u9fa5]\\(#\\d0\\)");
		fileDataMap.put("7", ".*[\\u4e00-\\u9fa5]\\(#\\d2\\)");
		
		fileDataMap.put("2", ".*[\\u4e00-\\u9fa5]\\(#\\d4\\)");
		fileDataMap.put("4", ".*[\\u4e00-\\u9fa5]\\(#\\d5\\)");
		fileDataMap.put("6", ".*[\\u4e00-\\u9fa5]\\(#\\d6\\)");
		fileDataMap.put("8", ".*[\\u4e00-\\u9fa5]\\(#\\d7\\)");
		
		fileDataMap.put("9", "已关闭");
		fileDataMap.put("10", "已解决");
		fileDataMap.put("0", "激活");
		
		return fileDataMap;
	}
	
	public static String replaceFileData() {
		ReadfilePath=getData("ReCsvfile", sep+"ConfigFile"+sep+"db");
		WritefilePath=getData("importCsvfile", sep+"ConfigFile"+sep+"db");
		try {
			reader=new BufferedReader(
					new InputStreamReader(
							new FileInputStream(ReadfilePath), "utf8"));
			writer=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(WritefilePath),"utf8"));
//			int len;
//			
//			while((len=reader.read())!=-1) {
//				tmp=reader.readLine();
//				tmp = tmp.replaceAll("\\d", "lixing");
//				writer.write(tmp+"\r\n");
//			}
			reader.readLine();
			writer.write("module,bugtitle,slevel,priority,bugstatus,activatecount,creator,creatortime,designate,designatetime,solver,solution,solvertime,closetime\r\n");
			while((tmp = reader.readLine()) != null) {
				for(String ObjKey:getFileDataMap().keySet()) {
					tmp = tmp.replaceAll(getFileDataMap().get(ObjKey), ObjKey);
				}
				writer.write(tmp+"\r\n");
			}
			writer.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			closeFile(reader);
			e.printStackTrace();
		}
		closeFile(writer);
		closeFile(reader);
		return tmp;
	}
	

	public static void main(String[] args) {
		replaceFileData();
		
	}
}
