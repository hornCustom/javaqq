/*
 * ����һ�������û�����������
 * */

package com.qq.client.tools;


import java.util.*;
import com.qq.client.view.*;

public class ManageQqChat {

	private static  HashMap hm = new HashMap<String, QqChat>();
	//����
	public static void addQqChat(String loginIdAnFriend,QqChat qqChat) 
	{
		hm.put(loginIdAnFriend, qqChat);
		
	}
	//ȡ��
	public static QqChat getQqChat(String loginIdAnFriend) {
		
		return (QqChat)hm.get(loginIdAnFriend);
	}
}
