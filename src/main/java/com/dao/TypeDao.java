package com.dao;

import java.util.List;

import com.entity.Type;

public interface TypeDao {
  public List<Type> findProductType();
  public int insertType(String id, String parent_id, String type, int statu);
}
