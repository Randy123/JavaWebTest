package com.web.bulletin.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class BulletinDAO {

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs=null;
	
	public BulletinDAO(){
		Context init;
		try {
			init = new InitialContext();
			DataSource ds= (DataSource)init.lookup("java:comp/env/jdbc/MyDB");
			conn=ds.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public boolean bulletinInsert(BulletinBean bulletindata) {
		// TODO Auto-generated method stub
		String query="";
		int num=0;
		int result=0;
		
		query="select max(b_num) from bulletin";
		try {
			ps=conn.prepareStatement(query);
			rs=ps.executeQuery();
			if(rs.next()){
				num=rs.getInt(1) +1;
			}else{
				num =1;
			}
			
			System.out.println(num);
			
			
			query="insert into bulletin(B_NUM,M_ID,SUBJECT,BCONTENTS,BFILE,RE_REF,RE_LEV,READCOUNT,RE_SEQ,CREATED_USER,CREATED_DATE) "
					+ "values(?,?,?,?,?,?,?,?,?,?,sysdate)";
			ps=conn.prepareStatement(query);
			ps.setInt(1, num);
			ps.setString(2, bulletindata.getBid());
			ps.setString(3, bulletindata.getSubject());
			ps.setString(4, bulletindata.getBcontents());
			ps.setString(5, bulletindata.getBfile());
			ps.setInt(6, num);
			ps.setInt(7, 0);
			ps.setInt(8, 0);
			ps.setInt(9, 0);
			ps.setString(10, bulletindata.getBid() );
			
			result=ps.executeUpdate();
			if(result==0){
				return false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
	}
	public ArrayList<BulletinBean> getList(int page, int limit) {
		int start_num= (page-1)*limit +1;
		int end_num = start_num + limit-1;
		
		   String query="select * from "
					+"(select b_num,m_id,subject, "
				    +"bcontents,bfile,re_ref, "
					+"re_lev, re_seq,readcount, "
				    +"created_date, rownum rnum "
					+"from "
				    	+"(select * from bulletin order by b_num desc))"
					+"where rnum>=? and rnum<=?";

		ArrayList<BulletinBean> list = new ArrayList<BulletinBean>();
		try {
			ps=conn.prepareStatement(query);
			ps.setInt(1, start_num);
			ps.setInt(2, end_num);
			rs=ps.executeQuery();
			
			while(rs.next()){
				BulletinBean bean = new BulletinBean();
				
				bean.setNum(rs.getInt(1));
				bean.setBid(rs.getString(2));
				bean.setSubject(rs.getString(3));
				bean.setBcontents(rs.getString(4));
				bean.setBfile(rs.getString(5));
				bean.setRe_ref(rs.getInt(6));
				bean.setRe_lev(rs.getInt(7));
				bean.setRe_seq(rs.getInt(8));
				bean.setReadcount(rs.getInt(9));
				bean.setBdate(rs.getString(10));
				list.add(bean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public int get_list_all_count(){
		String query = "select count(b_num) from bulletin";
		int result =0;
		try {
			ps= conn.prepareStatement(query);
			rs=ps.executeQuery();
			
			if(rs.next())
				result=rs.getInt(1);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return result;
	}

	public BulletinBean bulletinDetail(int b_num) {
		// TODO Auto-generated method stub
		BulletinBean bean = new BulletinBean();
		String sql=
				"select  a.b_num,a.m_id,a.subject,a.bcontents,a.bfile,a.re_ref,a.re_lev,a.re_seq,a.readcount,b.s_date from"
				+ " (select * from bulletin ) a,"
				+ " (select b_num,created_date s_date from bulletin) b"
				+ " where a.b_num=b.b_num and a.b_num=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, b_num);
			rs=ps.executeQuery();
			
			if(rs.next()){
				
				//System.out.println(rs.getDate(10));
				bean.setNum(rs.getInt(1));
				bean.setBid(rs.getString(2));
				bean.setSubject(rs.getString(3));
				bean.setBcontents(rs.getString(4));
				bean.setBfile(rs.getString(5));
				bean.setRe_ref(rs.getInt(6));
				bean.setRe_lev(rs.getInt(7));
				bean.setRe_seq(rs.getInt(8));
				bean.setReadcount(rs.getInt(9));
				bean.setBdate(rs.getString(10));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return bean;
	}

	public ArrayList<CommentBean> comment_list(String b_num) {
		// TODO Auto-generated method stub
		ArrayList<CommentBean> comment_datalist=new ArrayList<CommentBean>();
		String sql="select COM_NUM,COM_ID,COM_CONTENT,B_NUM,"
				+ "COM_DATE , COM_IP "
				+ "from comments where B_NUM=? "
				+ "order by COM_DATE desc";
		
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(b_num));
			rs=ps.executeQuery();
			
			while(rs.next()){
				CommentBean data=new CommentBean();
				
				data.setcomment_num(rs.getInt(1));
				data.setcomment_ID(rs.getString(2));
				data.setcomment_contents(rs.getString(3));
				data.setb_num(rs.getInt(4));
				data.setcomment_date(rs.getString(5));
				data.setcomment_IP(rs.getString(6));
				comment_datalist.add(data);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return comment_datalist;
	}

	public ArrayList<CommentBean> comment_process(CommentBean bean) {
		// TODO Auto-generated method stub
		String sql="";
		int num=0;
		ArrayList<CommentBean> comment_list=new ArrayList<CommentBean>();
		
		try {
			sql="select max(com_num) from comments";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			if(rs.next()){
				num=rs.getInt(1) + 1;
			}else{
				num=1;
			}
						
			sql="insert into comments values(?,?,?,?,sysdate,?)";
			
			ps=conn.prepareStatement(sql);
			ps.setInt(1, num);
			ps.setString(2, bean.getcomment_ID());
			ps.setString(3, bean.getcomment_contents());
			ps.setInt(4, bean.getb_num());
			ps.setString(5, bean.getcomment_IP());
			ps.executeUpdate();
			
			sql="select COM_NUM,COM_ID,COM_CONTENT,B_NUM,"
					+ "COM_DATE, COM_IP "
					+ "from comments where B_NUM=? "
					+ "order by COM_DATE desc";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, bean.getb_num());
			rs=ps.executeQuery();
			
			while(rs.next()){
				CommentBean data=new CommentBean();
				data.setcomment_num(rs.getInt(1));
				data.setcomment_ID(rs.getString(2));
				data.setcomment_contents(rs.getString(3));
				data.setb_num(rs.getInt(4));
				data.setcomment_date(rs.getString(5));
				data.setcomment_IP(rs.getString(6));
				
				comment_list.add(data);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return comment_list;
	}

}
