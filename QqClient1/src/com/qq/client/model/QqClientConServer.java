/*
 * ���ǿͻ������ӷ������ĺ�̨
 * */

package com.qq.client.model;
import java.util.*;
import java.net.*;
import java.io.*;
import com.qq.client.tools.*;
import com.qq.client.tools.ClientConServerThread;
import com.qq.common.*;

public class QqClientConServer {

	
	public  Socket s;
	
	//���͵�һ������
	public Boolean SendLoginInfoToServer(Object o) {
		boolean b=false;
		try {
			System.out.println("kk");
			 s=new Socket("127.0.0.1", 9999);
			ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());
			oos.writeObject(o);
			
			ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
					
			Message ms=(Message)ois.readObject();
			//���������֤�û���¼�ĵط�
			if(ms.getMesType().equals("l"))
			{
				//�ʹ���һ����qq�źͷ������˱���ͨѶ���ӵ��߳�
				ClientConServerThread ccst=new ClientConServerThread(s);
				//������ͨѶ�߳�
				ccst.start();
				ManageClientConServerThread.addClientConServerThread
				(((User)o).getUserId(), ccst);
				
				b=true;
			}else{
				//�ر�Scoket
				s.close();
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
