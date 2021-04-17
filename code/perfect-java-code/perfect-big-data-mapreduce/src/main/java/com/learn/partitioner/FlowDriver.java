package com.learn.partitioner;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;


/**
 * @author Kelly
 * @create 2021-04-06 15:45
 */
public class FlowDriver {
    public static void main(String[] args) throws Exception {
        // 1. 获取 job 对象
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf);

        // 2. 设置 jar 包
        job.setJarByClass(FlowDriver.class);

        // 3. 关联 mapper 和 reducer
        job.setMapperClass(FlowMapper.class);
        job.setReducerClass(FlowReducer.class);

        // 4. 设置 mapper 输出的 key 和 value 类型
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(FlowBean.class);

        // 5. 设置最终输出的 key 和 value 类型
        job.setOutputKeyClass(Text.class);
        job.setMapOutputValueClass(FlowBean.class);

        // 8. 指定自定义分区器
        job.setPartitionerClass(ProvincePartitioner.class);

        // 9. 指定相应数量的 reduceTask
        job.setNumReduceTasks(5);

        // 6. 设置数据的输入、输出路径
        FileInputFormat.setInputPaths(job, new Path("perfect-big-data-mapreduce/src/main/resources/files/phone_data.txt"));
        FileOutputFormat.setOutputPath(job, new Path("perfect-big-data-mapreduce/src/main/resources/partitioner_out"));

        // 7. 提交 job
        boolean result = job.waitForCompletion(true);
        System.exit(result ? 0 : 1);
    }
}
