package com.learn.chapter13

/**
 * @author Kelly
 * @create 2021-05-10 10:59
 */
object HigherOrderFunction2 {
  def main(args: Array[String]): Unit = {
    def minusxy(x: Int) = {
      (y: Int) => x - y  // 匿名函数
    }

    val f1 = minusxy(3)
    println("f1 的类型 = " + f1)

    println("f1(1) = " + f1(1))

    println("f1(9) = " + f1(9))

    println(minusxy(4)(9))
  }

}
