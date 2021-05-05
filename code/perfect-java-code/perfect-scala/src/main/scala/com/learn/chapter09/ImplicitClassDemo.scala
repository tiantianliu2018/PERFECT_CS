package com.learn.chapter09

/**
 * @author Kelly
 * @create 2021-05-05 10:26
 */
object ImplicitClassDemo {
  def main(args: Array[String]): Unit = {

    // 创建一个隐式类
    implicit class DB1(val m: MySQL1) {
      def addSuffix(): String = {
        m + " scala"
      }
    }

    // 创建一个 MySQL1 类的实例
    val sql1 = new MySQL1
    sql1.sayOk()
    sql1.addSuffix()   // 调用了原本隐式类中的方法
  }

}

class DB1 {

}

class MySQL1 {
  def sayOk(): Unit = {
    println("OK~~")
  }
}
