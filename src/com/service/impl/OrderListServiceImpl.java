package com.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pojo.*;

public class OrderListServiceImpl {

public List getOrderList(String userid){
		
		List orderlist = new ArrayList();
		
		String userId=userid;
		
		Connection conn = null;
		
		Statement stmt = null;
		
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gwap","root","");
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery("select orders.orderid,orders.cost,orderstatus.name,payway.paystyle from orderstatus,payway,orders where orders.userid='"+userId+"' and orders.statusid=orderstatus.statusid and orders.paywayid=payway.paywayid");
			
			while(rs.next()){
				orderlist orderList = new orderlist();
				
				orderList.setOrderid(rs.getString("orderid"));
				orderList.setCost(rs.getString("cost"));
				orderList.setName(rs.getString("name"));
				orderList.setPaystyle(rs.getString("paystyle"));
				System.out.println(rs.getString("paystyle"));
				orderlist.add(orderList);
			}
		} catch (Exception e) {
			e.printStackTrace();
			
			throw new RuntimeException("error when querying orders ",e);
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
				
				throw new RuntimeException("error when querying orders ",e);
			}
		}
		
		return orderlist;
	}

}
