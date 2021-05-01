package com.learn.chapter05.func

/**
 * @author Kelly
 * @create 2021-04-27 15:41
 */
object LazyDemo {

  def sum(n1: Int, n2: Int):Int = {
    println("sum() 执行了...")
    n1 + n2
  }

  def main(args: Array[String]): Unit = {
    lazy val res = sum(10, 20)
    println("-------------------")
    println("res = " + res)
  }

}
