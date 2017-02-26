package com.cx.user.dao.impl;

import com.cx.core.dao.impl.BaseDaoImpl;
import com.cx.user.dao.UserDao;
import com.cx.user.entity.User;
import org.hibernate.Query;

import java.util.List;

/**
 * Created by liujie on 2017/2/25.
 */
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {
    @Override
    public List<User> findUserByAccountAndPwd(String account, String pwd) {

        Query query = getSession().createQuery("FROM User WHERE account = ? and password = ?");

        query.setParameter(0,account);

        query.setParameter(1,pwd);

        return query.list();
    }
}
