package com.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.common.MyBatisUtils;
import com.dao.TypeDao;
import com.entity.Type;
import com.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("typeDao")
public class TypeDaoImpl implements TypeDao {
	@Autowired
	SqlSessionFactory factory;

	public void setFactory(SqlSessionFactory factory) {
		this.factory = factory;
	}

	@Override
	public List<Type> findProductType() {
		// TODO Auto-generated method stub
		SqlSession session=factory.openSession(true);
		List<Type> list=session.selectList("com.entity.Type.findProductType");
		session.close();
		return list;
	}

	@Override
	public int insertType(String id, String parent_id, String type, int statu) {
		// TODO Auto-generated method stub
		SqlSession session=factory.openSession(true);
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("id", id);
		map.put("parent_id", parent_id);
		map.put("type", type);
		map.put("statu", statu);
		int a=session.insert("com.entity.Type.insertType", map);
		session.close();
		return a;
	}

}
