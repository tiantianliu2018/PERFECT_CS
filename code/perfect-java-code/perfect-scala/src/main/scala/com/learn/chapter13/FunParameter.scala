package com.learn.chapter13

/**
 * @author Kelly
 * @create 2021-05-10 10:34
 *
 * 函数参数
 */
object FunParameter {
  def main(args: Array[String]): Unit = {
    def plus(x: Int) = 3 + x

    val result = Array(1, 2, 3, 4).map(plus(_))
    println(result.mkString(","))

    println("plus 的函数类型 function1 = " + (plus _))
  }

}
