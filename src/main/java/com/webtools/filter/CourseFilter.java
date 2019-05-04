package com.webtools.filter;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class CourseFilter
 */
public class CourseFilter implements Filter {

    /**
     * Default constructor. 
     */
    public CourseFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
        if (httpRequest.getMethod().equalsIgnoreCase("POST")) {

            String firstname = request.getParameter("firstname");
            String lastname = request.getParameter("lastname");
            String username = request.getParameter("username");

            Pattern r1 = Pattern.compile("\\s");
            Pattern r2 = Pattern.compile("[\'\"]");
            Pattern r3 = Pattern.compile("(and|or|null|not|union|select|from|where|group|order|having|limit|into|file|case)");
            Pattern r4 = Pattern.compile("(--|#|\\/\\*)");

            if (r1.matcher(firstname).find() || r2.matcher(firstname).find()
                    || r3.matcher(firstname).find() || r4.matcher(firstname).find()) {
            	 HttpServletResponse resp = (HttpServletResponse) response;

                 resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid movie title provided");

            }
        }

		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
