package com.demo_app;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/sq")
public class SqServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
//		int k = Integer.parseInt(req.getParameter("k"));
		
		// accepting session
//		HttpSession session = req.getSession();
//		
//		int k = (int)session.getAttribute("k");
		
		
		// accepting cookie
		int k = 0;
		Cookie cookies[] = req.getCookies();
		for (Cookie cookie : cookies) {
			if(cookie.getName().equals("k")) {
				k = Integer.parseInt(cookie.getValue());
			}
		}
		
		k = k*k;
		
		PrintWriter out = res.getWriter();
		out.println("Result is:" + k);
	}
}
