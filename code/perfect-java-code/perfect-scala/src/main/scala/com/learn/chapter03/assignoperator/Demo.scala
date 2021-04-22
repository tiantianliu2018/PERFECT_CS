package com.learn.chapter03.assignoperator

/**
 * @author Kelly
 * @create 2021-04-21 10:23
 */
object Demo {
  def main(args: Array[String]): Unit = {
    var num = 2
    num <<= 2
    println("num = " + num)

    num >>= 3
    println("num = " + num)

    val res = {
      if (num >= 1) "hello, ok" else 100
    }

    println("res = " + res)

    var a = 100
    var b = 10
    a = a + b
    b = a - b
    a = a - b
    println(s"a = ${a}, b = ${b}")
  }

}
