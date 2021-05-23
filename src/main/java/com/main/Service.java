package com.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/*
 * @author: cm
 * @date: Created in 2021/5/24 0:02
 * @description:
 */
public class Service {
    public static void main(String[] args) throws Exception
    {
        DatagramSocket ds = new DatagramSocket();//通过DatagramSocket对象创建udp服务
        BufferedReader bufr =
                new BufferedReader(new InputStreamReader(System.in));//从键盘上面输入文本
        String line = null;
        while((line=bufr.readLine())!=null)//当输入不为空时
        {
            if("byebye".equals(line))//当输入为byebye时退出程序
                break;
            //确定好数据后，并把数据封装成数据包
            byte[] buf = line.getBytes();
            DatagramPacket dp =
                    new DatagramPacket(buf,buf.length, InetAddress.getByName("10.32.0.23"),30000);//发送至指定IP，指定端口
            ds.send(dp);//通过send方法将数据包发送出去
        }
        ds.close();//关闭资源
    }
}
