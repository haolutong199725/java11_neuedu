package com.controller2;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Cart;
import com.service.CartService;
import com.service.impl.CartServiceImpl;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * Servlet implementation class DeleteCart
 */
@WebServlet("/deletecart")
public class DeleteCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userid=request.getParameter("userid");
		String productid=request.getParameter("productid");
		WebApplicationContext context= WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		CartServiceImpl cartService=context.getBean(CartServiceImpl.class);
		int a =cartService.deleteCart(Integer.parseInt(userid),Integer.parseInt(productid) );
		
		List<Cart> cart=cartService.findCartByUserId(Integer.parseInt(userid));
		 request.setAttribute("cart", cart);		 
		 request.getRequestDispatcher("checkcart.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
