package com.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.pojo.*;

public class OrderDetailUserServiceImpl {
	
	public List getOrderDetailUserList(String username) throws SQLException
	{
		List userdetail=new ArrayList();
		Connection conn=null;
		ResultSet rs=null;
		Statement stmt=null;
		String sqlforuser="select * from contactinfo where userid="+"'"+username+"'";
		try{
			Class.forName("com.mysql.jdbc.Driver");	
			System.out.println("加载驱动成功");
		}
		catch(Exception ex){
			System.out.println("加载驱动失败");
		}
		try{
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/gwap","root","");
			System.out.println("连接数据库成功");
		}catch(Exception ex){
			System.out.println("连接数据库失败");
		}
		stmt=conn.createStatement();
		rs=stmt.executeQuery(sqlforuser);
		while(rs.next())
		{
			orderdetailuser odu=new orderdetailuser();
			odu.setUserid(rs.getString("userid"));
			System.out.println(rs.getString("userid"));
			odu.setStree1(rs.getString("street1"));
			System.out.println(rs.getString("street1"));
			odu.setStreet2(rs.getString("street2"));
			System.out.println(rs.getString("street2"));
			odu.setCity(rs.getString("city"));
			System.out.println(rs.getString("city"));
			odu.setProvince(rs.getString("province"));
			System.out.println(rs.getString("province"));
			odu.setCountry(rs.getString("country"));
			System.out.println(rs.getString("country"));
			odu.setZip(rs.getString("zip"));
			System.out.println(rs.getString("zip"));
			odu.setEmail(rs.getString("email"));
			System.out.println(rs.getString("email"));
			odu.setHomephone(rs.getString("homephone"));
			System.out.println(rs.getString("homephone"));
			odu.setCellphone(rs.getString("cellphone"));
			System.out.println(rs.getString("cellphone"));
			odu.setOfficephone(rs.getString("officephone"));
			System.out.println(rs.getString("officephone"));
			userdetail.add(odu);
		}
		try{
			rs.close();
			stmt.close();
			conn.close();
		}catch(Exception ex){
			System.out.println("关闭操作失败");
		}
		
		return userdetail;
	}
	

}
