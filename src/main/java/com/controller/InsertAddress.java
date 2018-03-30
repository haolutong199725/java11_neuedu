package com.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Address;
import com.service.AddressService;
import com.service.impl.AddressServiceImpl;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * Servlet implementation class InsertAddress
 */
@WebServlet("/insertaddress")
public class InsertAddress extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertAddress() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("insert.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		Address address=new Address();
		String receivername= request.getParameter("receivername");
		String userid=request.getParameter("userid");
		int a=Integer.parseInt(userid);
		try {
			address.setReceivername(receivername);
			String receiverphone= request.getParameter("receiverphone");
			address.setReceiverphone(receiverphone);
			String receivermoile= request.getParameter("receivermobile");
			address.setReceivermobile(receivermoile);
			String receiverprovince= request.getParameter("receiverprovince");
			address.setReceiverprovince(receiverprovince);
			String receivercity= request.getParameter("receivercity");
			address.setReceivercity(receivercity);
			address.setUserid(a);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			doGet(request,response);
			return;
		}

		WebApplicationContext context= WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		AddressServiceImpl  addressService=context.getBean(AddressServiceImpl.class);
		int result=addressService.addAddress(a, address);
		if(result>0) {//添加成功,跳转到列表页面
			request.getRequestDispatcher("findalladdress").forward(request, response);
		}else {//添加失败
			doGet(request,response);
		}
	}

}
