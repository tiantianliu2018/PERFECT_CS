package com.learn.writableComparable;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * @author Kelly
 * @create 2021-04-06 15:33
 */
public class FlowMapper extends Mapper<LongWritable, Text, FlowBean, Text> {
    private FlowBean outK = new FlowBean();
    private Text outV = new Text();

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        // 13509468723	7335	7335	14670
        // 获取一行
        String line = value.toString();
        // 切割
        String[] fields = line.split("\t");
        System.out.println(fields[0] + " "  + fields[1]+ " "  + fields[2]+ " "  + fields[3]);

        // 封装
        outK.setUpFlow(Long.parseLong(fields[1]));
        outK.setDownFlow(Long.parseLong(fields[2]));
        outK.setSumFlow();

        outV.set(fields[0]);

        System.out.println("===========================");
        System.out.println(outK);
        System.out.println(outV);

        // 写出
        context.write(outK, outV);
    }
}
