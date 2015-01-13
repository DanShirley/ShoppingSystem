package com.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pojo.*;

public class ProductListServiceImpl {
	
	public List getProductList() {
		List ProductList = new ArrayList();
		
		Connection conn = null;
		
		Statement stmt = null;
		
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gwap","root","");
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery("select productid,name,basePrice from product");
			
			while(rs.next()){
				productlist pro = new productlist();
				
				pro.setProductid(rs.getString("productid"));
				//System.out.println(rs.getString("productid"));
				pro.setName(rs.getString("name"));
				pro.setBasePrice(rs.getString("basePrice"));
				
				ProductList.add(pro);
			}
		} catch (Exception e) {
			e.printStackTrace();
			
			throw new RuntimeException("error when querying product ",e);
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
				
				throw new RuntimeException("error when querying product ",e);
			}
		}
		return ProductList;
	}

}
