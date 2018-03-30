package com.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.common.MyBatisUtils;
import com.dao.UseOrderItemDao;
import com.entity.UserOrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("userOrderItem")
public class UserOrderItemImpl implements UseOrderItemDao {
	@Autowired
	SqlSessionFactory sqlSessionFactory;

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public int addBatch(List<UserOrderItem> list) {
		// TODO Auto-generated method stub
		SqlSession session=sqlSessionFactory.openSession(true);
		int row=session.insert("com.entity.UserOrderItem.addBatch",list);
		session.close();
		return row;
	}

	@Override
	public List<UserOrderItem> findOrderItemByOrderNo(Integer orderno) {
		// TODO Auto-generated method stub
		return null;
	}

}
