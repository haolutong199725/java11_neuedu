package com.controller5;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.TypeService_ts;
import com.service.impl.OrderServiceImpl;
import com.service.impl.TypeServiceImpl;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * Servlet implementation class TypeAdd
 */
@WebServlet("/typeadd")
public class TypeAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TypeAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String a=request.getParameter("id");
		String b=request.getParameter("parent_id");
		String c=request.getParameter("type");
		String d=request.getParameter("statu");
		WebApplicationContext context= WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		TypeServiceImpl typeService=context.getBean(TypeServiceImpl.class);
		typeService.insertType(a, b, c, Integer.parseInt(d));
		request.getRequestDispatcher("insertsucc.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
