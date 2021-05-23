package com.main;

import com.Entity.CharsEntity;
import com.SingleObject;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import java.awt.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;

/*
 * @author: cm
 * @date: Created in 2021/5/13 15:38
 * @description:
 */
public class MyChart {
    private DefaultCategoryDataset Dataset;
    private List<Double> dataList;
    private CharsEntity charsEntity;
    private SingleObject singleObject;
    public Timer timer;


    public DefaultCategoryDataset getDataset() {
        return Dataset;
    }

    public void setDataset(DefaultCategoryDataset dataset) {
        Dataset = dataset;
    }

    public List getDataList() {
        return dataList;
    }

    public void setDataList(List dataList) {
        this.dataList = dataList;
    }

    public MyChart(int chanel) {
        this.singleObject=new SingleObject();
        this.Dataset = new DefaultCategoryDataset();
        this.timer = new Timer();
        this.dataList = new ArrayList();
        this.charsEntity = new CharsEntity();
        charsEntity.setChanel(chanel);
        charsEntity.setTime(new Date());
        for (int i = 0; i < 8; i++) {
            this.dataList.add(Math.random() * (250));
        }
        charsEntity.setNumber1(this.dataList.get(0));
        charsEntity.setNumber2(this.dataList.get(1));
        charsEntity.setNumber3(this.dataList.get(2));
        charsEntity.setNumber4(this.dataList.get(3));
        charsEntity.setNumber5(this.dataList.get(4));
        charsEntity.setNumber6(this.dataList.get(5));
        charsEntity.setNumber7(this.dataList.get(6));
        charsEntity.setNumber8(this.dataList.get(7));
        this.singleObject.save(this.charsEntity);
    }

    public JFreeChart getMyChart() {
        StandardChartTheme mChartTheme = new StandardChartTheme("CN");
        mChartTheme.setLargeFont(new Font("黑体", Font.BOLD, 20));
        mChartTheme.setExtraLargeFont(new Font("宋体", Font.PLAIN, 15));
        mChartTheme.setRegularFont(new Font("宋体", Font.PLAIN, 15));
        ChartFactory.setChartTheme(mChartTheme);
        initDataset();
        JFreeChart mChart = ChartFactory.createLineChart(
                "折线图",
                "年份",
                "数量",
                Dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false);
        CategoryPlot mPlot = (CategoryPlot) mChart.getPlot();
        mPlot.setBackgroundPaint(Color.LIGHT_GRAY);
        mPlot.setRangeGridlinePaint(Color.BLUE);//背景底部横虚线
        mPlot.setOutlinePaint(Color.RED);//边界线
        return mChart;
    }

    public void initDataset() {
        Dataset.addValue(this.dataList.get(0), "First", "2013");
        Dataset.addValue(this.dataList.get(1), "First", "2014");
        Dataset.addValue(this.dataList.get(2), "First", "2015");
        Dataset.addValue(this.dataList.get(3), "First", "2016");
        Dataset.addValue(this.dataList.get(4), "First", "2017");
        Dataset.addValue(this.dataList.get(5), "First", "2018");
        Dataset.addValue(this.dataList.get(6), "First", "2019");

    }

    public void fexDataset() {
        this.dataList.remove(0);
        this.dataList.add(Math.random() * (250));
        charsEntity.setNumber1(this.dataList.get(0));
        charsEntity.setNumber2(this.dataList.get(1));
        charsEntity.setNumber3(this.dataList.get(2));
        charsEntity.setNumber4(this.dataList.get(3));
        charsEntity.setNumber5(this.dataList.get(4));
        charsEntity.setNumber6(this.dataList.get(5));
        charsEntity.setNumber7(this.dataList.get(6));
        charsEntity.setNumber8(this.dataList.get(7));
        charsEntity.setTime(new Date());
        this.singleObject.save(this.charsEntity);
        initDataset();

    }


}
