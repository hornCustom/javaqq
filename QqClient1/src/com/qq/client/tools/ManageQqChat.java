/*
 * 这是一个管理用户聊天界面的类
 * */

package com.qq.client.tools;


import java.util.*;
import com.qq.client.view.*;

public class ManageQqChat {

	private static  HashMap hm = new HashMap<String, QqChat>();
	//加入
	public static void addQqChat(String loginIdAnFriend,QqChat qqChat) 
	{
		hm.put(loginIdAnFriend, qqChat);
		
	}
	//取出
	public static QqChat getQqChat(String loginIdAnFriend) {
		
		return (QqChat)hm.get(loginIdAnFriend);
	}
}
