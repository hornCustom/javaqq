/**
 * ����һ���ͻ��˳��򣬿������ӷ�������
 */
package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;

public class MyClient1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyClient1 mc1=new MyClient1();
	}
	
	public  MyClient1() 
	{
		try {
			//Socket()����ȥ����ĳ���������ˡ�127.0.0.1��ʾ��������ip
			//9999���Ƕ˿ں�
			Socket s=new Socket("127.0.0.1", 9999);
			
			//���s���ӳɹ�,�Ϳ��Է������ݸ�������
			//����ͨ��pw,��sд����,ture��ʾ��ʱˢ��
			PrintWriter pw=new PrintWriter(s.getOutputStream(),true);
			
			pw.println("���ô�����ǿͻ���");
			
			//Ҫ��ȡs�д��ݵ����ݡ�
			InputStreamReader isr=new InputStreamReader(s.getInputStream());
			BufferedReader br = new BufferedReader(isr);
			
			String response=br.readLine();
			
			System.out.println("���ǿͻ���,���յ����������͵���Ϣ��"+response);
			
		} catch (IOException e) {
			e.printStackTrace();
			// TODO Auto-generated catch block
		}
	}
}
