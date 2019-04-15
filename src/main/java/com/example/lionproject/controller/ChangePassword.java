package com.example.lionproject.controller;
//修改密码接口
public interface ChangePassword {
    //忘记密码，输入新密码、确认新密码
    public boolean ForgetPassword(String newpassword, String confirmpassword);
}
