package cn.lixing.stat.db.uilts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GetFieldCountUilt {
	public static Map<Object, Integer>getFieldCount(List<Object>oldlists){
		Map<Object, Integer>map=new HashMap<>();
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
		getFieldCount(jdbc.getFieldDataMap().get("solver"));
		
	}
}
