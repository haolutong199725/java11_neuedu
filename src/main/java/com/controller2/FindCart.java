package com.controller2;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.Cart;
import com.service.CartService;
import com.service.impl.CartServiceImpl;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;


/**
 * Servlet implementation class FindCart
 */
@WebServlet("/findcart")
public class FindCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		 Object o=session.getAttribute("userid");
		//String productid=request.getParameter("productid");
		/*if(userid==null) {
			userid="1";
		}*/
		 int userid=0;
		 if(o instanceof Integer) {
			 userid=(int)o;
		 }
		WebApplicationContext context= WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		CartServiceImpl cartService=context.getBean(CartServiceImpl.class);
		 List<Cart> cart=cartService.findCartByUserId(userid);
		 
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
