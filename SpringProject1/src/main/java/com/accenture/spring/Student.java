package com.accenture.spring;

public class Student {
	private int sid;
	private String sname;
	private String susername;
	private String spassword;
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSusername() {
		return susername;
	}
	public void setSusername(String susername) {
		this.susername = susername;
	}
	public String getSpassword() {
		return spassword;
	}
	public void setSpassword(String spassword) {
		this.spassword = spassword;
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", susername=" + susername + ", spassword=" + spassword
				+ "]";
	}
	
	
}
