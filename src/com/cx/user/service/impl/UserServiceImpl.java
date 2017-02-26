package com.cx.user.service.impl;

import com.cx.core.service.impl.BaseServiceImpl;
import com.cx.user.dao.UserDao;
import com.cx.user.entity.User;
import com.cx.user.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by liujie on 2017/2/25.
 */

@Service("userService")

public class UserServiceImpl extends BaseServiceImpl<User> implements UserService{

    private UserDao userDao;

    @Resource
    public void setUserDao(UserDao userDao) {
        super.setBaseDao(userDao);
        this.userDao = userDao;
    }

    @Override
    public List<User> findUserByAccountAndPwd(String account, String pwd) {
        return userDao.findUserByAccountAndPwd(account,pwd);
    }

}
