package com.learn.chapter11

/**
 * @author Kelly
 * @create 2021-05-08 11:23
 */
object FlatMapDemo01 {
  def main(args: Array[String]): Unit = {
    val names = List("Alice", "Bob", "Nick")

    // 将 List 集合中的所有元素，进行扁平化操作，即把所有元素打散
    val upNames = names.flatMap(upper)
    println("upNames = " + upNames)
  }

  def upper(name: String): String = {
    name.toUpperCase
  }

}
