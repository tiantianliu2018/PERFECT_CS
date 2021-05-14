package com.learn.chapter17.proxy.rmi

import java.rmi.{Remote, RemoteException}

/**
 * @author Kelly
 * @create 2021-05-14 11:57
 */
// 远程接口
trait MyRemote extends Remote {

  @throws(classOf[RemoteException])
  def sayHello(): String
}
