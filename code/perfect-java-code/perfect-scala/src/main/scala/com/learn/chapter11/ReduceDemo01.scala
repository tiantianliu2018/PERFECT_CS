package com.learn.chapter11

/**
 * @author Kelly
 * @create 2021-05-08 11:34
 */
object ReduceDemo01 {

  def sum(n1: Int, n2: Int): Int = {
    println("sum 函数被调用")
    n1 + n2
  }

  def main(args: Array[String]): Unit = {
    val list = List(1, 20, 30, 4, 5)
    val res = list.reduceLeft(sum)

    println("res = " + res)

  }

}
