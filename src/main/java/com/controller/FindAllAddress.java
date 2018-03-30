package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Address;
import com.entity.PageModel;
import com.service.AddressService;
import com.service.impl.AddressServiceImpl;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * Servlet implementation class FindAllAddress
 */
@WebServlet("/findalladdress")
public class FindAllAddress extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindAllAddress() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pageNo=request.getParameter("page");
		String userid=request.getParameter("userid");
		if(pageNo==null) {
			pageNo="1";
		}
		if(userid==null) {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else {
			WebApplicationContext context= WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
			AddressServiceImpl  addressService=context.getBean(AddressServiceImpl.class);
		 //·ÖÒ³Ä£ÐÍ
		 PageModel<Address> pageModel=addressService.findUserAddress(Integer.parseInt(pageNo), 4,Integer.parseInt(userid));
		 
		
		 request.setAttribute("pageModel", pageModel);		 
		 request.getRequestDispatcher("address.jsp").forward(request, response);
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
