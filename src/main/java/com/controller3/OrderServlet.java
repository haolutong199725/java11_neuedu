package com.controller3;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.User;
import com.exception.OrderException;
import com.service.OrderService;
import com.service.impl.OrderServiceImpl;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/orderservlet")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		Object o=session.getAttribute("userid");
		Integer a=null;
		if(o!=null && o instanceof Integer) {
			a=(Integer)o;
		}
		if(a!=null) {
			WebApplicationContext context= WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
			OrderServiceImpl orderService=context.getBean(OrderServiceImpl.class);
        try {
			orderService.createOrder(a, request);
		} catch (OrderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}else {
		response.sendRedirect("http://localhost:8080/SpringWeb/login.jsp");
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
