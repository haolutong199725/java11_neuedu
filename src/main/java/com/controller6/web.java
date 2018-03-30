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
import com.entity.PageModel;
import com.entity.UserOrder;
import com.entity.vo.OrderVO;
import com.exception.OrderException;
import com.google.gson.Gson;
import com.service.CartService;
import com.service.OrderService;
import com.service.impl.CartServiceImpl;
import com.service.impl.OrderServiceImpl;

/**
 * Servlet implementation class web
 */
@WebServlet("/web")
public class web extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public web() {
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
		PrintWriter pw=response.getWriter();
		CartService cart=new CartServiceImpl();
			List<Cart> carts=  cart.findCartByUserId(1);
			Gson gson=new Gson();
			String result=gson.toJson(carts);
			
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
