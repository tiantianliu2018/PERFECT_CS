package com.learn.chapter11

/**
 * @author Kelly
 * @create 2021-05-08 11:31
 */
object FilterDemo01 {
  def main(args: Array[String]): Unit = {
    /* 选出首字母为 A 的元素 */
    val names = List("Alice", "Bob", "Tom")
    val strings = names.filter(startA)

    println("names = " + names)
    println(("strings = " + strings))
  }

  def startA(str: String): Boolean = {
    str.startsWith("A")
  }

}
