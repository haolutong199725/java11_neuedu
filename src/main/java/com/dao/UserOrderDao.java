package com.dao;

import java.util.List;

import com.entity.PageModel;
import com.entity.UserOrder;
import com.exception.OrderException;



/**
 * @author 24275
 *
 */
public interface UserOrderDao {

	int addOrder(UserOrder userOrder)throws OrderException;
	/*
	 *����list 
	 * */
     PageModel<UserOrder> findUserOrderByPage(Integer userid, Integer pageNo, Integer pageSize)throws OrderException;
     
     /**
      * �������Ų�ѯ
      * */
     List<UserOrder> findUserOrderDetailByOrderNo()throws OrderException;
     /**
      * ��������
      *״̬
      */
     int  updateOrderStatusByOrderNo(Long orderno)throws OrderException;
     
     int updateVO(int orderno, int paymenttype);
     
     List<UserOrder>  findUserOrderLike(String string);
}
