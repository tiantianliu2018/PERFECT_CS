package com.learn.chapter11

/**
 * @author Kelly
 * @create 2021-05-08 11:19
 */
object Exercise01 {

  def upper(name: String): String = {
    println("调用转换为大写字母的方法")
    name.toUpperCase
  }

  def main(args: Array[String]): Unit = {
    val names = List("Alice", "Bob", "Nick")
    val UpNames = names.map(upper)
    println("up_names = " + UpNames)
  }

}
