package com.web.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.sql.Date;
import java.util.Vector;

import javax.sql.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;
//import javax.naming.NamingException;




public class MemberDAO {

	Connection conn= null;
	PreparedStatement ps = null;
	ResultSet rs= null;
	
	public MemberDAO() {
		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/MyDB");
			System.out.println("test");
			conn= ds.getConnection();
			System.out.println("test2");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//Check Member
	public MemberCheck CheckDuplicationOfMember(String u_id, String u_pw){
		String query = "select * from member where m_id=?";
		MemberCheck mc = new MemberCheck();
		
		try {
			ps=conn.prepareStatement(query);
			ps.setString(1, u_id);
			rs=ps.executeQuery();
			
			if(rs.next()){
				String id=rs.getString("m_id");
				String pw=rs.getString("password");
				if(u_pw.equals(pw)){
					//ID PW í™•ì�¸
					mc.setId_ok(true);
					mc.setPw_ok(true);
					mc.setName(rs.getString("name"));
				}
				mc.setId_ok(true);
			}
			
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mc;
	}
	public void insertMember(MemberDTO to) {
		// TODO Auto-generated method stub
			String query="insert into member(M_ID ,PASSWORD,NAME,BIRTH,PHONE_NUM,ADDRESS,EMAIL,CREATED_USER,CREATED_DATE) "
					+ " values(?,?,?,?,?,?,?,?,SYSDATE)";

			//DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			//Date date = new Date(0);
			//System.out.println(dateFormat.format(date)); //2014/08/06 15:59:48
			
			try {
				ps=conn.prepareStatement(query);
//				

				ps.setString(1, to.getId());
				ps.setString(2, to.getPass());
				ps.setString(3, to.getName());
				ps.setString(4, "88.12.12");
				ps.setString(5, "010-0000-0000");
				ps.setString(6, "SEOUL");
				ps.setString(7, to.getEmail());
				ps.setString(8, to.getId());
				
				int x= ps.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
	public Vector<MemberDTO> selectAllMember() {
		// TODO Auto-generated method stub
		String query="select * from member";
		
		Vector<MemberDTO> memberAll=new Vector<MemberDTO>();
		
			try {
				ps= conn.prepareStatement(query);
				rs=ps.executeQuery();
				while(rs.next()){
					MemberDTO to = new MemberDTO();
					to.setId(rs.getString("m_id"));
					to.setPass(rs.getString("password"));
					to.setName(rs.getString("name"));
					to.setEmail(rs.getString("email"));
					
					memberAll.add(to); 
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		return memberAll;
	}
	public void deleteMember(String del_id) {
		// TODO Auto-generated method stub
		String query="delete from member where m_id=?";
		
		try {
			ps=conn.prepareStatement(query);
			ps.setString(1, del_id);
			int x=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public MemberDTO getModifyMember(String modify_id) {
		// TODO Auto-generated method stub
		String query="select * from member where m_id=?";
		MemberDTO to =new MemberDTO();
		
		try {
			ps=conn.prepareStatement(query);
			ps.setString(1, modify_id);
			rs=ps.executeQuery();
			if(rs.next()){
				to.setId(rs.getString("m_id"));
				to.setPass(rs.getString("pass"));
				to.setName(rs.getString("name"));
				to.setEmail(rs.getString("email"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return to;
	}
	public void modifyProcess(MemberDTO to) {
		// TODO Auto-generated method stub
		String query ="update member set password=?, name=?, email=?, where m_id=?";
		
		try {
			ps.setString(1, to.getPass());
			ps.setString(2, to.getName());
			ps.setString(3, to.getEmail());
			ps.setString(4, to.getId());
			int x = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
}
