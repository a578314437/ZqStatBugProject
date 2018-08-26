package cn.lixing.stat.db.uilts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

public class GetFieldCountUilt {
	public static TreeMap<Object, Integer>getFieldCount(List<Object>oldlists){
		TreeMap<Object, Integer>map=new TreeMap <>();
		List<Object>newlists=new ArrayList<>();
		for(Object list:oldlists) {
			newlists.add(list+"");
		}
		Set<Object>objects=new HashSet<>(newlists);
		for(Object obj:objects) {
			map.put(obj, Collections.frequency(newlists, obj));
			
		}
		
//		for(Object objkey:map.keySet()) {
//			System.out.println(objkey.toString()+":"+map.get(objkey.toString()));
//		}
		return map;
	}
	public static void main(String[] args) {
		OperationJdbc jdbc=new OperationJdbc();
		getFieldCount(jdbc.getFieldDataMap().get("creatortime"));
		
	}
}
