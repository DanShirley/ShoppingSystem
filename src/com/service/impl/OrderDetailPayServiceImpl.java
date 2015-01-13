package com.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pojo.orderdetailpay;

public class OrderDetailPayServiceImpl {
	public List getOrderDetailPayList(int orderid,String username) throws SQLException
	{
		List orderdetailpay=new ArrayList();
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		String sqlpay="select paystyle from payway,orders where orders.paywayid=payway.paywayid and orderid="+orderid+" and userid='"+username+"'";
		 try{
			 Class.forName("com.mysql.jdbc.Driver");
			 System.out.println("驱动加载成功");
		 }catch(Exception ex){
			 System.out.println("驱动家在失败");
		 }
		 try{
			 conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/gwap","root","");
			 System.out.println("数据库连接成功");
		 }catch(Exception ex)
		 {
			 System.out.println("数据库连接失败");
		 }
		 stmt=conn.createStatement();
		 rs=stmt.executeQuery(sqlpay);
		 while(rs.next())
		 {
			 orderdetailpay odp=new orderdetailpay();
			 odp.setPaywaystyle(rs.getString("paystyle"));
			 System.out.println(rs.getString("paystyle"));
			 orderdetailpay.add(odp);
		 }
		 try{
			 rs.close();
			 stmt.close();
			 conn.close();
		 }catch(Exception ex)
		 {
			 System.out.println("数据库关闭失败");
		 }
		 
		 
		return orderdetailpay;
	}
}
