package com.web.bulletin.model;

import java.sql.Date;

public class BulletinBean {
	private int num;
	private String bid;
	private String subject;
	private String bcontents;
	private String bfile;
	private int re_ref;
	private int re_lev;
	private int re_seq;
	private int readcount;
	private String bdate;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getBid() {
		return bid;
	}
	public void setBid(String bid) {
		this.bid = bid;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getBcontents() {
		return bcontents;
	}
	public void setBcontents(String bcontents) {
		this.bcontents = bcontents;
	}
	public String getBfile() {
		return bfile;
	}
	public void setBfile(String bfile) {
		this.bfile = bfile;
	}
	public int getRe_ref() {
		return re_ref;
	}
	public void setRe_ref(int re_ref) {
		this.re_ref = re_ref;
	}
	public int getRe_lev() {
		return re_lev;
	}
	public void setRe_lev(int re_lev) {
		this.re_lev = re_lev;
	}
	public int getRe_seq() {
		return re_seq;
	}
	public void setRe_seq(int re_seq) {
		this.re_seq = re_seq;
	}
	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	public String getBdate() {
		return bdate;
	}
	public void setBdate(String date) {
		this.bdate =  date;
	}

//	"BID" VARCHAR2(30 BYTE), 
//	"SUBJECT" VARCHAR2(50 BYTE), 
//	"BCONTENTS" VARCHAR2(4000 BYTE), 
//	"BFILE" VARCHAR2(100 BYTE), 
//	"RE_REF" NUMBER, 
//	"RE_LEV" NUMBER, 
//	"RE_SEQ" NUMBER, 
//	"READCOUNT" NUMBER, 
//	"BDATE" DATE
	
		
	
	
}
