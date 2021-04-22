package com.learn.sparkcore.test

import java.io.{InputStream, ObjectInputStream}
import java.net.{ServerSocket, Socket}

/**
 * @author Kelly
 * @create 2021-04-20 15:23
 */
object Executor2 {
  def main(args: Array[String]): Unit = {
    // 启动服务器，接收数据
    val server = new ServerSocket(8888)
    println("服务器启动，等待接收数据...")

    // 等待客户端的连接
    val client:Socket  = server.accept()

    val in: InputStream = client.getInputStream
    val objIn = new ObjectInputStream(in)

    val subTask:SubTask = objIn.readObject().asInstanceOf[SubTask]

    val res = subTask.calculate()

    println("计算节点 [8888] 计算的结果为：" + res)

    in.close()
    objIn.close()
    client.close()
    server.close()
  }
}
