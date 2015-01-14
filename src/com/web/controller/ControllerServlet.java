package com.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControllerServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		/*PrintWriter out=resp.getWriter();
		out.println("<html>");
		out.println("	<head>");
		out.println("		<title>lllllllllllllllllllll</title>");
		out.println("		<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">");
		out.println("		<meta name=\"description\" content=\"���ڵ��������Ż�\">");
		out.println("		<link href=\"./css/tarena.css\" rel=stylesheet>");
		out.println("	</head>");
		out.println("</html>");
		out.close();*/
		resp.setCharacterEncoding("utf-8");
		String path = req.getServletPath();//��req��������洫������req����˿��Ի������������ĸ�servlet,shoppingCartSErvlet��ͨ��*��servlet��ת��controllerservlet��path��shoppingCart����ʱ�ݽ��Ľ���
		path = path.substring(0,path.indexOf("."));
		if(path.equals("/actionorderConfirmServlet"))//shoppingCartServlet����ݽ���controller������
		{
			System.out.println("************ SuccessFul ****************");
			getServletContext().getRequestDispatcher("/orderConfirmServlet").forward(req, resp);
		}
		else if(path.equals("/actionproductListServlet"))
		{
			System.out.println("************ SuccessFul ****************");
			getServletContext().getRequestDispatcher("/productListServlet").forward(req, resp);
		}
		else if(path.equals("/actioncancel"))
		{
			System.out.println("************ SuccessFul Cancel****************");
		}
		else if(path.equals("/actionsave"))
		{
			System.out.println("************ SuccessFul Save****************");
		}
		
		//super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//super.doPost(req, resp);
	}
	

}
