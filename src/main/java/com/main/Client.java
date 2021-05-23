package com.main;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/*
 * @author: cm
 * @date: Created in 2021/5/24 0:03
 * @description:
 */
public class Client {
    public static void main(String[] args) throws Exception
    {
        @SuppressWarnings("resource")
        DatagramSocket ds = new DatagramSocket(30000);//接收端监听指定端口
        while(true)
        {
            //定义数据包,用于存储数据
            byte[] buf = new byte[1024];
            DatagramPacket dp = new DatagramPacket(buf,buf.length);
            ds.receive(dp);//通过服务的receive方法将收到数据存入数据包中,receive()为阻塞式方法
            //通过数据包的方法获取其中的数据
            String ip = dp.getAddress().getHostAddress();
            String data = new String(dp.getData(),0,dp.getLength());
            System.out.println(ip+"::"+data);
        }
    }
}
