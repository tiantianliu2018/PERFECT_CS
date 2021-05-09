package com.learn.chapter11

/**
 * @author Kelly
 * @create 2021-05-08 11:15
 */
object MapOperateDemo02 {

  def multiple(n: Int): Int = {
    println("multiple 被调用")
    n * 2
  }

  def main(args: Array[String]): Unit = {
    val list = List(3, 5, 7, 9)
    println("list = " + list)

    val list2 = list.map(multiple)
    println("list2 = " + list2)
  }

}
