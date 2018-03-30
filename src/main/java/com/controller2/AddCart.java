package com.controller2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.CartService;
import com.service.impl.AddressServiceImpl;
import com.service.impl.CartServiceImpl;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * Servlet implementation class AddCart
 */
@WebServlet("/addcart")
public class AddCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCart() {
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
		String quantity=request.getParameter("quantity");
		WebApplicationContext context= WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		CartServiceImpl cartService=context.getBean(CartServiceImpl.class);
		int a =cartService.AddOrUpdateCart(Integer.parseInt(userid), Integer.parseInt(productid), Integer.parseInt(quantity));
		
		request.setAttribute("userid", userid);
		request.setAttribute("productid", productid);
		request.getRequestDispatcher("cart.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
