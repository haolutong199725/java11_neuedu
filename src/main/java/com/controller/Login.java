package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.service.LoginService;
import com.service.impl.LoginServiceImpl;
import com.entity.User;
import com.utils.MD5Utils;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session=request.getSession();
		//HttpSession session= request.getSession();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		LoginService serviceDao=new LoginServiceImpl();
		User user=serviceDao.loginServlet(username, password);
			if(user!=null) {
				
				String token=MD5Utils.GetMD5Code(user.getUsername()+user.getPassword());
				Cookie token_cookie=new Cookie("token",token);
				token_cookie.setMaxAge(7*24*3600);
				token_cookie.setPath("/Shop");
				serviceDao.updateTokenByUserId(user.getUsername(),token);
				response.addCookie(token_cookie);
				/*Cookie username_cookie=new Cookie("username",user.getUsername());
				Cookie password_cookie=new Cookie("password",user.getPassword());
				username_cookie.setMaxAge(7*24*3600);
				password_cookie.setMaxAge(7*24*3600);
				username_cookie.setPath("/Login");
				password_cookie.setPath("/Login");
				response.addCookie(username_cookie);
				response.addCookie(password_cookie);*/
				session.setAttribute("userid", user.getUserid());
				session.setAttribute("username", user.getUsername());
				session.setAttribute("user", user);
				response.sendRedirect("http://localhost:8080/SpringWeb/frame.jsp");
			}else {
				response.sendRedirect("http://localhost:8080/SpringWeb/nmg/fail.jsp");
			}
		}
		
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
