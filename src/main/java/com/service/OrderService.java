package com.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.core.config.Order;

import com.entity.PageModel;
import com.entity.UserOrder;
import com.entity.vo.OrderVO;
import com.exception.OrderException;

public interface OrderService {
  Order createOrder(Integer userid, HttpServletRequest request) throws OrderException;
  public PageModel<OrderVO> findUserOrderByPage(Integer userid, Integer pageNo, Integer pageSize)throws OrderException;
  List<UserOrder> findUserOrderDetailByOrderNo()throws OrderException;
  public int updateVO(int orderno, int paymenttype);
  public   List<OrderVO> findUserOrderLike(String string);
}
