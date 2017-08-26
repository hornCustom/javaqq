/*
 * �������������Ľ���
 * ��Ϊ�ͻ���Ҫ���ڶ�ȡ��״̬��������ǰ�������һ���߳�
 * */
package com.qq.client.view;

import javax.swing.*;
import com.qq.common.*;
import java.awt.event.*;
import java.io.*;
import com.qq.client.tools.*;

public class QqChat extends JFrame implements ActionListener{

	JTextArea jta;
	JTextField jtf;
	JButton jb;
	JPanel jp;
	String ownerId;
	String friendId;

	public static void main(String[] args) {
		// TODO Auto-generated constructor stub
		//QqChat qqChat = new QqChat("1");
	}
	public QqChat(String ownerId,String friend) {
		
		this.ownerId=ownerId;
		this.friendId=friend;
		jta=new JTextArea();
		jtf=new JTextField(15);
		jb=new JButton("����");
		jb.addActionListener(this);
		jp=new JPanel();
		jp.add(jtf);
		jp.add(jb);
		
		this.add(jta,"Center");
		this.add(jp,"South");
		this.setTitle(ownerId+"���ں� "+friend+"����");
		this.setIconImage((new ImageIcon("new_image/touxiang.png").getImage()));
		this.setSize(300,200);
		this.setVisible(true);
		
		
		
	}
	//дһ��������������ʾ��Ϣ
	public void showMessage(Message m) {
		String info = m.getSender()+" �� "+m.getGetter()+"˵��"+m.getCon()+"\r\n";
		this.jta.append(info);
	}
	
	
	
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getSource()==jb) {
			//����û�����ˣ����Ͱ�ť
			Message m=new Message();
			m.setMesType(MessageType.message_comm_mes);
			m.setSender(this.ownerId);
			m.setGetter(this.friendId);
			m.setCon(jtf.getText());
			m.setSendTime(new java.util.Date().toString());
			//���͸�������
			try {
				ObjectOutputStream oos=new ObjectOutputStream
				(ManageClientConServerThread.getClientConServerThread(ownerId).getS().getOutputStream());
			
				oos.writeObject(m);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}
	}
	/*public void run() {
		// TODO Auto-generated method stub
		while (true) {
			try {
				//��ȡ[����������͵ȴ�]
				ObjectInputStream ois =new ObjectInputStream(QqClientConServer.s.getInputStream());
			
				Message m=(Message)ois.readObject();
				//��ʾ
			
				String info=m.getSender()+"�� "+m.getGetter()+"˵��"+m.getCon()+"\r\n";
				this.jta.append(info);
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}

	}*/
}
