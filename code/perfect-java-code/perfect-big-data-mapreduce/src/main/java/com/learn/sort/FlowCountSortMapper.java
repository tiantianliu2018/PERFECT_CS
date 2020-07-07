package com.learn.sort;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * @author Kelly
 * @create 2020-07-02 14:14
 */
public class FlowCountSortMapper extends Mapper<LongWritable, Text, FlowBean, Text> {
    FlowBean k = new FlowBean();
    Text v = new Text();
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        // 手机号  上行流量 下行流量 总流量
        // 获取一行
        String line = value.toString();
        String[] fields = line.split("\t");
        // 封装对象
        String phoneNum = fields[0];
        k.setUpFlow(Long.parseLong(fields[1]));
        k.setDownFlow(Long.parseLong(fields[2]));
        k.setSumFlow(Long.parseLong(fields[3]));

        v.set(phoneNum);
        context.write(k, v);
    }
}
