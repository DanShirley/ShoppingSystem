package com.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pojo.*;

public class OrderDetailQingdanServiceImpl {
	public List getOrderDetailQingdanList(int orderid) throws SQLException
	{
		String sqlqingdan="select name,basePrice,amount from product,orderline where product.productid=orderline.productid and orderid="+orderid;
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		List orderdetailqingdan=new ArrayList();
		double price;
		double amount;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("驱动加载成功");
		}catch(Exception ex)
		{
			System.out.println("驱动加载失败");
		}
		try{
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/gwap","root","");
			System.out.println("数据库连接成功");
		}catch(Exception ex)
		{
			System.out.println("数据库连接失败");
		}
		stmt=conn.createStatement();
		rs=stmt.executeQuery(sqlqingdan);
		while(rs.next())
		{
			orderdetailqingdan odqd=new orderdetailqingdan();
			odqd.setName(rs.getString("name"));
			System.out.println(rs.getString("name"));
			odqd.setBasePrice(rs.getString("basePrice"));
			System.out.println(rs.getString("basePrice"));
			odqd.setAmount(rs.getString("amount"));
			System.out.println(rs.getString("amount"));
			price=Double.valueOf(rs.getString("basePrice"));
			amount=Double.valueOf(rs.getString("amount"));
			odqd.setAllPrice(price*amount);
			System.out.println(price*amount);
			orderdetailqingdan.add(odqd);
		}
		try{
			rs.close();
			stmt.close();
			conn.close();
		}catch(Exception ex)
		{
			System.out.println("关闭出错");
		}
		return orderdetailqingdan;
	}
		
	
	}