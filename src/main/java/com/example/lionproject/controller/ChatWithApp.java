package com.example.lionproject.controller;

import com.example.lionproject.service.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/Receive")
public class ChatWithApp  {
	//发送验证码
	@RequestMapping("/SendCode")
	@ResponseBody
		//======注解方式 参数
	public String SendCode(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//HttpServletRequest req, HttpServletResponse rep
		String webphone = request.getParameter("phonenumber");
		String weblocation = request.getParameter("location");
		//String webphone ="130";
		//String weblocation ="1";
		System.out.println("后端接受用户第一次传来的信息");

		//======添加service层
		VerificationCode verificationCode = new VerificationCodeImpl();
		if (verificationCode.SendCode(webphone, weblocation)) {
			//返回1表明验证码无误并成功
			return "1";
		} else
			//返回1表明验证码输入错误
			return "0";

	}
	//匹配验证码
	@RequestMapping("/CheckCode")
	@ResponseBody
	public String CheckCode(HttpServletRequest request, HttpServletResponse response)throws Exception
	{
		//Integer phone, Integer location, Integer code
//		String  phone1 ="130";
//		String location2 ="1";
//		String code3 = "4321";
		String secondphone =request.getParameter("phonenumber");
		String secondlocation =request.getParameter("location");
		String secondcode =request.getParameter("code");
		System.out.println("匹配验证码信息：用户第二次传来的手机号为：" + secondphone + "；功能位置：" + secondlocation+ "；验证码：" + secondcode);

		VerificationCode verificationCode = new VerificationCodeImpl();
		if (verificationCode.CheckCode(secondphone, secondlocation,secondcode)) {
			return "传给前端：信息已经匹配";
		} else
			return "传给前端：信息不匹配";
	}
	@RequestMapping("/login")
	@ResponseBody
	//注解方式获取参数
	public String Login(HttpServletRequest req, HttpServletResponse rep) throws Exception {
		String username = req.getParameter("username");
		String pass = req.getParameter("pass");
		System.out.println("使用Spring内置的支持" + username + "--->" + pass);
		//确实service层
		LoginDao op = new LoginDaoImpl();
		if (op.MatchInfo(username, pass)) {
			return "1";
		} else
			return "0";
	}
	@RequestMapping("/register")
	@ResponseBody
	public String Register(HttpServletRequest req, HttpServletResponse rep) throws Exception {
		String username = req.getParameter("username");
		String pass = req.getParameter("pass");
		System.out.println("使用Spring内置的支持" + username + "--->" + pass);
		LoginDao op = new LoginDaoImpl();
		if (op.InsertInfoToDB(username, pass)) {
			return "1";
		} else
			return "0";
	}
	//忘记密码功能
	@RequestMapping("/forgetpassword")
	@ResponseBody
	//======注解方式 参数
	public String ForgetPassword(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String webphone = request.getParameter("phonenumber");
		String newpassword = request.getParameter("newpassword");
		System.out.println("已接受前端发来信息");
		//======添加service层
		ChangePassword changePassword = new ChangePasswordImpl();
		if (changePassword.ForgetPassword(webphone,newpassword)) {
			//返回1表明忘记密码修改成功
			return "1";
		} else
			//返回1表明忘记密码修改失败
			return "0";

	}
	@RequestMapping("/updateusername")
	@ResponseBody
	public String UpdateUserName(HttpServletRequest req, HttpServletResponse rep) throws Exception {
		String phone = req.getParameter("phone");
		String name = req.getParameter("name");
		req.setCharacterEncoding("utf-8");
		System.out.println("使用Spring内置的支持" + phone + "--->" + name);
		LoginDao op = new LoginDaoImpl();
		if (op.UpdateName(phone,name)) {
			return "1";
		} else
			return "0";
	}



}