package com.learn.chapter13

/**
 * @author Kelly
 * @create 2021-05-10 10:54
 *
 * 高阶函数
 */
object HigherOrderFunction {
  def main(args: Array[String]): Unit = {
    def test(f: Double => Double, f2: Double => Int, n1:Double) = {
      f(f2(n1))
    }

    def sum(d: Double): Double = {
      d + d
    }

    def mod(d: Double): Int = {
      d.toInt % 2
    }

    val res = test(sum, mod, 5.0)
    println("res = " + res)
  }

}
