package com.learn.chapter17.proxy.rmi

import java.rmi.Naming
import java.rmi.server.UnicastRemoteObject

/**
 * @author Kelly
 * @create 2021-05-14 16:04
 */
// 实现 trait MyRemote
class MyRemoteImpl extends UnicastRemoteObject with MyRemote {
  override def sayHello(): String = "Hello World~~"
}

// 完成对服务(sayHello)注册任务 -> 对服务管理
object MyRemoteImpl {
  def main(args: Array[String]): Unit = {
    val service: MyRemote = new MyRemoteImpl()

    Naming.rebind("rmi://127.0.0.1:9999/RemoteHello", service)
    println("远程服务开启，在 127.0.0.1 的 9999 端口监听，服务名 RemoteHello")

  }
}
