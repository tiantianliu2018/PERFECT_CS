package com.learn.chapter11

/**
 * @author Kelly
 * @create 2021-05-09 10:18
 */
object ZipDemo01 {
  def main(args: Array[String]): Unit = {
    val list1 = List(1, 2, 3)
    val list2 = List(4, 5, 6)
    val list3 = list1.zip(list2)
    println("list3 = " + list3)

    // 遍历合并元素
    for (item <- list3) {
      println(item._1 + " " + item._2)
    }
  }

}
