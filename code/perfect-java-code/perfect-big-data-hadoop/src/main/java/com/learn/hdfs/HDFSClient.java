package com.learn.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.util.Arrays;

/**
 * @author Kelly
 * @create 2021-04-01 10:59
 *
 * 客户端代码：
 * 1. 获取客户端对象
 * 2. 执行相关操作命令
 * 3. 关闭资源
 */
public class HDFSClient {

    private FileSystem fileSystem;

    @Before
    public void init() throws Exception {
        // 连接的集群 nn 地址
        URI uri = new URI("hdfs://localhost:9000");

        // 创建配置文件
        Configuration conf = new Configuration();

        // 用户
        String user = "ttl";
        // 1.获取到客户端对象
        fileSystem = FileSystem.get(uri, conf, user);
    }

    @After
    public void close() throws IOException {
        // 3. 关闭资源
        fileSystem.close();
    }

    @Test
    public void testmkdir() throws Exception {
        // 2.执行操作
        fileSystem.mkdirs(new Path("/xiyou/huaguoshan"));
    }

    @Test
    public void testPut() throws Exception {
        // 参数解读：1：删除原数据；2：是否删除原数据；3：原数据路径；4：目标路径
        fileSystem.copyFromLocalFile(false, false, new Path("/usr/local/Cellar/hadoop/3.2.1_1/sunwukong.txt"), new Path("/xiyou/huaguoshan/"));
    }

    @Test
    public void testListFiles() throws Exception {
        // 获取所有文件信息
        RemoteIterator<LocatedFileStatus> files = fileSystem.listFiles(new Path("/"), true);
        while (files.hasNext()) {
            LocatedFileStatus fileStatus = files.next();
            System.out.println("==========" + fileStatus.getPath() + "=========");
            System.out.println(fileStatus.getPermission());
            System.out.println(fileStatus.getOwner());
            System.out.println(fileStatus.getGroup());
            System.out.println(fileStatus.getLen());
            System.out.println(fileStatus.getModificationTime());
            System.out.println(fileStatus.getReplication());
            System.out.println(fileStatus.getBlockSize());
            System.out.println(fileStatus.getPath().getName());

            // 获取块信息
            BlockLocation[] blockLocations = fileStatus.getBlockLocations();
            System.out.println(Arrays.toString(blockLocations) );
        }


    }
}
