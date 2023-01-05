package com.accenture.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class StudentEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int sid;
	
	@Column(name="first_name")
	private String sfn;
	
	@Column(name="last_name")
	private String sln;
	
	@Column(name="email")
	private String semail;

	public StudentEntity(String sfn, String sln, String semail) {
		this.sfn = sfn;
		this.sln = sln;
		this.semail = semail;
	}

	// Default Constructor Required for SQL Query returns
	public StudentEntity() {
	}

	public int getSid() {
		return sid;
	}

	public String getSfn() {
		return sfn;
	}

	public void setSfn(String sfn) {
		this.sfn = sfn;
	}

	public String getSln() {
		return sln;
	}

	public void setSln(String sln) {
		this.sln = sln;
	}

	public String getSemail() {
		return semail;
	}

	public void setSemail(String semail) {
		this.semail = semail;
	}



	@Override
	public String toString() {
		return "StudentEntity [sid=" + sid + ", sfn=" + sfn + ", sln=" + sln + ", semail=" + semail + "]";
	}
	
	
}
