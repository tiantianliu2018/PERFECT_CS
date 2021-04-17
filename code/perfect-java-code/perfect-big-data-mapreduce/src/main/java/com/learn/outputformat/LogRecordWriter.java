package com.learn.outputformat;

import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.RecordWriter;
import org.apache.hadoop.mapreduce.TaskAttemptContext;

import java.io.IOException;

/**
 * @author Kelly
 * @create 2021-04-09 14:44
 */
public class LogRecordWriter extends RecordWriter<Text, NullWritable> {

    private FSDataOutputStream dataOutputStream;
    private FSDataOutputStream otherOutputStream;

    public LogRecordWriter(TaskAttemptContext job) {
        // 创建两条流
        try {
            FileSystem fileSystem = FileSystem.get(job.getConfiguration());
            dataOutputStream = fileSystem.create(new Path("perfect-big-data-mapreduce/src/main/resources/logout/baidu"));
            otherOutputStream = fileSystem.create(new Path("perfect-big-data-mapreduce/src/main/resources/logout/others"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void write(Text key, NullWritable value) throws IOException, InterruptedException {
        // 具体写
        String log = key.toString();
        if (log.contains("baidu")) {
            dataOutputStream.writeBytes(log + "\n");
        } else {
            otherOutputStream.writeBytes(log + "\n");
        }
    }

    public void close(TaskAttemptContext context) throws IOException, InterruptedException {
        IOUtils.closeStream(dataOutputStream);
        IOUtils.closeStream(otherOutputStream);
    }
}
