package com.webserver.servlet;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.Arrays;

import com.webserver.http.HttpRequest;
import com.webserver.http.HttpResponse;

/**
 * 处理注册业务
 * @author Administrator
 *
 */
public class RegServlet {
	public void service(HttpRequest request,HttpResponse response) {
		System.out.println("RegServlet:开始处理注册……");
		/*
		 * 1.通过request获取用户在页面上输入的注册信息
		 * 
		 * 2.将该用户的注册信息写入到文件user.dat中
		 * 
		 * 3.设置response响应注册结果页面
		 */
		//1
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String nickname = request.getParameter("nickname");
		int age = Integer.parseInt(request.getParameter("age"));
		
		System.out.println("username:" + username);
		System.out.println("password:" + password);
		System.out.println("nickname:" + nickname);
		System.out.println("age:" + age);
		/*
		 * 2
		 */
		try {
			RandomAccessFile raf = new RandomAccessFile("./user.dat","rw");
			//指针拨至最后
			raf.seek(raf.length());
			//写入用户名
			byte data[] = username.getBytes("utf-8");
			data = Arrays.copyOf(data, 32);
			raf.write(data);
			//写入密码
			data = password.getBytes("utf-8");
			data = Arrays.copyOf(data, 32);
			raf.write(data);
			//写入昵称
			data = nickname.getBytes("utf-8");
			data = Arrays.copyOf(data, 32);
			raf.write(data);
			//写入年龄
			raf.writeInt(age);
			
			raf.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		//3
		File  successPage = new File("./webapps/myweb/reg_success.html");
		response.setEntity(successPage);
		
		System.out.println("RegServlet:处理注册业务完毕！");
	}
}
