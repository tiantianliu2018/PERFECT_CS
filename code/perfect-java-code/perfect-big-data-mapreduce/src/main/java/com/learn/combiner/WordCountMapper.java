package com.learn.combiner;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * @author Kelly
 * @create 2020-06-30 13:49
 *
 * 1. 将 MapTask 传给我们的文本 内容先转换成 String
 * 2. 根据空格将这一行切分成单词
 * 3. 将单词输出为 <单词，1>
 */

/**
 * Mapper 输入数据的偏移量  输入数据类型  输出数据 key 的类型    输出数据 value 的类型
 */
public class WordCountMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
    private Text k = new Text();
    private IntWritable v = new IntWritable(1);

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        //  一次读取一行 Text -> String
        String line = value.toString();

        // 字符串数组
        String[] words = line.split(" ");

        // 循环写出
        for (String word : words) {
            // “hello”
            k.set(word);
            context.write(k, v);
        }
    }
}
