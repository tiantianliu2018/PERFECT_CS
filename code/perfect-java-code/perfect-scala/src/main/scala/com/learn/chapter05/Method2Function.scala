package com.learn.chapter05

/**
 * @author Kelly
 * @create 2021-04-27 10:09
 */
object Method2Function {
  def main(args: Array[String]): Unit = {
    // 使用方法
    println(sum(10, 20))

    // 方法转函数
    val sum_func = sum _
    println("sum_func = " + sum_func)
    println("f1 = " + sum_func(50, 60))

    // 函数，求两个整数的和
    val f2 = (n1:Int, n2:Int) => n1 + n2
    println("f2 = " + f2(10, 12))

  }


  // 方法
  def sum(n1:Int, n2:Int): Int = {
    n1 + n2
  }

}
