package com.learn.reducejoin;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;

import java.io.IOException;

/**
 * @author Kelly
 * @create 2021-04-12 15:40
 */
public class TableMapper extends Mapper<LongWritable, Text, Text, TableBean> {

    private String fileName;
    private Text outKey = new Text();
    private TableBean outV = new TableBean();

    // 初始化方法
    // 获取 order 和 pd 文件名称
    @Override
    protected void setup(Context context) throws IOException, InterruptedException {
        FileSplit inputSplit = (FileSplit) context.getInputSplit();
        fileName = inputSplit.getPath().getName();
    }

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        // 获取一行
        String line = value.toString();

        if (fileName.contains("order")) {
            // 处理的是订单表
            String[] fields = line.split("\t");
            // 封装对应的 key 和 value
            outKey.set(fields[1]);

            outV.setId(fields[0]);
            outV.setPid(fields[1]);
            outV.setAmount(Integer.parseInt(fields[2]));
            outV.setPname("");
            outV.setFlag("order");
        } else {
            // 处理商品表
            String[] fields = line.split("\t");
            // 封装对应的 key 和 value
            outKey.set(fields[0]);

            outV.setId("");
            outV.setPid(fields[0]);
            outV.setAmount(0);
            outV.setPname(fields[1]);
            outV.setFlag("pd");
        }

        context.write(outKey, outV);
    }
}
