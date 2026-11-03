package com.pack1;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class DisplayFilter implements Filter {
	
	public FilterConfig fcf =null;
	
	@Override
	public void init(FilterConfig fcf) {
		this.fcf=fcf;
	}
	
 @Override
public void doFilter(ServletRequest req, ServletResponse res, FilterChain fc)
		throws IOException, ServletException {
	 
	 req.setAttribute("Fname", fcf.getFilterName());
	 req.setAttribute("msg1", fcf.getInitParameter("msg1"));
	 req.getRequestDispatcher("Display.jsp").forward(req, res);
	
	 
	 
	 
	
}

}
