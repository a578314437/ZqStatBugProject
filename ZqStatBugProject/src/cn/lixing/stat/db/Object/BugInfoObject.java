package cn.lixing.stat.db.Object;

public class BugInfoObject {
	private int id;
	private String module;
	private String bugtitle;
	private String slevel;
	private String priority;
	private String bugstatus;
	private String activatecount;
	private String creator;
	private String creatortime;
	private String designate;
	private String designatetime;
	private String solver;
	private String solution;
	private String closetime;
	private String solvertime;
	
	public BugInfoObject() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public String getBugtitle() {
		return bugtitle;
	}

	public void setBugtitle(String bugtitle) {
		this.bugtitle = bugtitle;
	}

	public String getSlevel() {
		return slevel;
	}

	public void setSlevel(String slevel) {
		this.slevel = slevel;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getBugstatus() {
		return bugstatus;
	}

	public void setBugstatus(String bugstatus) {
		this.bugstatus = bugstatus;
	}

	public String getActivatecount() {
		return activatecount;
	}

	public void setActivatecount(String activatecount) {
		this.activatecount = activatecount;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getCreatortime() {
		return creatortime;
	}

	public void setCreatortime(String creatortime) {
		this.creatortime = creatortime;
	}

	public String getDesignate() {
		return designate;
	}

	public void setDesignate(String designate) {
		this.designate = designate;
	}

	public String getDesignatetime() {
		return designatetime;
	}

	public void setDesignatetime(String designatetime) {
		this.designatetime = designatetime;
	}

	public String getSolver() {
		return solver;
	}

	public void setSolver(String solver) {
		this.solver = solver;
	}

	public String getSolution() {
		return solution;
	}

	public void setSolution(String solution) {
		this.solution = solution;
	}

	public String getClosetime() {
		return closetime;
	}

	public void setClosetime(String closetime) {
		this.closetime = closetime;
	}

	public String getSolvertime() {
		return solvertime;
	}

	public void setSolvertime(String solvertime) {
		this.solvertime = solvertime;
	}
	
	
}
