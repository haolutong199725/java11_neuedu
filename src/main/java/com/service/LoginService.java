package com.service;

import com.entity.User;

public interface LoginService {
             public User loginServlet(String username, String password);
             public int  updateTokenByUserId(String user, String token);
             public User TokenUser(String token);
}
