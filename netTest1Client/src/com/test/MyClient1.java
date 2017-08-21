/**
 * 这是一个客户端程序，可以连接服务器端
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
			//Socket()就是去连接某个服务器端。127.0.0.1表示服务器的ip
			//9999就是端口号
			Socket s=new Socket("127.0.0.1", 9999);
			
			//如果s连接成功,就可以发送数据给服务器
			//我们通过pw,向s写数据,ture表示即时刷新
			PrintWriter pw=new PrintWriter(s.getOutputStream(),true);
			
			pw.println("你好么？我是客户端");
			
			//要读取s中传递的数据。
			InputStreamReader isr=new InputStreamReader(s.getInputStream());
			BufferedReader br = new BufferedReader(isr);
			
			String response=br.readLine();
			
			System.out.println("我是客户端,我收到服务器回送的信息："+response);
			
		} catch (IOException e) {
			e.printStackTrace();
			// TODO Auto-generated catch block
		}
	}
}
