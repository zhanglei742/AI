package com.example.lionproject.controller;

public interface LoginDao {
	//public  void  InputInfo(String number,String password);
	public boolean InsertInfoToDB(String number, String password);
	public boolean MatchInfo(String number, String password);
	public  boolean UpdateName(String phone, String name);
}
