package com.dao;

import com.entity.User;

public interface LoginDao {
	public User loginByUsenameAndPassword(String username, String password);
    public int  updateTokenByuserId(String user, String token);
    public User TokenUser(String token);
}
