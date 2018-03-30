package com.controller3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.PageModel;
import com.entity.vo.OrderVO;
import com.exception.OrderException;
import com.google.gson.Gson;
import com.service.OrderService;
import com.service.impl.OrderServiceImpl;

/**
 * Servlet implementation class GsonServlet
 */
@WebServlet("/gson")
public class GsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GsonServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw=response.getWriter();
		OrderService orderService=new OrderServiceImpl();
		try {
			PageModel<OrderVO> orderVO=orderService.findUserOrderByPage(1, 1, 4);
			Gson gson=new Gson();
			String result=gson.toJson(orderVO);
			
			pw.write("data("+result+")");
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
