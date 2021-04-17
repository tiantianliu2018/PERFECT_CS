package com.learn.combiner;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * @author Kelly
 * @create 2020-07-01 13:49
 *
 * KEYIN: reduce 阶段输入的 key 类型，Text
 * VALUEIN：reduce 阶段输入 value 类型，IntWritable
 * KEYOUT：reduce 阶段输出 key 类型，Text
 * VALUEOUT：reduce 阶段输出 value 类型，IntWriteble
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
