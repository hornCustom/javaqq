package com.qq.server.model;

import java.util.HashMap;

public class ManageClientThread {

	public static HashMap hm=new HashMap<String,SerConClientThread>();
	//��hm������и��ͻ���ͨѶ�߳�
	public static void addClientThread(String uid,SerConClientThread ct)
	{
		hm.put(uid, ct);
	}
	public static SerConClientThread getClientThread(String uid){
		return(SerConClientThread)hm.get(uid);
	}
}
