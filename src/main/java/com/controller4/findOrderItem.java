package com.controller4;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.UserOrder;
import com.exception.OrderException;
import com.service.OrderService;
import com.service.impl.OrderServiceImpl;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * Servlet implementation class findOrderItem
 */
@WebServlet("/findorderitem")
public class findOrderItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public findOrderItem() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		WebApplicationContext context= WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		OrderServiceImpl orderService=context.getBean(OrderServiceImpl.class);
		try {
			List<UserOrder> userOrder = orderService.findUserOrderDetailByOrderNo();
			request.setAttribute("pageModel", userOrder);		 
			 request.getRequestDispatcher("orderitem.jsp").forward(request, response);
		} catch (OrderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
