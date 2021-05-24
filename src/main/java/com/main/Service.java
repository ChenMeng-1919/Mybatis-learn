package com.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/*
 * @author: cm
 * @date: Created in 2021/5/24 0:02
 * @description:
 */
public class Service {
    public static void main(String[] args) throws Exception {

        //创建发送数据定时器
        Timer timer = new Timer();
        DatagramSocket ds = new DatagramSocket();//通过DatagramSocket对象创建udp服务
        //BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));//从键盘上面输入文本
        String line = "hello world";
        //while((line=bufr.readLine())!=null)//当输入不为空时
        //{
        //if("byebye".equals(line))//当输入为byebye时退出程序
        //break;
        //确定好数据后，并把数据封装成数据包
        //byte[] buf = line.getBytes();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                //发送数据
                double v = Math.random() * (8);
                byte[] bytes = TransUtils.double2Bytes(v);
                System.out.println("传感器发送的数据为:" + v);
                //3.使用网络字节输出流OutputStream对象中的方法write,给服务器发送数据
                try {
                    DatagramPacket dp = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("192.168.1.171"), 30000);//发送至指定IP，指定端口
                    ds.send(dp);//通过send方法将数据包发送出去
                    //}
                    //ds.close();//关闭资源
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }, new Date(), 2 * 1000);
    }
}
