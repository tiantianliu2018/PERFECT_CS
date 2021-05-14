package com.learn.chapter17.proxy.rmi

import java.rmi.Naming

/**
 * @author Kelly
 * @create 2021-05-14 16:08
 */
class MyRemoteClient {
  def go(): Unit = {
    val service = Naming.lookup("rmi://127.0.0.1:9999/RemoteHello").asInstanceOf[MyRemote]
    val str = service.sayHello()
    println("str = " + str)
  }

}

object MyRemoteClient {
  def main(args: Array[String]): Unit = {
    new MyRemoteClient().go()
  }
}
