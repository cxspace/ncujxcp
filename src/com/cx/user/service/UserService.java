package com.cx.user.service;

import com.cx.core.service.BaseService;
import com.cx.user.entity.User;

import java.util.List;

/**
 * Created by liujie on 2017/2/25.
 */
public interface UserService extends BaseService<User> {

    public List<User> findUserByAccountAndPwd(String account , String pwd);

}
