package com.learn.rpc;

/**
 * @author Kelly
 * @create 2021-04-15 10:28
 */
public interface RPCProtocol {
    long versionID = 666;

    void mkdirs(String path);
}
