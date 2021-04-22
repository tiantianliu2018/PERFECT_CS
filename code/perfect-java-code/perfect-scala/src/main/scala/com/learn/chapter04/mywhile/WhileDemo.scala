package com.learn.chapter04.mywhile

/**
 * @author Kelly
 * @create 2021-04-22 10:56
 */
object WhileDemo {
  def main(args: Array[String]): Unit = {
    var i = 0
    while (i < 10) {
      print(i + " ")
      i += 1
    }
    println()
  }

}
