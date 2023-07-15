package com.iweb.Test.Test1;

public class UserServicelmpl1 implements UserService {
    @Override
    public void login(){
        System.out.println("使用用户名密码登录");

    }
    @Override
    public void register(){
        System.out.println("使用用户名密码注册");
    }
}
