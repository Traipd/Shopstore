package com.xmx.model.entity;

import java.io.UnsupportedEncodingException;

public class Product {
	
	private String pid;
	private String category;
	private String pname;
	private String pprize;
	private String introduction;
	private String rigdate;
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPprize() {
		return pprize;
	}
	public void setPprize(String pprize) {
		this.pprize = pprize;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getRigdate() {
		return rigdate;
	}
	public void setRigdate(String rigdate) {
		this.rigdate = rigdate;
	}
	public Product(String pid, String category, String pname, String pprize, String introduction, String rigdate) throws UnsupportedEncodingException {
		super();
		/*pid = new String(pid.getBytes("ISO8859_1"), "UTF-8");
		pname = new String(pname.getBytes("ISO8859_1"),"UTF-8");
		pprize = new String(pprize.getBytes("ISO8859_1"), "UTF-8");
		introduction = new String(introduction.getBytes("ISO8859_1"), "UTF-8");
		category = new String(category.getBytes("ISO8859_1"), "UTF-8");
		rigdate = new String(rigdate.getBytes("ISO8859_1"), "UTF-8");*/
		this.pid = pid;
		this.category = category;
		this.pname = pname;
		this.pprize = pprize;
		this.introduction = introduction;
		this.rigdate = rigdate;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", category=" + category + ", pname=" + pname + ", pprize=" + pprize
				+ ", introduction=" + introduction + ", rigdate=" + rigdate + "]";
	}
	
	
}
