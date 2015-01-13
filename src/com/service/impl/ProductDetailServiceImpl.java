package com.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pojo.*;

public class ProductDetailServiceImpl {
	public List getProductDetail(String productID) throws SQLException {
		List ProductDetail = new ArrayList();
		
		Connection conn = null;
		
		Statement stmt = null;
		
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(Exception ex)
		{
			System.out.println("qudong");
		}
			try{
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gwap","root","");
			}catch(Exception ex)
			{
				System.out.println("lianjie");
			}
			
			stmt = conn.createStatement();
			//and category.categoryid=product.categoryid
			rs = stmt.executeQuery("select author,basePrice,publish,product.categoryid,pages,category.description,product.description,images from product,category where productid="+productID+" and category.categoryid=product.categoryid");
			
			while(rs.next())
			{
				productdetail prod = new productdetail();
				
				prod.setAuthor(rs.getString("author"));
				//System.out.println(rs.getString("author"));
				prod.setBasePrice(rs.getString("basePrice"));
				prod.setPublish(rs.getString("publish"));
				prod.setCategoryid(rs.getString("product.categoryid"));
				prod.setPages(rs.getString("pages"));
				prod.setCdescription(rs.getString("category.description"));
				prod.setPdescription(rs.getString("product.description"));
				prod.setImages(rs.getString("images"));
				
				ProductDetail.add(prod);
			}
		/*} catch (Exception e) {
			e.printStackTrace();
			
			throw new RuntimeException("error when querying product",e);
		} finally {*/
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
				
				throw new RuntimeException("error when querying product",e);
			}
		//}
		return ProductDetail;
	}

}
