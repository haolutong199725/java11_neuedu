package com.controller6;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Cart;
import com.google.gson.Gson;
import com.service.CartService;
import com.service.impl.CartServiceImpl;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * Servlet implementation class checkall
 */
@WebServlet("/checkall")
public class checkall extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public checkall() {
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
		//String userid=request.getParameter("userid");
		String productid=request.getParameter("productid");
		String callback=request.getParameter("callback");
		WebApplicationContext context= WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		CartServiceImpl cartService=context.getBean(CartServiceImpl.class);
		int a =cartService.updateChecked(1, Integer.parseInt(productid), 1);
		
		//List<Cart> cart=cartService.findCartByUserId(2);
		String cart="success";
		PrintWriter pw=response.getWriter();
		Gson gson=new Gson();
		String result=gson.toJson(cart);
		
		pw.write("data("+result+")");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
