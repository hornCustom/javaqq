/*
 * 这是客户端连接服务器的后台
 * */

package com.qq.client.model;
import java.util.*;
import java.net.*;
import java.io.*;
import com.qq.common.*;

public class QqClientConServer {

	
	public static Socket s;
	
	//发送第一次请求
	public Boolean SendLoginInfoToServer(Object o) {
		boolean b=false;
		try {
			s=new Socket("127.0.0.1", 9999);
			ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());
			oos.writeObject(o);
			
			ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
					
			Message ms=(Message)ois.readObject();
			if(ms.getMesType().equals("l"))
			{
				b=true;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
		}
		return b;
	}
	
	public void SendInfoToServer(Object o){
		try {
			 s=new Socket("127.0.0.1", 9999);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
		}
	}
	}
