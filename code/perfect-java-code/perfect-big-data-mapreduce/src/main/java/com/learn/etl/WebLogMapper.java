package com.learn.etl;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * @author Kelly
 * @create 2021-04-13 10:46
 */
public class WebLogMapper extends Mapper<LongWritable, Text, Text, NullWritable> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        // 获取一行
        String line = value.toString();

        // ETL
        boolean result = parseLog(line, context);
        if (!result) {
            return;
        }

        // 写出
        context.write(value, NullWritable.get());
    }

    private boolean parseLog(String line, Context context) {
        // 切割
        String[] fields = line.split(" ");

        // 判断日志的长度
        if (fields.length > 11) {
            return true;
        }

        return false;
    }
}
