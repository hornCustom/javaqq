/*
 * ���ǿͻ��˺ͷ������˱���ͨѶ���߳�
 * */
package com.qq.client.tools;

import java.io.*;
import java.net.*;

import com.qq.client.view.QqChat;
import com.qq.client.view.QqFriendList;
import com.qq.common.*;

public class ClientConServerThread extends Thread {

	private Socket s;

	// ���캯��
	public ClientConServerThread(Socket s) {
		// TODO Auto-generated constructor stub
		this.s = s;
	}

	public void run() {
		while (true) {
			//��ͣ�Ķ�ȡ�ӷ������˷�������Ϣ
			try {
			  
				ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
				Message m=(Message)ois.readObject();
				
				/*System.out.println("��ȡ����������������Ϣ"+m.getSender()+"�� "+m.getGetter()+"����"+
				m.getCon());*/
				
				if (m.getMesType().equals(MessageType.message_comm_mes)) 
				{
				//�Ѵӷ�������õ���Ϣ����ʾ������ʾ���������
				QqChat qqChat=ManageQqChat.getQqChat(m.getGetter()+" "+m.getSender());
				//��ʾ
				qqChat.showMessage(m);
				}else if(m.getMesType().equals(MessageType.message_ret_onLineFriend))
                {
					System.out.println("�ͻ��˽��յ�"+m.getCon());
	                String con=m.getCon();
	                String friends[]=con.split(" ");
	                String getter=m.getGetter();
	                System.out.println("getter="+getter);
	                //�޸���Ӧ�ĺ����б�
	               QqFriendList qqFriendList= ManageQqFriendList.getQqFriendList(getter);   
	           
	          //     if(qqFriendList)
	               //�������ߺ���
	               if(qqFriendList!=null)
	               qqFriendList.upateFriend(m);
	             
                
                }
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	

	public Socket getS() {
		return s;

	}

	public void setS(Socket s) {
		this.s = s;
	}
}
