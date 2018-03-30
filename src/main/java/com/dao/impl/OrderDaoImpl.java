package com.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.common.MyBatisUtils;
import com.dao.UserOrderDao;
import com.entity.PageModel;
import com.entity.UserOrder;
import com.exception.OrderException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("userOrderDao")
public class OrderDaoImpl implements UserOrderDao {
	@Autowired
	SqlSessionFactory factory;

	public void setFactory(SqlSessionFactory factory) {
		this.factory = factory;
	}

	@Override
	public int addOrder(UserOrder userOrder) throws OrderException {
		// TODO Auto-generated method stub
		SqlSession session=factory.openSession(true);
		int row=session.insert("com.entity.UserOrder.addOrder",userOrder);
		session.close();
		return row;
	}

	@Override
	public PageModel<UserOrder> findUserOrderByPage(Integer userid, Integer pageNo, Integer pageSize)
			throws OrderException {
		// TODO Auto-generated method stub
		SqlSession session=factory.openSession(true);
		
		Integer totalcount=session.selectOne("com.entity.UserOrder.findTotalCount", userid);
		List<UserOrder> list=session.selectList("com.entity.UserOrder.findUserOrderByPage");
		
		PageModel<UserOrder> pageModel=new PageModel<UserOrder>();
		pageModel.setTotalPage((totalcount%pageSize)==0?(totalcount/pageSize):(totalcount/pageSize)+1);
		pageModel.setData(list);
		session.close();
		return pageModel;
	}

	@Override
	public List<UserOrder> findUserOrderDetailByOrderNo() throws OrderException {
		// TODO Auto-generated method stub
		SqlSession session=factory.openSession(true);
		List<UserOrder> userOrder=session.selectList("com.entity.UserOrder.findUserOrderDetailByOrderNo");
		session.close();
		return userOrder;
	}

	@Override
	public int updateOrderStatusByOrderNo(Long orderno ) throws OrderException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateVO(int orderno, int paymenttype) {
		// TODO Auto-generated method stub
		SqlSession session=factory.openSession(true);
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("order_no", orderno);
		map.put("payment_type",paymenttype);
		int userOrder=session.update("com.entity.UserOrder.updateVO", map);
		session.close();
		return userOrder;
	}

	@Override
	public List<UserOrder> findUserOrderLike(String string) {
		// TODO Auto-generated method stub
		SqlSession session=factory.openSession(true);
		String string1="%"+string+"%";
		List<UserOrder> userOrder=session.selectList("com.entity.UserOrder.findUserOrderLike",string1);
		session.close();
		return userOrder;
	}

}
