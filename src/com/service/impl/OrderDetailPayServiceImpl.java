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
			 System.out.println("�������سɹ�");
		 }catch(Exception ex){
			 System.out.println("��������ʧ��");
		 }
		 try{
			 conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/gwap","root","");
			 System.out.println("���ݿ����ӳɹ�");
		 }catch(Exception ex)
		 {
			 System.out.println("���ݿ�����ʧ��");
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
			 System.out.println("���ݿ�ر�ʧ��");
		 }
		 
		 
		return orderdetailpay;
	}
}
