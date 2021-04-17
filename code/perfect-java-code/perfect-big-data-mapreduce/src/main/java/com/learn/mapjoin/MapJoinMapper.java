package com.learn.mapjoin;

import org.apache.commons.lang3.StringUtils;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.HashMap;

/**
 * @author Kelly
 * @create 2021-04-12 15:40
 */
public class MapJoinMapper extends Mapper<LongWritable, Text, Text, NullWritable> {

    private Text outKey = new Text();
    private HashMap<String, String> pdCacheMap = new HashMap<String, String>();

    // 初始化方法
    @Override
    protected void setup(Context context) throws IOException, InterruptedException {
        // 获取缓存的文件，并把文件内容封装到集合中  pd.txt
        URI[] cacheFiles = context.getCacheFiles();
        FileSystem fs = FileSystem.get(context.getConfiguration());
        FSDataInputStream fis = fs.open(new Path(cacheFiles[0]));

        // 从流中读取数据
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fis, "UTF-8"));

        String line;
        while (StringUtils.isNoneEmpty(line = bufferedReader.readLine())) {
            // 切割
            String[] fields = line.split("\t");

            pdCacheMap.put(fields[0], fields[1]);
        }

        // 关流
        IOUtils.closeStream(bufferedReader);
    }

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        // 处理 order.txt
        String[] fields = value.toString().split("\t");

        // 获取 pid
        String pname = pdCacheMap.get(fields[1]);

        // 获取订单 id 和订单数量
        outKey.set(fields[0] + "\t" + pname + "\t" + fields[2]);
        context.write(outKey, NullWritable.get());
    }
}
