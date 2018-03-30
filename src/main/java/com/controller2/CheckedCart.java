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
 * Servlet implementation class CheckedCart
 */
@WebServlet("/checkedcart")
public class CheckedCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckedCart() {
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
		 int userid=0;
		 if(o instanceof Integer) {
			 userid=(Integer)o;
		 }
		 String checked=request.getParameter("checked");
		 String[] str=request.getParameterValues("items");
		WebApplicationContext context= WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		CartServiceImpl cartService=context.getBean(CartServiceImpl.class);
		 String productid=null;
		 if(str!=null) {
		 for(int i=0;i<str.length;i++) {
			 productid=str[i];
			 cartService.updateChecked(userid, Integer.parseInt(productid),Integer.parseInt(checked) );
		 }
		 }
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
