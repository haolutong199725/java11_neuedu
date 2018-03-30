package com.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;


import com.consts.OrderStatusEnum;
import com.dao.CartDao;
import com.dao.ProductDao;
import com.dao.UseOrderItemDao;
import com.dao.UserOrderDao;
import com.dao.impl.CartDaoImpl;
import com.dao.impl.OrderDaoImpl;
import com.dao.impl.ProductDaoImpl;
import com.dao.impl.UserOrderItemImpl;
import com.entity.Cart;
import com.entity.PageModel;
import com.entity.Product;
import com.entity.UserOrder;
import com.entity.UserOrderItem;
import com.entity.vo.OrderVO;
import com.exception.OrderException;
import com.service.OrderService;
import org.apache.logging.log4j.core.config.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userOrderService")
public class OrderServiceImpl implements OrderService {
	@Autowired
	private CartDao cartDao;

	public void setCartDao(CartDao cartDao) {
		this.cartDao = cartDao;
	}
	@Autowired
	private ProductDao productDao;

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
    @Autowired
	private UserOrderDao orderDao;

	public void setUserOrderItemDao(UseOrderItemDao userOrderItemDao) {
		this.userOrderItemDao = userOrderItemDao;
	}
    @Autowired
	private UseOrderItemDao userOrderItemDao;

	public void setOrderDao(UserOrderDao orderDao) {
		this.orderDao = orderDao;
	}

	@Override
	public Order createOrder (Integer userid, HttpServletRequest request) throws OrderException{
		// TODO Auto-generated method stub
		String shippingid=request.getParameter("shippingid");
		if(shippingid==null|| shippingid.equals("") ) {
			throw new OrderException("dddd");
		}
		Integer _shippingid=null;
		try {
			_shippingid=Integer.parseInt(shippingid);
		}catch(NumberFormatException e) {
			e.printStackTrace();
			throw new OrderException("aaaa");
		}
		List<Cart> cart=cartDao.findCartListByUserid(userid);
		List<UserOrderItem> userorderitems=convertCartToUserOrderItems(userid,cart);
		BigDecimal totalPriceDecimal=getTotalPrice(userorderitems);

		UserOrder order=createOrder(userid,_shippingid,totalPriceDecimal);
		if(order!=null) {
			addOrderItemToDate(order,userorderitems);
		}

		   for(UserOrderItem orderItem:userorderitems) {
			   productDao.reduceProductStock(orderItem.getProduct_id(), orderItem.getQuantity());
		   }

		   cartDao.deleteCartByUseridAndChecked(userid);
		return null;
		
		
		
	}

	private List<UserOrderItem> convertCartToUserOrderItems(Integer userid,List<Cart> carts){
		List<UserOrderItem> list=new ArrayList<UserOrderItem>();
		for(Cart cart:carts) {
			UserOrderItem orderItem=new UserOrderItem();
			Product product=productDao.findProductByProductId(cart.getProductid());
		if(product!=null) {
			orderItem.setProduct_id(cart.getProductid());
			orderItem.setProduct_image(product.getProduct_image());
			orderItem.setProduct_name(product.getProduct_name());
		    orderItem.setCurrent_unit_price(product.getProduct_price());
		    
		    orderItem.setQuantity(cart.getQuantity());
		    BigDecimal _totalprice=new BigDecimal("0");
		    _totalprice=orderItem.getCurrent_unit_price().multiply(new BigDecimal(cart.getQuantity()));
		    orderItem.setTotal_price(_totalprice);
		    orderItem.setUser_id(userid);
		    list.add(orderItem);
		}
	}
		return list;
		
	}
	
	

     private UserOrder createOrder(Integer userid,Integer shippingid,BigDecimal payment)throws OrderException {
    	 UserOrder order=new UserOrder();
    	 order.setOrder_no(generateOrderNo());
    	 order.setUser_id(userid);
    	 order.setShipping_id(shippingid);
    	 order.setPayment(payment);
    	 order.setPayment_type(1);
    	 order.setPostage(0);
    	 order.setStatus(OrderStatusEnum.UNPAY.getStatus());

 		int row=orderDao.addOrder(order);
 		if(row>0) {
 			return order;
 		}else {
 			throw new OrderException("aaa");
 		}
     }
     
     
     
     
     
     
     

     
     private long generateOrderNo() {
    	 return System.currentTimeMillis()+(int)Math.random()*100;
     }
     

     private  BigDecimal getTotalPrice(List<UserOrderItem> orderItems) {
    	 BigDecimal bigDecimal=new BigDecimal("0");
    	 
    	 for(UserOrderItem orderItem:orderItems) {
    		 bigDecimal=bigDecimal.add(orderItem.getTotal_price());
    	 }
    	 
    	 return bigDecimal;
     }
     

     private void addOrderItemToDate(UserOrder order,List<UserOrderItem> orderItems)throws OrderException {
    	 for(UserOrderItem orderItem:orderItems) {
    		 orderItem.setOrder_no(order.getOrder_no());

    		 int stock=productDao.searchProductQuantity(orderItem.getProduct_id());
    		 if(stock<orderItem.getQuantity()){
    			 throw new OrderException("fff");
    		 }
    	 }

    	   userOrderItemDao.addBatch(orderItems);
     }
	@Override
	public PageModel<OrderVO> findUserOrderByPage(Integer userid, Integer pageNo, Integer pageSize) throws OrderException {
		// TODO Auto-generated method stub
		PageModel<UserOrder> pageModel= orderDao.findUserOrderByPage(userid, pageNo, pageSize);
		return convertUserOrderToOrderVO(pageModel);
	}
	
	

	private PageModel<OrderVO> convertUserOrderToOrderVO(PageModel<UserOrder> pageModel) {
		PageModel<OrderVO> _pageModel=new PageModel<OrderVO>();
		if(pageModel!=null) {
			List<OrderVO> list=new ArrayList<OrderVO>();
			List<UserOrder> orders=pageModel.getData();
			for(UserOrder order:orders) {
				OrderVO orderVo=new OrderVO();
				orderVo.converUserOrderToOrderVo(order);
				list.add(orderVo);
			}
			_pageModel.setTotalPage(pageModel.getTotalPage());
			_pageModel.setData(list);
		}
		return _pageModel;
	}
	@Override
	public List<UserOrder> findUserOrderDetailByOrderNo() throws OrderException {
		// TODO Auto-generated method stub
		return orderDao.findUserOrderDetailByOrderNo();
	}
	@Override
	public int updateVO(int orderno, int paymenttype) {
		// TODO Auto-generated method stub
		return orderDao.updateVO(orderno, paymenttype);
	}
	@Override
	public List<OrderVO> findUserOrderLike(String string) {
		// TODO Auto-generated method stub
		
		List<OrderVO> list=new ArrayList<OrderVO>();
		List<UserOrder> orders=orderDao.findUserOrderLike(string);
		for(UserOrder order:orders) {
			OrderVO orderVo=new OrderVO();
			orderVo.converUserOrderToOrderVo(order);
			list.add(orderVo);
		}
		return list;
	}
}
