package com.learn.combiner;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

/**
 * @author Kelly
 * @create 2020-06-30 13:50
 *
 * 1. 获取配置信息，获取 job 对象实例
 * 2. 指定本程序的 jar 包所在的本地路径
 * 3. 关联 Mapper/Reducer 业务类
 * 4. 指定 Mapper 输出数据的 k v 类型
 * 5. 指定最终输出的数据的 k v 类型
 * 6. 指定 job 的输入原始文件所在目录
 * 7. 指定 job 的输出结果所在目录
 * 8. 提交作业
 **/
public class WordCountDriver {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        // 获取 Job 对象
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf);

        // 设置 jar 包存储位置
        // 程序可以通过反射，找到相应的类
        job.setJarByClass(WordCountDriver.class);

        // 关联 mapper 和 reducer
        job.setMapperClass(WordCountMapper.class);
        job.setReducerClass(WordCountReducer.class);

        // 指定 Mapper 输出数据的 k v 类型
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);

        // 指定最终输出的数据的 k v 类型
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        job.setCombinerClass(WordCountCombiner.class);

        // 设置输入输出路径
        FileInputFormat.setInputPaths(job, new Path("perfect-big-data-mapreduce/src/main/resources/files/words.txt"));
        FileOutputFormat.setOutputPath(job, new Path("perfect-big-data-mapreduce/src/main/resources/combiner2"));

        // 提交任务
//        job.submit();
        boolean res = job.waitForCompletion(true);
        System.exit(res ? 0 : 1);
    }
}
