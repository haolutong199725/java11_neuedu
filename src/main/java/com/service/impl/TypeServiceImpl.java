package com.service.impl;

import java.util.List;

import com.dao.TypeDao;
import com.dao.impl.TypeDaoImpl;
import com.entity.Type;
import com.service.TypeService_ts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("typeService")
public class TypeServiceImpl implements TypeService_ts {
	@Autowired
	TypeDao type;

	public void setType(TypeDao type) {
		this.type = type;
	}

	@Override
	public List<Type> findProductType() {
		// TODO Auto-generated method stub
		
		return type.findProductType();
	}

	@Override
	public int insertType(String id, String parent_id, String type1, int statu) {
		// TODO Auto-generated method stub
		
		return type.insertType(id, parent_id, type1, statu);
	}

}
