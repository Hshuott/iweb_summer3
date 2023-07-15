package com.iweb.Test.Test1;

public class UserServicelmpl2 implements UserService {
    @Override
    public void login(){
        System.out.println("扫码登录");

    }
    @Override
    public void register(){
        System.out.println("扫码注册");
    }
}
