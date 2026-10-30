package com.pack1;

import java.io.IOException;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
//@WebServlet("/dis")
public class DisplayServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException {
		ServletContext context =req.getServletContext();
		context.setAttribute("msg2", "Context data from servlet");
//		req.getRequestDispatcher("Display.jsp").forward(req, res);

		ServletConfig config =this.getServletConfig();
		req.setAttribute("ServletName", config.getServletName());
		req.setAttribute("msg3", config.getInitParameter("msg3"));
		
		req.getRequestDispatcher("Display.jsp").forward(req, res);
		
		
		
		
		
	}

}
