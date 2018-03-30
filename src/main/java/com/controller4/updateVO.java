package com.controller4;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Cart;
import com.entity.PageModel;
import com.entity.vo.OrderVO;
import com.exception.OrderException;
import com.service.CartService;
import com.service.OrderService;
import com.service.impl.CartServiceImpl;
import com.service.impl.OrderServiceImpl;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * Servlet implementation class updateVO
 */
@WebServlet("/updatevo")
public class updateVO extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateVO() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String checked=request.getParameter("checked");
		 String[] str=request.getParameterValues("items");
		WebApplicationContext context= WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		OrderServiceImpl orderService=context.getBean(OrderServiceImpl.class);
		 String orderno=null;
		 if(str!=null) {
		 for(int i=0;i<str.length;i++) {
			 orderno=str[i];
			 orderService.updateVO(Integer.parseInt(orderno),Integer.parseInt(checked));
		 }
		 }
		try {
			PageModel<OrderVO> cart = orderService.findUserOrderByPage(1, 1, 1);
			List <OrderVO> cart1=cart.getData();
			 request.setAttribute("pageModel", cart1);		 
			 request.getRequestDispatcher("findordervo.jsp").forward(request, response);
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
