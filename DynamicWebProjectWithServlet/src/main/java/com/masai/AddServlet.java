package com.masai;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddServlet extends HttpServlet {

/*we can also use doGet() or doPost() depending upon our requirement
 * doPost,doGet will work only with form method = post,get respectively
 *  service() works with both as internally it checks 
 *  like if (method.equals(METHOD_GET)), it calls doGet()
 *  and vice versa
 * */
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		int a = Integer.parseInt(req.getParameter("num1") );
		int b = Integer.parseInt(req.getParameter("num2") );
		
		int ans = a+b;
		
//		System.out.println(ans);
//	
//		PrintWriter out = res.getWriter();
//		out.println("sum is "+ans);
		
		/* RequestDispatcher is used to send request to another servlet
		 * using these ways we can share data between 2 servlets
		 * 
		 * 1. setting attribute in request object (calling a servlet
		 * from another servlet)
		 * 2. sendDirect with sending value in uri
		 * 3. Session Management
		 * 4. Cookies*/
		
		//in web.xml mapping we can see cube is mapped to which servlet
		
//  1. setting attribute and then dipatching using Request dispatcher
		
	
		
//		RequestDispatcher reqDis = req.getRequestDispatcher("cube");
//		try {
//		req.setAttribute("num", ans);
//			reqDis.forward(req, res);
//		} catch (ServletException | IOException e) {
//			e.printStackTrace();
//		}
		

		/*2. sendRedirect, In this we have to pass the value with
		 * uri called as uri rewriting
		 * also in the CubeServlet we cannot access from getAttribute
		 * we will have to use getParameter*/
		
		//res.sendRedirect("cube?num="+ans);
		
		/*3. HttpSession -> after taking its instance, use
		 *  setAttribute to add the value in the session*/
		
		
		HttpSession session = req.getSession();
		session.setAttribute("num", ans);
		res.sendRedirect("cube");
	}
}

