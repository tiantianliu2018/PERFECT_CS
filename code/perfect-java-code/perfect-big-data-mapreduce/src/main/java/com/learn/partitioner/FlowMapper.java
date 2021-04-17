package com.learn.partitioner;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * @author Kelly
 * @create 2021-04-06 15:33
 */
public class FlowMapper extends Mapper<LongWritable, Text, Text, FlowBean> {
    private Text outKey = new Text();
    private FlowBean outValue = new FlowBean();

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        // 1	13736230513	192.196.100.1	www.atguigu.com	2481	24681	200
        // 获取一行
        String line = value.toString();

        // 切割
        String[] fields = line.split("\t");

        // 提取数据字段
        String phone = fields[1];
        long up = Long.parseLong(fields[fields.length - 3]);
        long down = Long.parseLong(fields[fields.length - 3]);

        // 封装输出的 key 和 value
        outKey.set(phone);
        outValue.setUpFlow(up);
        outValue.setDownFlow(down);
        outValue.setSumFlow();

        // 写数
        context.write(outKey, outValue);
    }
}
