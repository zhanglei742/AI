package com.example.lionproject.controller;
//import redistools.*;
public interface VerificationCode {
    //接受手机号
    public boolean SendCode(String phone, String location);

    //匹配手机号、验证码
    public boolean CheckCode(String phone, String location, String code);

}

