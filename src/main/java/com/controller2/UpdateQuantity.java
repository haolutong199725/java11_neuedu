package com.controller2;

import java.io.IOException;

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
 * Servlet implementation class UpdateQuantity
 */
@WebServlet("/updatequantity")
public class UpdateQuantity extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateQuantity() {
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
		Cart cart =cartService.findCartByUserIdAndProductId(Integer.parseInt(userid), Integer.parseInt(productid));
		 request.setAttribute("cart", cart);		 
		 request.getRequestDispatcher("updatecart.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		
		
		Cart  cart=new Cart();
		String userid=request.getParameter("userid");
		cart.setUserid(Integer.parseInt(userid));
		String productid= request.getParameter("productid");
		cart.setProductid(Integer.parseInt(productid));
		String quantity= request.getParameter("quantity");
		cart.setQuantity(Integer.parseInt(quantity));
		
		CartService  cartService=new CartServiceImpl();
		int result=cartService.updateQuantity(Integer.parseInt(userid),Integer.parseInt(productid) ,Integer.parseInt(quantity) );
		request.getRequestDispatcher("findcart").forward(request, response);
	}

}
