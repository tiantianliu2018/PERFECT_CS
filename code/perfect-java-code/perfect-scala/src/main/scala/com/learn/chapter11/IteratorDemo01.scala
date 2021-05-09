package com.learn.chapter11

/**
 * @author Kelly
 * @create 2021-05-09 10:21
 *
 * 迭代器
 * 通过 while 循环和 for 表达式对集合进行遍历
 */
object IteratorDemo01 {
  def main(args: Array[String]): Unit = {
    // list 转成一个迭代器
    val iterator = List(1, 2, 3, 4, 5).iterator

    println("-------- 遍历方式 1 while -----------------")
    while (iterator.hasNext) {
      println(iterator.next)
    }

    println("-------- 遍历方式 2 for -----------------")
    for (item <- iterator) {
      println(item)
      println("*")
    }
  }

}
