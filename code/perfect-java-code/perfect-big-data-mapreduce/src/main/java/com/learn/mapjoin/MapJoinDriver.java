package com.learn.mapjoin;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author Kelly
 * @create 2021-04-12 16:05
 */
public class MapJoinDriver {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException, URISyntaxException {
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf);

        job.setJarByClass(MapJoinDriver.class);
        job.setMapperClass(MapJoinMapper.class);

        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(NullWritable.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(NullWritable.class);

        job.addCacheFile(new URI("perfect-big-data-mapreduce/src/main/resources/join_input/pd.txt"));
        job.setNumReduceTasks(0);

        FileInputFormat.setInputPaths(job, new Path("perfect-big-data-mapreduce/src/main/resources/join_input/order.txt"));
        FileOutputFormat.setOutputPath(job, new Path("perfect-big-data-mapreduce/src/main/resources/map_join_out"));

        boolean result = job.waitForCompletion(true);
        System.exit(result ? 0 : 1);

    }
}
