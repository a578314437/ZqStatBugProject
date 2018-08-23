package cn.lixing.stat.db.Object;

import org.jfree.data.general.DefaultPieDataset;

import cn.lixing.stat.db.uilts.OperationJdbc;
import static cn.lixing.stat.db.uilts.GetFieldCountUilt.getFieldCount;
import java.util.Map;


public class DataSetObject {
	private DefaultPieDataset pieDataset;
	private OperationJdbc jdbc;
	private Map<Object, Integer> map;
	public DataSetObject() {
		jdbc=new OperationJdbc();
	}
	public DefaultPieDataset getPieDataset(String keyValus) {
		pieDataset=new DefaultPieDataset();
		map=getFieldCount(jdbc.getFieldDataMap().get(keyValus));
		if(keyValus==null) {
			
		}
		for(Object objkey:map.keySet()) {
			System.out.println(objkey);
			//System.out.println(objkey+":"+map.get(objkey));
			pieDataset.setValue((Comparable<?>) objkey, map.get(objkey));
		}
		return pieDataset;
	}
	
	public static void main(String[] args) {
		DataSetObject setObject=new DataSetObject();
		DefaultPieDataset dataset=setObject.getPieDataset("module");
		System.out.println(dataset.getValue("app¶Ë(#42)"));
	}
}
