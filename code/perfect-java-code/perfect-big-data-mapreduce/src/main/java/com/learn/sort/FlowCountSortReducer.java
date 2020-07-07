package com.learn.sort;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * @author Kelly
 * @create 2020-07-02 14:20
 */
public class FlowCountSortReducer extends Reducer<FlowBean, Text, Text, FlowBean> {
    @Override
    protected void reduce(FlowBean key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        // 总流量  手机号

        // 循环写出
        for (Text value : values) {
            context.write(value, key);
        }
    }
}
