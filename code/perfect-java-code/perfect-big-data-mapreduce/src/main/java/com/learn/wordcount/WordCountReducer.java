package com.learn.wordcount;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * @author Kelly
 * @create 2020-07-01 13:49
 */
public class WordCountReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
    IntWritable v = new IntWritable();
    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        // 循环遍历 vlaues 进行累加求和
        int sum = 0;
        for (IntWritable value : values) {
            sum += value.get();
        }
        // 输出
        v.set(sum);
        context.write(key, v);
    }
}
