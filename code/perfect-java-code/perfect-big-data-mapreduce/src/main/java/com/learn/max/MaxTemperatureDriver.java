package com.learn.max;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.mapreduce.Job;

import java.io.IOException;

/**
 * @author Kelly
 * @create 2021-03-19 11:04
 */
public class MaxTemperatureDriver {
    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.out.println("Usage: MaxTemperature <input path> <output path>");
            System.exit(-1);
        }
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf);

        // 指定 jar 包路径
        job.setJarByClass(MaxTemperatureDriver.class);
        job.setJobName("Max temperature");

        // 关联两个类
        job.setMapperClass(MaxTemperatureMapper.class);
        job.setReducerClass(MaxTemperatureReducer.class);


    }
}
