package com.controller3;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.PageModel;
import com.entity.UserOrder;
import com.entity.vo.OrderVO;
import com.exception.OrderException;
import com.service.OrderService;
import com.service.impl.CartServiceImpl;
import com.service.impl.OrderServiceImpl;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * Servlet implementation class FindOrderServlet
 */
@WebServlet("/findorderservlet")
public class FindOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		String pageNo=request.getParameter("pageNo");
		Object o=session.getAttribute("userid");
		Integer a=null;
		if(pageNo==null) {
			pageNo="1";
		}
		if(o!=null && o instanceof Integer) {
			a=(Integer)o;
		}
		WebApplicationContext context= WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		OrderServiceImpl orderService=context.getBean(OrderServiceImpl.class);
		try {
			PageModel<OrderVO> pageModel=orderService.findUserOrderByPage(a, Integer.parseInt(pageNo), 4);
			request.setAttribute("pageModel", pageModel);
			request.getRequestDispatcher("order.jsp").forward(request, response);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
