package com.cx.user.action;

import com.cx.core.action.BaseAction;
import com.cx.user.entity.User;
import com.cx.user.service.UserService;
import com.opensymphony.xwork2.ActionContext;

import javax.annotation.Resource;

/**
 * Created by liujie on 2017/2/25.
 */
public class UserAction extends BaseAction {

    @Resource
    private UserService userService;

    private User user;

    private String errorMessage;

    public String loginUI(){
        return "loginUI";
    }

    public String addUI(){
        return "addUI";
    }

    public String add(){


        if (user != null){
            userService.save(user);
        }

        errorMessage = "初始化用户OK！";

        return "loginUI";
    }

    public String loginOut(){

        //注销逻辑
        ActionContext.getContext().getSession().remove("USER_INFO");

        return "loginOut";
    }

    public String login(){

        if (user != null){

            System.out.println(userService.findUserByAccountAndPwd(user.getAccount(),user.getPassword()));

            if (user.getAccount()!=null && user.getPassword() != null){

                if (userService.findUserByAccountAndPwd(user.getAccount(),user.getPassword()).size()>0){

                    user = userService.findUserByAccountAndPwd(user.getAccount(),user.getPassword()).get(0);

                    ActionContext.getContext().getSession().put("USER_INFO",user);

                    return "loginSuccess";
                }

            }


        }

        errorMessage = "用户名或密码错误";

        return "loginError";
    }




    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
