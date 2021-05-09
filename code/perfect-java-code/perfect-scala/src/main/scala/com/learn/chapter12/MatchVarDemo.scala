package com.learn.chapter12

/**
 * @author Kelly
 * @create 2021-05-09 17:39
 */
object MatchVarDemo {
  def main(args: Array[String]): Unit = {
    val (x, y, z) = (1, 2, "hello")
    println("x = " + x)

    val (q, r) = BigInt(10) /% 3 // q = BigInt(10) / 3, r = BigInt(10) % 3

    println("q = " + q + ", r = " + r)

    val arr = Array(1, 7, 2, 9)
    val Array(first, second, _*) = arr // 提出 arr 的前两个元素
    println(first, second)
  }

}
