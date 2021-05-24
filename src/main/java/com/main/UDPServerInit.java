package com.main;

import org.jfree.chart.plot.PlotRenderingInfo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.ArrayList;

/*
 * @author: cm
 * @date: Created in 2021/5/24 16:16
 * @description:
 */
public class UDPServerInit {
    public ArrayList<Double> datelist;


    //移除sorct接收数据集合的第一个元素
    public void remvo(){
            this.datelist.remove(0);
    }
    public DatagramPacket dp;
    public DatagramSocket ds;

    @SuppressWarnings("resource")
    public UDPServerInit() throws IOException {
        this.datelist = new ArrayList();
        for (int i = 0; i < 1000; i++) {
            this.datelist.add(Math.random() * (8));
        }

         this.ds = new DatagramSocket(30000);//接收端监听指定端口
            //定义数据包,用于存储数据
            byte[] buf = new byte[1024];
            this.dp = new DatagramPacket(buf,buf.length);
            ds.receive(dp);//通过服务的receive方法将收到数据存入数据包中,receive()为阻塞式方法
           /* ds.receive(dp);//通过服务的receive方法将收到数据存入数据包中,receive()为阻塞式方法
            //通过数据包的方法获取其中的数据
            String ip = this.dp.getAddress().getHostAddress();
            double v = TransUtils.bytes2Double(dp.getData());*/
            //String data = new String(dp.getData(),0,dp.getLength());
            //System.out.println(ip+"::"+v);
    }
    public void receive() throws IOException {
        ds.receive(dp);//通过服务的receive方法将收到数据存入数据包中,receive()为阻塞式方法
        //通过数据包的方法获取其中的数据
        //String ip = this.dp.getAddress().getHostAddress();
        this.datelist.add(TransUtils.bytes2Double(dp.getData()));
        //return TransUtils.bytes2Double(dp.getData());
    }
}
