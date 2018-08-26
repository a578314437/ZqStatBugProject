package cn.lixing.stat.db.uilts;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.lixing.stat.db.Object.BugInfoObject;

import static cn.lixing.stat.File.uilts.CloseUilt.*;

import static cn.lixing.stat.db.uilts.ConnectDataBase.*;

import static cn.lixing.stat.db.uilts.ImportData.*;
import static cn.lixing.stat.File.uilts.PropertiesFileUilt.*;

public class OperationJdbc {
	private Connection connection;
	private PreparedStatement pmt;
	private ResultSet resultSet;
	private List<BugInfoObject>bugInfoObjects;
	private String dbType;
	private Map<String, List<Object>>FieldDataMap;
	
	private List<Object>idList;
	private List<Object>moduleList;
	private List<Object>bugtitleList;
	private List<Object>slevelList;
	private List<Object>priorityList;
	private List<Object>bugstatusList;
	private List<Object>activatecountList;
	private List<Object>creatorList;
	private List<Object>creatortimeList;
	private List<Object>designateList;
	private List<Object>designatetimeList;
	private List<Object>solverList;
	private List<Object>solutionList;
	private List<Object>closetimeList;
	private List<Object>solvertimeList;
	private String sep;
	private String isImport;
	public OperationJdbc() {
		FieldDataMap=new HashMap<>();
		sep = System.getProperty("file.separator");
		isImport=getData("isImportData", sep+"configFile"+sep+"db");
		dbType=getData("dbType", sep+"configFile"+sep+"db");
		idList=new ArrayList<>();
		moduleList=new ArrayList<>();
		bugtitleList=new ArrayList<>();
		slevelList=new ArrayList<>();
		priorityList=new ArrayList<>();
		bugstatusList=new ArrayList<>();
		activatecountList=new ArrayList<>();
		creatorList=new ArrayList<>();
		creatortimeList=new ArrayList<>();
		designateList=new ArrayList<>();
		designatetimeList=new ArrayList<>();
		solverList=new ArrayList<>();
		solutionList=new ArrayList<>();
		closetimeList=new ArrayList<>();
		solvertimeList=new ArrayList<>();
		idList=new ArrayList<>();
		this.select(isImport);
	}
	
	public void select(String b) {
		if(b.equals("true")) {
			delete(dbType);
			importData(dbType);
		}
		connection=getConnect(dbType);
		bugInfoObjects=new ArrayList<>();
		String sql="select * from zq_bug_info order by creatortime";
		try {
			pmt=connection.prepareStatement(sql);
			resultSet=pmt.executeQuery();
			while(resultSet.next()) {
				BugInfoObject bugInfoObject=new BugInfoObject();
				bugInfoObject.setId(resultSet.getInt("id"));
				bugInfoObject.setModule(resultSet.getString("module"));
				bugInfoObject.setBugtitle(resultSet.getString("bugtitle"));
				bugInfoObject.setSlevel(resultSet.getString("slevel"));
				bugInfoObject.setPriority(resultSet.getString("priority"));
				bugInfoObject.setBugstatus(resultSet.getString("bugstatus"));
				bugInfoObject.setActivatecount(resultSet.getString("activatecount"));
				bugInfoObject.setCreator(resultSet.getString("creator"));
				bugInfoObject.setCreatortime(resultSet.getString("creatortime"));
				bugInfoObject.setDesignate(resultSet.getString("designate"));
				bugInfoObject.setDesignatetime(resultSet.getString("designatetime"));
				bugInfoObject.setSolver(resultSet.getString("solver"));
				bugInfoObject.setSolution(resultSet.getString("solution"));
				bugInfoObject.setClosetime(resultSet.getString("closetime"));
				bugInfoObject.setSolvertime(resultSet.getString("solvertime"));
				bugInfoObjects.add(bugInfoObject);
				
			}
		} catch (SQLException e) {
			closeResultSet(resultSet);
			closePreparedStatement(pmt);
			closeConnection(connection);
			e.printStackTrace();
		}
		closeResultSet(resultSet);
		closePreparedStatement(pmt);
		closeConnection(connection);
		
		for(BugInfoObject obj:bugInfoObjects) {
			idList.add(obj.getId());
			moduleList.add(obj.getModule());
			bugtitleList.add(obj.getBugtitle());
			slevelList.add(obj.getSlevel());
			priorityList.add(obj.getPriority());
			bugstatusList.add(obj.getBugstatus());
			activatecountList.add(obj.getActivatecount());
			creatorList.add(obj.getCreator());
			creatortimeList.add(obj.getCreatortime());
			designateList.add(obj.getDesignate());
			designatetimeList.add(obj.getDesignatetime());
			solverList.add(obj.getSolver());
			solutionList.add(obj.getSolution());
			closetimeList.add(obj.getClosetime());
			solvertimeList.add(obj.getSolvertime());
		
			FieldDataMap.put("id", idList);
			FieldDataMap.put("module", moduleList);
			FieldDataMap.put("bugtitle", bugtitleList);
			FieldDataMap.put("slevel",slevelList );
			FieldDataMap.put("priority", priorityList);
			FieldDataMap.put("bugstatus",bugstatusList );
			FieldDataMap.put("activatecount",activatecountList );
			FieldDataMap.put("creator", creatorList);
			FieldDataMap.put("creatortime", creatortimeList);
			FieldDataMap.put("designate", designateList);
			FieldDataMap.put("designatetime", designatetimeList);
			FieldDataMap.put("solver", solverList);
			FieldDataMap.put("solution",solutionList );
			FieldDataMap.put("closetime", closetimeList);
			FieldDataMap.put("solvertime", solvertimeList);
		}
	}
	
