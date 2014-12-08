package com.web.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ChartDAO {
	
	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	
	public ChartDAO(){
		try {
			Context init=new InitialContext();
			DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/MyDB");
			conn=ds.getConnection();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<ChartBean> ChartShow(String u_id){
		String sql="select * from chart where m_id=?";
				
		ArrayList<ChartBean> list=new ArrayList<ChartBean>();
		
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, u_id);
			System.out.println(u_id);
			rs=ps.executeQuery();
			
			while(rs.next()){
				ChartBean cd=new ChartBean();
							
				cd.setM_id(rs.getString("m_id"));
				cd.setHighclass(rs.getString("highclass"));
				cd.setSmallclass(rs.getString("smallclass"));
				cd.setSmallclassdata(rs.getString("smallclassdata"));
				System.out.println(rs.getString("m_id"));
				System.out.println(rs.getString("highclass"));
				System.out.println(rs.getString("smallclass"));
				System.out.println(rs.getString("smallclassdata"));
				
				list.add(cd);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
