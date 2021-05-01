package com.learn.chapter05.func

/**
 * @author Kelly
 * @create 2021-04-27 11:15
 */
object Fibona {
  def main(args: Array[String]): Unit = {
    println("斐波那契数列的结果 = " + fbn(3))
    println("斐波那契数列的结果 = " + fbn(7))
  }

  def fbn(n:Int):Int = {
    if (n == 1 || n == 2) {
      1
    } else {
      fbn(n - 1) + fbn(n - 2)
    }
  }

}
