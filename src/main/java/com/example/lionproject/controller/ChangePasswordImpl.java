package com.example.lionproject.controller;
import com.example.lionproject.dao.DBhelper;

//修改密码接口实现
public class ChangePasswordImpl implements ChangePassword{
    //忘记密码实现
    //进入忘记密码页面，新密码，确认新密码。前端判断两个控件插入的内容是否一致
    @Override
    public boolean ForgetPassword(String phonenumber, String newpassword) {
        //ystem.out.println("1111");
        //先判断表中是否存在，不存在的话返回false，让用户先去注册
       if(com.example.lionproject.dao.DBhelper.SearchMessageExit("user","number",phonenumber))
       {    System.out.println("查询到该用户，开始更新");
           //写sql语句update数据库的内容
           //调用数据库的更新功能，在用户表中更新密码
           if(!com.example.lionproject.dao.DBhelper.UpdatePassword("user", phonenumber,newpassword))return false;//插入失败
           return true;//否则，更新成功
       }
       else {
           System.out.println("没有在数据库中查询到该用户");
            return false;
       }


    }
}
