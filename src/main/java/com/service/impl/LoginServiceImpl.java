package com.service.impl;

import com.service.LoginService;
import com.dao.LoginDao;
import com.dao.impl.LoginDaoImpl;
import com.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class LoginServiceImpl implements LoginService {





	@Override
	public User loginServlet(String username, String password) {
		// TODO Auto-generated method stub
		LoginDao loginDao=new LoginDaoImpl();
		return loginDao.loginByUsenameAndPassword(username, password);
	}

	@Override
	public int updateTokenByUserId(String user, String token) {
		// TODO Auto-generated method stub
		LoginDao loginDao=new LoginDaoImpl();
		return loginDao.updateTokenByuserId(user, token);
	}

	@Override
	public User TokenUser(String token) {
		// TODO Auto-generated method stub
		LoginDao loginDao=new LoginDaoImpl();
		return loginDao.TokenUser(token);
	}

}
