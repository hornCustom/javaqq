/*
 *����qq�����������ڼ������ȴ�ĳ��qq�ͻ��ˣ�������
 * */

package com.qq.server.model;

import javax.net.*;
import com.qq.common.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class MyQqServer {

	public MyQqServer() {
		// TODO Auto-generated constructor stub

		try {
			// ��9999����
			System.out.println("���Ƿ���������9999����");
			ServerSocket ss = new ServerSocket(9999);
			// �������ȴ�����
			while(true){
			Socket s = ss.accept();
			// ���տͻ��˷�������Ϣ

			ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
			User u = (User) ois.readObject();
			System.out.println("���������յ��û�id��" +u.getUserId()+"���룺"+u.getPasswd());
			Message m = new Message();
			ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
			if (u.getPasswd().equals("123456")) {
				// ����һ���ɹ���¼����Ϣ��
				m.setMesType("l");
				oos.writeObject(m);
				
				//����͵���һ���̣߳��ø��߳���ͻ��˱���ͨѶ
				SerConClientThread scct=new SerConClientThread(s);
				ManageClientThread.addClientThread(u.getUserId(), scct);
				//�����ÿͻ���ͨ�ŵ��߳�
				scct.start();
				
			} else {
				m.setMesType("2");
				oos.writeObject(m);
				//�ر�Socket
				s.close();
			}
			
		  }

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		} finally {

		}
	}
}
