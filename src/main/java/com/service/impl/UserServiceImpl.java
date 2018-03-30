package com.service.impl;

import com.dao.UserDao;
import com.entity.User;
import com.service.UserService_us;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("userService")
public class UserServiceImpl implements UserService_us {

    @Autowired
    UserDao userDao;


    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> findAllUser() {
        return userDao.findAllUser();
    }
}
