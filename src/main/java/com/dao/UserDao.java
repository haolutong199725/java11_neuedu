package com.dao;

import java.util.List;

import com.entity.User;

public interface UserDao {
  public List<User> findAllUser();
}
