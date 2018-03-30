package com.controller;

import java.io.IOException;
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
 * Servlet implementation class UpdateAddress
 */
@WebServlet("/updateaddress")
public class UpdateAddress extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAddress() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        String userid=request.getParameter("userid");
        String receivercity=request.getParameter("receivercity");

		WebApplicationContext context= WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		AddressServiceImpl  addressService=context.getBean(AddressServiceImpl.class);
		try {
			Address address=addressService.selectAddressByUseridAndId(Integer.parseInt(userid),receivercity );
			
			if(address!=null) {//查询到员工
				request.setAttribute("address",address);
				request.getRequestDispatcher("update.jsp").forward(request, response);
			}else {
				
			}
			
		}catch(NumberFormatException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		
		
		Address  address=new Address();
		String userid=request.getParameter("userid");
		
		String receivername= request.getParameter("receivername");
		String receivercity= request.getParameter("receivercity");
		try {
			address.setUserid(Integer.parseInt(userid));
			address.setReceivername(receivername);
			String receiverphone= request.getParameter("receiverphone");
			address.setReceiverphone(receiverphone);
			String receivermobile= request.getParameter("receivermobile");
			address.setReceivermobile(receivermobile);
			String receiverprovince= request.getParameter("receiverprovince");
			address.setReceiverprovince(receiverprovince);
			
			address.setReceivercity(receivercity);
			
		}catch(NumberFormatException e) {
			
			e.printStackTrace();
			return;
		}
		
		
		AddressService  addressService=new AddressServiceImpl();
		int result=addressService.updateUserAddressByUserid(Integer.parseInt(userid), address, receivercity);
		request.getRequestDispatcher("findalladdress").forward(request, response);
		
		
		
		
	
	}

}
