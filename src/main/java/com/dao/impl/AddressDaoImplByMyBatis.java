package com.dao.impl;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;


import com.common.MyBatisUtils;
import com.dao.AddressDao;
import com.entity.Address;
import com.entity.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("addressDao")
public class AddressDaoImplByMyBatis implements AddressDao {
	@Autowired
	SqlSessionFactory factory;

	public void setFactory(SqlSessionFactory factory) {
		this.factory = factory;
	}

	@Override
	public int addAddress(Integer userid, Address address) {
		// TODO Auto-generated method stub
		SqlSession session=factory.openSession(true);
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("userid", address.getUserid());
		map.put("receivername", address.getReceivername());
		map.put("receiverphone", address.getReceiverphone());
		map.put("receivermobile", address.getReceivermobile());
		map.put("receiverprovince",address.getReceiverprovince());
		map.put("receivercity", address.getReceivercity());
		int a=session.insert("com.entity.Goods.insertEmp", map);
		session.close();
		return a;
	}

	@Override
	public int deleteAddressByUserid(Integer userid, String receivercity) {
		// TODO Auto-generated method stub
		SqlSession session=factory.openSession(true);
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("userid", userid);
		map.put("receivercity", receivercity);
        int a=session.delete("com.entity.Goods.deleteEmpByEmpno", map);
        session.close();
		return a;
	}

	@Override
	public int updateUserAddressByUserid(Integer userid, Address address, String receivercity) {
		// TODO Auto-generated method stub
		SqlSession session=factory.openSession(true);
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("userid", address.getUserid());
		map.put("receivername", address.getReceivername());
		map.put("receiverphone",address.getReceiverphone());
		map.put("receivermobile",address.getReceivermobile());
		map.put("receiverprovince",address.getReceiverprovince());
		map.put("receivercity",address.getReceivercity());
	    int a=session.update("com.entity.Goods.updateEmp", map);
	    session.close();
		return a;
	}

	@Override
	public PageModel<Address> findUserAddress(Integer pageNo, Integer pageSize, Integer userid) {
		// TODO Auto-generated method stub
		SqlSession session=factory.openSession(true);
		int totalCount=session.selectOne("com.entity.Goods.findTotalCount",userid);
		
		System.out.println(totalCount);
		
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("offset",(pageNo-1)*pageSize);
		map.put("pageSize",pageSize);
		map.put("userid", userid);
		List<Address> list=session.selectList("com.entity.Goods.findGoodsByPage",map);
		System.out.println(list);
		PageModel<Address> pageModel=new PageModel<Address>();
		pageModel.setTotalPage((totalCount%pageSize)==0?(totalCount/pageSize):(totalCount/pageSize)+1);
		pageModel.setData(list);
		session.close();
		return pageModel;
	}
	@Override
	public Address selectAddressByUseridAndId(Integer userid, String receivercity) {
		// TODO Auto-generated method stub
		SqlSession session=factory.openSession(true);
		Address address=null;
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("userid", userid);
		map.put("receivercity",receivercity);
		Object o=session.selectOne("com.entity.Goods.findEmpByEmpno",map);
		if(o instanceof Address) {
			address= (Address)o;
		}
		session.close();
		return address;
	}

}
