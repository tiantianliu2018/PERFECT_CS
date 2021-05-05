package com.learn.chapter09

/**
 * @author Kelly
 * @create 2021-05-05 10:07
 */
object ImplicitDemo {
  def main(args: Array[String]): Unit = {

    // 隐式函数转成 Double->Int 转换
    implicit def f1(d: Double): Int = {
      d.toInt
    }

    implicit def f2(f: Float): Int = {
      f.toInt
    }

    val num: Int = 3.5
    val num2: Int = 4.5f

    println("num = " + num + "\t num2 = " + num2)

  }

}
