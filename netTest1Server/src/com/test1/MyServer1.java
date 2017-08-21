/**
 * 这是第一个服务器端程序。让他在9999端口监听.
 * 可以接收从客户端发来的信息
 */
package com.test1;
import java.io.*;
import java.io.IOException;
import java.net.*;
public class MyServer1 {

	public static void main(String []args)
	{
		MyServer1 ms1=new MyServer1();
	}

	public  MyServer1() 
	{
		try {
			//在9999号端口监听
			ServerSocket ss=new ServerSocket(9999);
			System.out.println("我是服务器，在9999端口监听。。");
			//等待某个客户端来连接,该函数会返回一个Scoket连接
			Socket s=ss.accept();
			
			//要读取s中传递的数据。
			InputStreamReader isr=new InputStreamReader(s.getInputStream());
			BufferedReader br = new BufferedReader(isr);

			String info=br.readLine();
			
			System.out.println("服务器接收到："+info);
			
			PrintWriter pw=new PrintWriter(s.getOutputStream(),true);
			
			pw.println("我是服务器,你也好！");
			
		} catch (IOException e) {
			e.printStackTrace();
			// TODO Auto-generated catch block
		}
	}
	
}
