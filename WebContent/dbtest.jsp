<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% Connection conn=null;
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:orcltest";
	
	Boolean connect = false;
	
	try{
		Class.forName(driver);
		conn = DriverManager.getConnection(url,"db_user","12345");
		
		connect = true;
		
		conn.close();
	} catch(Exception e){
		connect = false;
		e.printStackTrace();
	}
%>
<h3>
 

<%if(connect==true){ %>
success to connect
<%} else{ %>
Fail to connect
<%} %>
</h3>
</body>
</html>