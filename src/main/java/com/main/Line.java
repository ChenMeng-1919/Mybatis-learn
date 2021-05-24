package com.main;

import com.SingleObject;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Line extends Frame {
    public Timer timer;

    public Line() throws HeadlessException, IOException {
        JFrame frame = new JFrame();
        //初始化UDP对象
        UDPServerInit udpServerInit = new UDPServerInit();
        MyChart myChart1 = new MyChart(1);
        JFreeChart myChartA = myChart1.getMyChart();
        MyChart myChart2 = new MyChart(2);
        JFreeChart myChartB = myChart2.getMyChart();
        MyChart myChart3 = new MyChart(3);
        JFreeChart myChartC = myChart3.getMyChart();
        MyChart myChart4 = new MyChart(4);
        JFreeChart myChartD = myChart4.getMyChart();


        ChartFrame mChartFrame1 = new ChartFrame("折线图1", myChartA);
        ChartFrame mChartFrame2 = new ChartFrame("折线图2", myChartB);
        ChartFrame mChartFrame3 = new ChartFrame("折线图3", myChartC);
        ChartFrame mChartFrame4 = new ChartFrame("折线图4", myChartD);
        ChartPanel chartPanel1 = mChartFrame1.getChartPanel();
        ChartPanel chartPanel2 = mChartFrame2.getChartPanel();
        ChartPanel chartPanel3 = mChartFrame3.getChartPanel();
        ChartPanel chartPanel4 = mChartFrame4.getChartPanel();
        //mChartFrame.pack();
        //mChartFrame.setVisible(true);
        Timer timer1 = new Timer();
        JPanel jPanel1 = new JPanel();
        JButton button1 = new JButton("Start");
        jPanel1.add(button1);
        JButton button2 = new JButton("Stop");
        jPanel1.add(button2);
        frame.add(jPanel1, BorderLayout.SOUTH);
        JPanel jPanel2 = new JPanel();
        jPanel2.setLayout(new GridLayout(4, 4));
        jPanel2.add(chartPanel1);
        jPanel2.add(chartPanel2);
        jPanel2.add(chartPanel3);
        jPanel2.add(chartPanel4);
        frame.add(jPanel2, BorderLayout.CENTER);

        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt, myChart1, myChart2, myChart3, myChart4, timer1, jPanel2, udpServerInit);
            }
        });
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt, timer1, frame, myChart1, udpServerInit);
            }
        });

        frame.setSize(1000, 700);
        frame.pack();
        frame.setVisible(true);

    }

    public static void main(String[] args) throws IOException {
        Line line = new Line();
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt, Timer timer, JFrame frame, MyChart myChart1, UDPServerInit udpServerInit) {
        // TODO add your handling code here:
        myChart1.timer.cancel();
        myChart1.timer = new Timer();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt, MyChart myChart1, MyChart myChart2, MyChart myChart3, MyChart myChart4, Timer timer, JPanel jPanel2, UDPServerInit udpServerInit) {
        myChart1.timer.schedule(new TimerTask() {
            @Override
            public void run() {
                double receive;
                try {
                    udpServerInit.receive();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                myChart1.fexDataset(udpServerInit);
                myChart2.fexDataset(udpServerInit);
                myChart3.fexDataset(udpServerInit);
                myChart4.fexDataset(udpServerInit);
                jPanel2.updateUI();
            }
        }, new Date(), 2 * 1000);
        // TODO add your handling code here:
    }
}
