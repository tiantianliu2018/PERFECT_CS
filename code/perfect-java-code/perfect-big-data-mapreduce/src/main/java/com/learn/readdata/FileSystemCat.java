package com.learn.readdata;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

/**
 * @author Kelly
 * @create 2021-03-22 14:33
 */
public class FileSystemCat {
    public static void main(String[] args) throws Exception {
        String uri = "hdfs://localhost/test";
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(URI.create(uri), conf);
        InputStream in = null;
        try {
            in = fs.open(new Path(uri));
            IOUtils.copyBytes(in, System.out,4096, false);
        } finally {
            IOUtils.closeStream(in);
        }
    }
}