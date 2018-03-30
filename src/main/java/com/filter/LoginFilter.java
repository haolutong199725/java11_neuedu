package com.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.service.LoginService;
import com.service.impl.AddressServiceImpl;
import com.service.impl.LoginServiceImpl;
import com.entity.User;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/nmg/*")
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
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
	public void doFilter(ServletRequest _request, ServletResponse _response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest request=(HttpServletRequest)_request;
		HttpServletResponse response=(HttpServletResponse)_response;
		HttpSession session=request.getSession();
		String token=null;
		Cookie[] cookies=request.getCookies();
		if(cookies!=null) {
			for(Cookie c:cookies) {
				if(c.getName().equals("token")) {
					token=c.getValue();
				}
			}
		}
		if(token!=null) {
			WebApplicationContext context= WebApplicationContextUtils.getWebApplicationContext(_request.getServletContext());
			LoginService serviceDao=context.getBean(LoginService.class);
			User user=serviceDao.TokenUser(token);
			if(user!=null) {
				session.setAttribute("user", user);
				chain.doFilter(request, response);
			}else {
				response.sendRedirect("http://localhost:8080/Shop/login.jsp");
			}
		// pass the request along the filter chain
		}else {
			response.sendRedirect("http://localhost:8080/Shop/login.jsp");
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
