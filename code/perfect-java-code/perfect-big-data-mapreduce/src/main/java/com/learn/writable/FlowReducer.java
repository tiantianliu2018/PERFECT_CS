package com.learn.writable;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * @author Kelly
 * @create 2021-04-06 15:41
 */
public class FlowReducer extends Reducer<Text, FlowBean, Text, FlowBean> {
    private FlowBean outV = new FlowBean();

    @Override
    protected void reduce(Text key, Iterable<FlowBean> values, Context context) throws IOException, InterruptedException {
        // 遍历集合，累加值
        long totalUp = 0;
        long totalDown = 0;

        for (FlowBean value : values) {
            totalUp += value.getUpFlow();
            totalDown += value.getDownFlow();
        }
        // 封装 outK，outV
        outV.setUpFlow(totalUp);
        outV.setDownFlow(totalDown);
        outV.setSumFlow();

        // 写出
        context.write(key, outV);
    }
}
