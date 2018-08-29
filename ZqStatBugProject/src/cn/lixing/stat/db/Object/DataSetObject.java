package cn.lixing.stat.db.Object;


import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.data.general.DefaultPieDataset;

import cn.lixing.stat.db.uilts.OperationJdbc;
import static cn.lixing.stat.db.uilts.GetFieldCountUilt.getFieldCount;
import java.util.Map;


public class DataSetObject {
	private DefaultPieDataset pieDataset;
	private OperationJdbc jdbc;
	private Map<Object, Integer> map;
	private String[] colKeys;
	private String[] rowKeys;
	private double[][] data;
	public DataSetObject() {
		jdbc=new OperationJdbc();
	}
	public DefaultPieDataset getPieDataset(String keyValus) {
		pieDataset=new DefaultPieDataset();
		map=getFieldCount(jdbc.getFieldDataMap().get(keyValus));
		
		for(Object objkey:map.keySet()) {
			if(keyValus.equals("module")) {
				if(objkey.equals("1")) {
					pieDataset.setValue("业务管理模块", map.get(objkey));
				}else if(objkey.equals("3")) {
					pieDataset.setValue("码管理模块", map.get(objkey));
				}else if(objkey.equals("5")) {
					pieDataset.setValue("权限管理模块", map.get(objkey));
				}else if(objkey.equals("7")) {
					pieDataset.setValue("web端后台管理系统", map.get(objkey));
				}else if(objkey.equals("2")) {
					pieDataset.setValue("客户经理端", map.get(objkey));
				}else if(objkey.equals("4")) {
					pieDataset.setValue("技术人员端", map.get(objkey));
				}else if(objkey.equals("6")) {
					pieDataset.setValue("关键人端", map.get(objkey));
				}else if(objkey.equals("8")) {
					pieDataset.setValue("装维端", map.get(objkey));
				}
			}else {
				pieDataset.setValue((Comparable<?>) objkey, map.get(objkey));
			}
			
		}
		return pieDataset;
	}
	 public CategoryDataset createDataset(String keyValus) {
		 int i=0;
		 map=getFieldCount(jdbc.getFieldDataMap().get(keyValus));
		 int size=getFieldCount(jdbc.getFieldDataMap().get(keyValus)).keySet().size();
		 rowKeys =new String[]{"bug统计"};
		 colKeys=new String[size];
		 data=new double[1][size];
//		 String[] colKeys = {"0:00", "1:00", "2:00", "7:00", "8:00", "9:00",
//					"10:00", "11:00", "12:00", "13:00", "16:00", "20:00", "21:00",
//					"23:00"};
//
//			double[][] data = {{4, 3, 1, 1, 1, 1, 2, 2, 2, 1, 8, 2, 1, 1},};
		 for(Object objkey:map.keySet()) {
			 colKeys[i]=objkey.toString().substring(1);
			 data[0][i]=map.get(objkey);
			 i++;
			}
//		 for(int j=0;j<colKeys.length;j++) {
//			System.out.println(colKeys[j]);
//			 
//		 }
		 return DatasetUtilities.createCategoryDataset(rowKeys, colKeys, data);
	 }
	
	public static void main(String[] args) {
		DataSetObject setObject=new DataSetObject();
		CategoryDataset dataset=setObject.createDataset("creatortime");
	}
}
