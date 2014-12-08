package com.web.bulletin.model;

import java.io.Serializable;

public class CommentBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int comment_num;
	String comment_ID;
	String comment_contents;
	int b_num;
	String comment_date;
	String comment_IP;
	
	public int getcomment_num() {
		return comment_num;
	}
	public void setcomment_num(int comment_num) {
		this.comment_num = comment_num;
	}
	public String getcomment_ID() {
		return comment_ID;
	}
	public void setcomment_ID(String comment_ID) {
		this.comment_ID = comment_ID;
	}
	public String getcomment_contents() {
		return comment_contents;
	}
	public void setcomment_contents(String comment_contents) {
		this.comment_contents = comment_contents;
	}
	public int getb_num() {
		return b_num;
	}
	public void setb_num(int b_num) {
		this.b_num = b_num;
	}
	public String getcomment_date() {
		return comment_date;
	}
	public void setcomment_date(String comment_date) {
		this.comment_date = comment_date;
	}
	public String getcomment_IP() {
		return comment_IP;
	}
	public void setcomment_IP(String comment_IP) {
		this.comment_IP = comment_IP;
	}

}
