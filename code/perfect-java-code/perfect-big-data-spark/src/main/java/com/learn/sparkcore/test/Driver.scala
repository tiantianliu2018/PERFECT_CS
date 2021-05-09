package com.learn.sparkcore.test

import java.io.{ObjectOutputStream, OutputStream}
import java.net.Socket

/**
 * @author Kelly
 * @create 2021-04-20 14:38
 */
object Driver {
  def main(args: Array[String]): Unit = {
    // 连接服务器
    val client1 = new Socket("localhost", 9999)
    val client2 = new Socket("localhost", 8888)

    val task = new Task()

    val out1: OutputStream = client1.getOutputStream
    val objOut1 = new ObjectOutputStream(out1)

    val subTask = new SubTask
    subTask.logic = task.logic
    subTask.data = task.data.take(2)

    // 发送数据，输出内容
    objOut1.writeObject(subTask)
    objOut1.flush()
    objOut1.close()

    client1.close()
    println("客户端 1 数据发送完毕。")

    val out2: OutputStream = client2.getOutputStream
    val objOut2 = new ObjectOutputStream(out2)

    val subTask2 = new SubTask
    subTask2.logic = task.logic
    subTask2.data = task.data.takeRight(2)

    objOut2.writeObject(subTask2)
    objOut2.flush()
    objOut2.close()

    client2.close()
    println("客户端 2 数据发送完毕。")
  }

}