	public String getDbType() {
		return dbType;
	}

	public void setDbType(String dbType) {
		this.dbType = dbType;
	}

	public Map<String, List<Object>> getFieldDataMap() {
		return FieldDataMap;
	}

	public List<Object> getIdList() {
		return idList;
	}

	public void setIdList(List<Object> idList) {
		this.idList = idList;
	}

	public List<Object> getModuleList() {
		return moduleList;
	}

	public void setModuleList(List<Object> moduleList) {
		this.moduleList = moduleList;
	}

	public List<Object> getBugtitleList() {
		return bugtitleList;
	}

	public void setBugtitleList(List<Object> bugtitleList) {
		this.bugtitleList = bugtitleList;
	}

	public List<Object> getSlevelList() {
		return slevelList;
	}

	public void setSlevelList(List<Object> slevelList) {
		this.slevelList = slevelList;
	}

	public List<Object> getPriorityList() {
		return priorityList;
	}

	public void setPriorityList(List<Object> priorityList) {
		this.priorityList = priorityList;
	}

	public List<Object> getBugstatusList() {
		return bugstatusList;
	}

	public void setBugstatusList(List<Object> bugstatusList) {
		this.bugstatusList = bugstatusList;
	}

	public List<Object> getActivatecountList() {
		return activatecountList;
	}

	public void setActivatecountList(List<Object> activatecountList) {
		this.activatecountList = activatecountList;
	}

	public List<Object> getCreatorList() {
		return creatorList;
	}

	public void setCreatorList(List<Object> creatorList) {
		this.creatorList = creatorList;
	}

	public List<Object> getCreatortimeList() {
		return creatortimeList;
	}

	public void setCreatortimeList(List<Object> creatortimeList) {
		this.creatortimeList = creatortimeList;
	}

	public List<Object> getDesignateList() {
		return designateList;
	}

	public void setDesignateList(List<Object> designateList) {
		this.designateList = designateList;
	}

	public List<Object> getDesignatetimeList() {
		return designatetimeList;
	}

	public void setDesignatetimeList(List<Object> designatetimeList) {
		this.designatetimeList = designatetimeList;
	}

	public List<Object> getSolverList() {
		return solverList;
	}

	public void setSolverList(List<Object> solverList) {
		this.solverList = solverList;
	}

	public List<Object> getSolutionList() {
		return solutionList;
	}

	public void setSolutionList(List<Object> solutionList) {
		this.solutionList = solutionList;
	}

	public List<Object> getClosetimeList() {
		return closetimeList;
	}

	public void setClosetimeList(List<Object> closetimeList) {
		this.closetimeList = closetimeList;
	}

	public List<Object> getSolvertimeList() {
		return solvertimeList;
	}

	public void setSolvertimeList(List<Object> solvertimeList) {
		this.solvertimeList = solvertimeList;
	}
	public static void main(String[] args) {
		OperationJdbc jdbc=new OperationJdbc();
		jdbc.select("true");
	}
}
