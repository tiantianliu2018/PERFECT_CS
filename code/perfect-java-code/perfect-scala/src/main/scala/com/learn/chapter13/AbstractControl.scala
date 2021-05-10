package com.learn.chapter13

/**
 * @author Kelly
 * @create 2021-05-10 11:31
 */
object AbstractControl {
  def main(args: Array[String]): Unit = {
    def myRunInThread(f1: () => Unit) = {
      new Thread {
        override def run(): Unit = f1
      }.start()
    }

    myRunInThread {
      () => println("干活咯！5 秒完成...")
        Thread.sleep(5000)
        println("干完咯！")

    }

    def myRunInThread2(f1: Unit): Unit = {
      new Thread {
        override def run(): Unit = f1
      }.start()
    }
    // 对于没有输入，也没有返回值函数，可以简写成如下形式
    myRunInThread2 {
      println("干活咯！5 秒完成...~~~")
      Thread.sleep(5000)
      println("干完咯！~~~")
    }
  }
}
