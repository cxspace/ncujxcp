package com.cx.user.dao;

import com.cx.core.dao.BaseDao;
import com.cx.user.entity.User;

import java.util.List;

/**
 * Created by liujie on 2017/2/25.
 */
public interface UserDao extends BaseDao<User> {
    //登录逻辑
    public List<User> findUserByAccountAndPwd(String account , String pwd);
}
