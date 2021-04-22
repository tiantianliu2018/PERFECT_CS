package com.learn.chapter04.myfor

/**
 * @author Kelly
 * @create 2021-04-22 10:18
 */
object ForDemo {
  def main(args: Array[String]): Unit = {
    val start = 1
    val end = 5

    // to []
    for (i <- start to end) {
      println("Hello~ " + i)
    }

    // until [)
    for (i <- 1 until 3) {
      print(i + " ")
    }
    println()

    // 循环守卫
    for (i <- 1 to 3 if i != 2) {
      print(i + " ")
    }
    println()

    // 引入变量
    for (i <- 1 to 3; j = 4 - i) {
      print(j + " ")
    }
    println()

    // 循环嵌套
    for (i <- 1 to 3; j <- 1 to 3) {
      println("i = " + i + " j = " + j)
    }

    // 循环返回值
    val res = for(i <- 1 to 10) yield i
    println(res)

  }

}
