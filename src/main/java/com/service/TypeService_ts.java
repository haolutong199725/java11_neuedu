package com.service;

import java.util.List;

import com.dao.TypeDao;
import com.dao.impl.TypeDaoImpl;
import com.entity.Type;

public interface TypeService_ts {
      public List<Type> findProductType();
      public int insertType(String id, String parent_id, String type, int statu);
}
