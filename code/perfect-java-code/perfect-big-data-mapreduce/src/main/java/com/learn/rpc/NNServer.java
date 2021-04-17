package com.learn.rpc;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;

import java.io.IOException;

/**
 * @author Kelly
 * @create 2021-04-15 10:29
 */
// 实现通讯接口
public class NNServer implements RPCProtocol{
    public static void main(String[] args) throws IOException {
        // 启动服务
        // 创建服务器对象
        RPC.Server server = new RPC.Builder(new Configuration())
                .setBindAddress("localhost")
                .setPort(8898)
                .setProtocol(RPCProtocol.class)
                .setInstance(new NNServer())
                .build();

        System.out.println("服务器开始工作");
        server.start();
    }

    public void mkdirs(String path) {
        System.out.println("服务器接收到了客户端请求 " + path);

    }
}
